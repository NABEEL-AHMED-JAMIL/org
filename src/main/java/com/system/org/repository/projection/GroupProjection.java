package com.system.org.repository.projection;

import com.system.org.enums.ActiveStatus;

import java.sql.Timestamp;

public interface GroupProjection {

    public Long getGroupId();
    public String getGroupUuid();
    public String getGroupName();
    public String getGroupShortName();
    public String getGroupDesc();
    public Timestamp getCreatedDts();
    public String getCreatedBy();
    public ActiveStatus getActiveStatus();
    public String getUpdatedBy();
    public Timestamp getUpdatedDts();

}
