package com.faforever.commons.api.dto;

import com.github.jasminb.jsonapi.annotations.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class AbstractEntity {
  @Id
  protected String id;
  protected OffsetDateTime createTime;
  protected OffsetDateTime updateTime;

  /**
   * Supplement method for @EqualsAndHashCode
   * overriding the default lombok implementation
   */
  protected boolean canEqual(Object other) {
    return other instanceof AbstractEntity && this.getClass() == other.getClass();
  }
}
