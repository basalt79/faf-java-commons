package com.faforever.commons.api.dto;

import com.faforever.commons.api.elide.ElideEntity;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id"})
@Type("achievement")
public class AchievementDefinition implements ElideEntity {

    @Id
    private String id;
    private String description;
    private int experiencePoints;
    private AchievementState initialState;
    private String name;
    private String revealedIconUrl;
    private Integer totalSteps;
    private AchievementType type;
    private String unlockedIconUrl;
    private int order;
}
