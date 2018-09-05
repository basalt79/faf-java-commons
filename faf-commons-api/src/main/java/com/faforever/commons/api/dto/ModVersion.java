package com.faforever.commons.api.dto;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Type("modVersion")
public class ModVersion extends AbstractEntity {
    private String uid;
    private ModType type;
    private String description;
    private short version;
    private String filename;
    private String icon;
    private boolean ranked;
    private boolean hidden;
    private URL thumbnailUrl;
    private URL downloadUrl;

    @Relationship("mod")
    private Mod mod;
}
