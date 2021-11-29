package com.system.org.repository.projection;

import com.system.org.enums.ActiveStatus;
import java.sql.Timestamp;

public interface UserGroupMappingProjection {

    public Long getId();
    public String getGroupId();
    public String getUserId();
    public Timestamp getCreatedDts();
    public ActiveStatus getActiveStatus();
    public Timestamp getUpdatedDts();
}
