package com.faforever.commons.api;

import com.faforever.commons.api.dto.AbstractEntity;
import lombok.SneakyThrows;
import org.junit.Test;
import pl.pojo.tester.api.PackageFilter;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.internal.utils.ReflectionUtils;

import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class AllDtoTest {

  @Test
  public void allDto() {
    // TODO test getter and setter
    Assertions.assertPojoMethodsForAll(new DtoFilter()).quickly();
  }

  private static class DtoFilter implements PackageFilter {

    @Override
    @SneakyThrows
    public Class<?>[] getClasses() {
      return Stream.of(ReflectionUtils.getClassesFromPackage(AbstractEntity.class.getPackage().getName()))
        .filter(aClass -> !aClass.isEnum() && !Modifier.isAbstract(aClass.getModifiers()))
        .toArray(Class[]::new);
    }
  }
}
