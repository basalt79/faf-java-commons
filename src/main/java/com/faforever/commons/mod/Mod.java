package com.faforever.commons.mod;

import lombok.Data;
import org.apache.maven.artifact.versioning.ComparableVersion;

import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Data
public class Mod {

  private String id;
  private String name;
  private String description;
  private String author;
  private boolean selectable;
  private boolean uiOnly;
  private ComparableVersion version;
  private URL thumbnailUrl;
  private Path imagePath;
  private final List<MountPoint> mountPoints = new ArrayList<>();
  private final List<String> hookDirectories = new ArrayList<>();
}
