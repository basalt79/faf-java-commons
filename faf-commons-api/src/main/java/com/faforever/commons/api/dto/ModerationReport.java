package com.faforever.commons.api.dto;

import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Type("moderationReport")
@Getter
@Setter
public class ModerationReport extends AbstractEntity {
  private String reportDescription;
  private ModerationReportStatus reportStatus;
  private String gameIncidentTimecode;
  private String moderatorNotice;
  private String moderatorPrivateNote;
  @JsonBackReference
  @Relationship("bans")
  private Collection<BanInfo> bans;
  @JsonManagedReference
  @Relationship("reporter")
  private Player reporter;
  @Relationship("game")
  private Game game;
  @Relationship("lastModerator")
  private Player lastModerator;
  @JsonManagedReference
  @Relationship("reportedUsers")
  private Set<Player> reportedUsers;
}
