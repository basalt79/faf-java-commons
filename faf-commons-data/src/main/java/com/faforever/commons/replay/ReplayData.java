package com.faforever.commons.replay;

import lombok.Data;

import java.util.List;

@Data
public class ReplayData {

  private final List<ChatMessage> chatMessages;
  private final List<GameOption> gameOptions;
}
