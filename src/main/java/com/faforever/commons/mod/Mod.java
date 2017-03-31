package com.faforever.commons.mod;

import lombok.Data;
import org.apache.maven.artifact.versioning.ComparableVersion;

import java.util.ArrayList;
import java.util.List;

@Data
public class Mod {

  private String name;
  private String uid;
  private ComparableVersion version;
  private String copyright;
  private String icon;
  private String description;
  private String author;
  private boolean selectable;
  private boolean uiOnly;
  private final List<MountPoint> mountPoints = new ArrayList<>();
  private final List<String> hookDirectories = new ArrayList<>();
}
