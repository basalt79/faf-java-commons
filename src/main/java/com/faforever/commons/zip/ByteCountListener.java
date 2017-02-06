package com.faforever.commons.zip;

// TODO: move to shared faf code
public interface ByteCountListener {

  void updateBytesWritten(long written, long total);
}
