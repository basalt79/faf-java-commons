package com.faforever.commons.api.dto;

import com.github.jasminb.jsonapi.annotations.Relationship;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review extends AbstractEntity {
    private String text;
    private Byte score;

    @Relationship("player")
    private Player player;
}
