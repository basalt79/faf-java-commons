package com.faforever.commons.fa;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Path;

@Slf4j
public final class ForgedAllianceExePatcher {

  private static final int[] VERSION_ADDRESSES = new int[]{0xd3d40, 0x47612d, 0x476666};

  private ForgedAllianceExePatcher() {
    // private
  }

  @SneakyThrows
  public static void patchVersion(Path exePath, int version) {
    byte[] versionAsLittleEndianBytes = toLittleEndianByteArray(version);
    try (RandomAccessFile randomAccessFile = new RandomAccessFile(exePath.toFile(), "rw")) {
      log.debug("Updating version in {} to {}", exePath, version);
      for (int versionAddress : VERSION_ADDRESSES) {
        randomAccessFile.seek(versionAddress);
        randomAccessFile.write(versionAsLittleEndianBytes);
      }
    }
  }

  private static byte[] toLittleEndianByteArray(int i) {
    return ByteBuffer.allocate(Integer.SIZE / Byte.SIZE).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array();
  }
}
