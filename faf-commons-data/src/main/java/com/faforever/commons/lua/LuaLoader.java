package com.faforever.commons.lua;

import com.google.common.io.CharStreams;
import lombok.SneakyThrows;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class LuaLoader {

  private LuaLoader() {
    throw new AssertionError("Not instantiatable");
  }

  public static LuaValue loadFile(Path file) throws IOException {
    try (InputStream inputStream = Files.newInputStream(file)) {
      return load(inputStream);
    }
  }

  @SneakyThrows
  public static LuaValue load(InputStream inputStream) {
    Globals globals = JsePlatform.standardGlobals();
    try (InputStreamReader inputStreamReader = new InputStreamReader(LuaLoader.class.getResourceAsStream("/lua/faf.lua"), StandardCharsets.UTF_8)) {
      globals.baselib.load(globals.load(CharStreams.toString(inputStreamReader)));
      globals.load(inputStream, "@" + inputStream.hashCode(), "bt", globals).invoke();
      return globals;
    }
  }
}
