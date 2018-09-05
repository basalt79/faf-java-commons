package com.faforever.commons.api.dto;

import com.faforever.commons.api.elide.ElideEntity;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@RestrictedVisibility("IsModerator")
@Getter
@Setter
@EqualsAndHashCode(of = "domain")
@Type("domainBlacklist")
public class DomainBlacklist implements ElideEntity {
  @Id
  String domain;

  @Override
  public String getId() {
    return domain;
  }
}
