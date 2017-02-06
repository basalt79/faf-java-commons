package com.faforever.commons.fa;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ForgedAllianceExePatcherTest {

  @Rule
  public TemporaryFolder fafBinDirectory = new TemporaryFolder();

  @Test
  public void updateVersionInExe() throws Exception {
    Path dummyExe = fafBinDirectory.getRoot().toPath().resolve("ForgedAlliance.exe");
    createFileWithSize(dummyExe, 12_444_928);
    ForgedAllianceExePatcher.patchVersion(dummyExe, 3660);

    assertThat(Files.hash(dummyExe.toFile(), Hashing.md5()).toString(), is("4de5eed29b45b640fe64aa22808631c3"));
  }

  private void createFileWithSize(Path file, int size) throws IOException {
    try (RandomAccessFile randomAccessFile = new RandomAccessFile(file.toFile(), "rw")) {
      randomAccessFile.setLength(size);
    }
  }
}
