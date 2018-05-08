package com.faforever.commons.api.dto;

import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Data;

import java.util.List;

@Data
@Type("tutorialCategory")
public class TutorialCategory {
  @Id
  private String id;
  private String categoryKey;
  private String category;
  @Relationship("tutorials")
  private List<Tutorial> tutorials;
}
