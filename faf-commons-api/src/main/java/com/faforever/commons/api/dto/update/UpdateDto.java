package com.faforever.commons.api.dto.update;

import com.faforever.commons.api.elide.ElideEntity;

public interface UpdateDto<T extends ElideEntity> {
  String getId();
}
