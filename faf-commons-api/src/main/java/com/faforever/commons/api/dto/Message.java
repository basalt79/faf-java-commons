package com.faforever.commons.api.dto;


import com.faforever.commons.api.elide.ElideEntity;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Data;

@Data
@Type("message")
public class Message implements ElideEntity {
  @Id
  private String id;
  private String key;
  private String language;
  private String region;
  private String value;
}
