package com.faforever.commons.api.dto;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Data;

@Data
@Type("tutorial")
public class Tutorial extends AbstractEntity {
  private String description;
  private String title;
  private String category;
  private String thumbnailUrl;
  private int ordinal;
  private boolean launchable;
  @Relationship("mapVersion")
  private MapVersion mapVersion;
}