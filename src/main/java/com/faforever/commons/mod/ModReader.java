package com.faforever.commons.mod;

import com.faforever.commons.lua.LuaLoader;
import com.google.common.base.Strings;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.artifact.versioning.ComparableVersion;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ModReader {

  @SneakyThrows
  public Mod extractModInfo(Path path) {
    Path modInfoLua = path.resolve("mod_info.lua");
    log.debug("Reading mod {}", path);
    if (Files.notExists(modInfoLua)) {
      throw new ModLoadException("Missing mod_info.lua in: " + path.toAbsolutePath());
    }

    try (InputStream inputStream = Files.newInputStream(modInfoLua)) {
      return extractModInfo(inputStream, path);
    }
  }

  public Mod extractModInfo(InputStream inputStream, Path basePath) {
    Mod mod = new Mod();

    try {
      LuaValue luaValue = LuaLoader.load(inputStream);

      mod.setId(luaValue.get("uid").toString());
      mod.setName(luaValue.get("name").toString());
      mod.setDescription(luaValue.get("description").toString());
      mod.setAuthor(luaValue.get("author").toString());
      mod.setVersion(new ComparableVersion(luaValue.get("version").toString()));
      mod.setSelectable(luaValue.get("selectable").toboolean());
      mod.setUiOnly(luaValue.get("ui_only").toboolean());
      mod.setImagePath(extractIconPath(basePath, luaValue));

      ArrayList<MountPoint> mountPoints = new ArrayList<>();
      LuaTable mountpoints = luaValue.get("mountpoints").opttable(LuaValue.tableOf());
      for (LuaValue key : mountpoints.keys()) {
        mountPoints.add(new MountPoint(basePath.resolve(key.tojstring()), mountpoints.get(key).tojstring()));
      }
      mod.getMountPoints().addAll(mountPoints);

      List<String> hookDirectories = new ArrayList<>();
      LuaTable hooks = luaValue.get("hooks").opttable(LuaValue.tableOf());
      for (LuaValue key : hooks.keys()) {
        hookDirectories.add(hooks.get(key).tojstring());
      }
      mod.getHookDirectories().addAll(hookDirectories);
    } catch (LuaError e) {
      throw new ModLoadException(e);
    }

    return mod;
  }

  private static Path extractIconPath(Path basePath, LuaValue luaValue) {
    String icon = luaValue.get("icon").toString();
    if ("nil".equals(icon) || Strings.isNullOrEmpty(icon)) {
      return null;
    }

    if (icon.startsWith("/")) {
      icon = icon.substring(1);
    }

    Path iconPath = Paths.get(icon);
    // FIXME try-catch until I know exactly what's the value that causes #228
    try {
      // mods/BlackOpsUnleashed/icons/yoda_icon.bmp -> icons/yoda_icon.bmp
      iconPath = iconPath.subpath(2, iconPath.getNameCount());
    } catch (IllegalArgumentException e) {
      log.warn("Can't load icon for mod '{}', path: {}", basePath, iconPath);
      return null;
    }

    return basePath.resolve(iconPath);
  }
}
