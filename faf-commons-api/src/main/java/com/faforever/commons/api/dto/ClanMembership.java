package com.faforever.commons.api.dto;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Data;

@Data
@Type("clanMembership")
public class ClanMembership extends AbstractEntity {
    @Relationship("clan")
    private Clan clan;

    @Relationship("player")
    private Player player;
}
