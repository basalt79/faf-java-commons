package com.faforever.commons.api.dto;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Type(VotingQuestion.TYPE_NAME)
public class VotingQuestion extends AbstractEntity {
  public static final String TYPE_NAME = "votingQuestion";

  private int numberOfAnswers;
  private String question;
  private String description;
  private String questionKey;
  private String descriptionKey;
  private Integer maxAnswers;
  private Integer ordinal;
  private Boolean alternativeQuestion;
  @Relationship("votingSubject")
  private VotingSubject votingSubject;
  @Relationship("winners")
  private List<VotingChoice> winners;
  @Relationship("votingChoices")
  private List<VotingChoice> votingChoices;

}
