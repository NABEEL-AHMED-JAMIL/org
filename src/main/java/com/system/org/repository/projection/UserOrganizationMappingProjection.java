package com.system.org.repository.projection;

import com.system.org.enums.ActiveStatus;
import java.sql.Timestamp;

public interface UserOrganizationMappingProjection {

    public Long getId();
    public String getOrgId();
    public String getUserId();
    public Timestamp getUpdatedDts();
    public Timestamp getCreatedDts();
    public ActiveStatus getActiveStatus();
}
