package com.faforever.commons.api.dto;


import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Data;

@Data
@Type("tutorial")
public class Message {
  @Id
  private String id;
  private String key;
  private String language;
  private String region;
  private String value;
}
