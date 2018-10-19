package com.faforever.commons.api.dto;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TutorialTest {


  @Test
  public void testTutorialToString() {
    Tutorial tutorial = new Tutorial();
    Tutorial secondTutorial = new Tutorial();
    TutorialCategory category = new TutorialCategory();
    tutorial.setCategory(category);
    category.setTutorials(Arrays.asList(tutorial, secondTutorial));
    assertThat("correct to string", tutorial.toString(), is(notNullValue()));
  }

  @Test
  public void testTutorialCategoryToString() {
    TutorialCategory tutorialCategory = new TutorialCategory();
    tutorialCategory.setId(randomAlphabetic(10));
    tutorialCategory.setCategory(randomAlphabetic(10));
    tutorialCategory.setCategoryKey(randomAlphabetic(10));

    Tutorial tutorial = new Tutorial();
    tutorial.setCategory(tutorialCategory);
    tutorialCategory.setTutorials(Collections.singletonList(tutorial));
    assertThat("correct to string", tutorialCategory.toString(),
      is(String.format("TutorialCategory(id=%s, categoryKey=%s, category=%s)", tutorialCategory.getId(),
        tutorialCategory.getCategoryKey(), tutorialCategory.getCategory())));
  }

}
