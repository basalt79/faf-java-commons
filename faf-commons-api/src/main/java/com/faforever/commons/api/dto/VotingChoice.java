package com.faforever.commons.api.dto;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Type(VotingChoice.TYPE_NAME)
public class VotingChoice extends AbstractEntity {
  public static final String TYPE_NAME = "votingChoice";

  private String choiceTextKey;
  private String choiceText;
  private String descriptionKey;
  private String description;
  private Integer numberOfAnswers;
  private Integer ordinal;
  @Relationship("votingQuestion")
  private VotingQuestion votingQuestion;
}
