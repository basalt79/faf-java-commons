package com.faforever.commons.mod;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MountPoint {

  /**
   * The directory on the local file system that should be mounted into the virtual file system of the preferences.
   */
  private final String directory;

  /**
   * The absolute mount path (starting with {@code /}) to which the directory returned by {@link #getDirectory()} should
   * be mounted to.
   */
  private final String mountPath;
}
