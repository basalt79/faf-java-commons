package com.faforever.commons.api.dto;


import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Data;

@Data
@Type("playerAchievement")
public class PlayerAchievement extends AbstractEntity {
    private AchievementState state;
    private Integer currentSteps;

    @Relationship("achievement")
    private AchievementDefinition achievement;
}
