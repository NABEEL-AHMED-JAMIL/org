package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntTransDto;
import com.system.org.dto.search.IntTransSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntTrans;
import com.system.org.repository.IntTransRepository;
import com.system.org.service.IIntTransService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;


@Service
@Scope("singleton")
public class IntTransServiceImpl implements IIntTransService {

    private Logger logger = LoggerFactory.getLogger(IntTransServiceImpl.class);

    @Autowired
    private IntTransRepository intTransRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntTrans(IntTransDto intTransDto) {
        if (intTransDto.getIntTransName() == null) {
            return new Response("Error", "IntTransName not be null");
        } else if (this.intTransRepository.findByIntTransNameAndActiveStatus(
                intTransDto.getIntTransName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "IntTransName already exist with the same name");
        }
        IntTrans intTrans = new IntTrans();
        intTrans.setIntTransUuid(UUID.randomUUID().toString());
        intTrans.setIntTransName(intTransDto.getIntTransName());
        intTrans.setIntDetailLogSysId(intTransDto.getIntDetailLogSysId());
        intTrans.setIntDetailLogSysName(intTransDto.getIntDetailLogSysName());
        intTrans.setIntDetailLogSysUuid(intTransDto.getIntDetailLogSysUuid());
        intTrans.setIntTransAppId(intTransDto.getIntTransAppId());
        intTrans.setIntTransAppName(intTransDto.getIntTransAppName());
        intTrans.setIntTransAppUuid(intTransDto.getIntTransAppUuid());
        intTrans.setIntTransBusName1(intTransDto.getIntTransBusName1());
        intTrans.setIntTransBusName2(intTransDto.getIntTransBusName2());
        intTrans.setIntTransBusName3(intTransDto.getIntTransBusName3());
        intTrans.setIntTransBusName4(intTransDto.getIntTransBusName4());
        intTrans.setIntTransBusName5(intTransDto.getIntTransBusName5());
        intTrans.setIntTransBusVal1(intTransDto.getIntTransBusVal1());
        intTrans.setIntTransBusVal2(intTransDto.getIntTransBusVal2());
        intTrans.setIntTransBusVal3(intTransDto.getIntTransBusVal3());
        intTrans.setIntTransBusVal4(intTransDto.getIntTransBusVal4());
        intTrans.setIntTransBusVal5(intTransDto.getIntTransBusVal5());
        intTrans.setIntTransDesc(intTransDto.getIntTransDesc());
        intTrans.setIntTransEnvId(intTransDto.getIntTransEnvId());
        intTrans.setIntTransEnvName(intTransDto.getIntTransEnvName());
        intTrans.setIntTransEnvUuid(intTransDto.getIntTransEnvUuid());
        intTrans.setIntTransLogLevelId(intTransDto.getIntTransLogLevelId());
        intTrans.setIntTransLogLevelName(intTransDto.getIntTransLogLevelName());
        intTrans.setIntTransLogLevelUuid(intTransDto.getIntTransLogLevelUuid());
        intTrans.setIntTransLogTypeId(intTransDto.getIntTransLogTypeId());
        intTrans.setIntTransLogTypeName(intTransDto.getIntTransLogTypeName());
        intTrans.setIntTransLogTypeUuid(intTransDto.getIntTransLogTypeUuid());
        intTrans.setIntTransOrgDepId(intTransDto.getIntTransOrgDepId());
        intTrans.setIntTransOrgDepName(intTransDto.getIntTransOrgDepName());
        intTrans.setIntTransOrgDepUuid(intTransDto.getIntTransOrgDepUuid());
        intTrans.setIntTransOrgId(intTransDto.getIntTransOrgId());
        intTrans.setIntTransOrgName(intTransDto.getIntTransOrgName());
        intTrans.setIntTransOrgUuid(intTransDto.getIntTransOrgUuid());
        intTrans.setIntTransPayload(intTransDto.getIntTransPayload());
        intTrans.setIntTransPlayloadBlob(intTransDto.getIntTransPlayloadBlob());
        intTrans.setIntTransShortDesc(intTransDto.getIntTransShortDesc());
        intTrans.setIntTransSrcSystemTransId(intTransDto.getIntTransSrcSystemTransId());
        intTrans.setIntTransSrcSystemTransuuid(intTransDto.getIntTransSrcSystemTransuuid());
        intTrans.setIntTransSrcSystemUuid(intTransDto.getIntTransSrcSystemUuid());
        intTrans.setIntTransSrcSystemId(intTransDto.getIntTransSrcSystemId());
        intTrans.setIntTransTechName1(intTransDto.getIntTransTechName1());
        intTrans.setIntTransTechName2(intTransDto.getIntTransTechName2());
        intTrans.setIntTransTechName3(intTransDto.getIntTransTechName3());
        intTrans.setIntTransTechName4(intTransDto.getIntTransTechName4());
        intTrans.setIntTransTechName5(intTransDto.getIntTransTechName5());
        intTrans.setIntTransTechVal1(intTransDto.getIntTransTechVal1());
        intTrans.setIntTransTechVal2(intTransDto.getIntTransTechVal2());
        intTrans.setIntTransTechVal3(intTransDto.getIntTransTechVal3());
        intTrans.setIntTransTechVal4(intTransDto.getIntTransTechVal4());
        intTrans.setIntTransTechVal5(intTransDto.getIntTransTechVal5());
        intTrans.setIntTransTransChildId(intTransDto.getIntTransTransChildId());
        intTrans.setIntTransTransChildUuid(intTransDto.getIntTransTransChildUuid());
        intTrans.setIntTransTransParentId(intTransDto.getIntTransTransParentId());
        intTrans.setIntTransTransParentUuid(intTransDto.getIntTransTransParentUuid());
        intTrans.setIntTransTrgSystemUuid(intTransDto.getIntTransTrgSystemUuid());
        intTrans.setIntTransTrgSystemId(intTransDto.getIntTransTrgSystemId());
        intTrans.setCreatedBy(intTransDto.getCreatedBy());
        intTrans.setActiveStatus(ActiveStatus.Y);
        this.intTransRepository.saveAndFlush(intTrans);
        return new Response("Success", "IntTrans save successfully", intTrans);
    }

    @Override
    public Response updateIntTrans(IntTransDto intTransDto) {
        if (intTransDto.getIntTransUuid() == null) {
            return new Response("Error", "IntTransUuid not be null");
        } else if (this.intTransRepository.findByIntTransNameAndActiveStatus(
                intTransDto.getIntTransName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "IntTransUuid already exist with the same name");
        }
        Optional<IntTrans> intTrans1 = this.intTransRepository.findByIntTransUuid(intTransDto.getIntTransUuid());
        if (!intTrans1.isPresent()) {
            return new Response("Error", "IntTransUuid not found with the with given id " + intTransDto.getIntTransUuid());
        }
        IntTrans intTrans = intTrans1.get();
        intTrans.setIntTransName(intTransDto.getIntTransName());
        intTrans.setIntDetailLogSysId(intTransDto.getIntDetailLogSysId());
        intTrans.setIntDetailLogSysName(intTransDto.getIntDetailLogSysName());
        intTrans.setIntDetailLogSysUuid(intTransDto.getIntDetailLogSysUuid());
        intTrans.setIntTransAppId(intTransDto.getIntTransAppId());
        intTrans.setIntTransAppName(intTransDto.getIntTransAppName());
        intTrans.setIntTransAppUuid(intTransDto.getIntTransAppUuid());
        intTrans.setIntTransBusName1(intTransDto.getIntTransBusName1());
        intTrans.setIntTransBusName2(intTransDto.getIntTransBusName2());
        intTrans.setIntTransBusName3(intTransDto.getIntTransBusName3());
        intTrans.setIntTransBusName4(intTransDto.getIntTransBusName4());
        intTrans.setIntTransBusName5(intTransDto.getIntTransBusName5());
        intTrans.setIntTransBusVal1(intTransDto.getIntTransBusVal1());
        intTrans.setIntTransBusVal2(intTransDto.getIntTransBusVal2());
        intTrans.setIntTransBusVal3(intTransDto.getIntTransBusVal3());
        intTrans.setIntTransBusVal4(intTransDto.getIntTransBusVal4());
        intTrans.setIntTransBusVal5(intTransDto.getIntTransBusVal5());
        intTrans.setIntTransDesc(intTransDto.getIntTransDesc());
        intTrans.setIntTransEnvId(intTransDto.getIntTransEnvId());
        intTrans.setIntTransEnvName(intTransDto.getIntTransEnvName());
        intTrans.setIntTransEnvUuid(intTransDto.getIntTransEnvUuid());
        intTrans.setIntTransLogLevelId(intTransDto.getIntTransLogLevelId());
        intTrans.setIntTransLogLevelName(intTransDto.getIntTransLogLevelName());
        intTrans.setIntTransLogLevelUuid(intTransDto.getIntTransLogLevelUuid());
        intTrans.setIntTransLogTypeId(intTransDto.getIntTransLogTypeId());
        intTrans.setIntTransLogTypeName(intTransDto.getIntTransLogTypeName());
        intTrans.setIntTransLogTypeUuid(intTransDto.getIntTransLogTypeUuid());
        intTrans.setIntTransOrgDepId(intTransDto.getIntTransOrgDepId());
        intTrans.setIntTransOrgDepName(intTransDto.getIntTransOrgDepName());
        intTrans.setIntTransOrgDepUuid(intTransDto.getIntTransOrgDepUuid());
        intTrans.setIntTransOrgId(intTransDto.getIntTransOrgId());
        intTrans.setIntTransOrgName(intTransDto.getIntTransOrgName());
        intTrans.setIntTransOrgUuid(intTransDto.getIntTransOrgUuid());
        intTrans.setIntTransPayload(intTransDto.getIntTransPayload());
        intTrans.setIntTransPlayloadBlob(intTransDto.getIntTransPlayloadBlob());
        intTrans.setIntTransShortDesc(intTransDto.getIntTransShortDesc());
        intTrans.setIntTransSrcSystemTransId(intTransDto.getIntTransSrcSystemTransId());
        intTrans.setIntTransSrcSystemTransuuid(intTransDto.getIntTransSrcSystemTransuuid());
        intTrans.setIntTransSrcSystemUuid(intTransDto.getIntTransSrcSystemUuid());
        intTrans.setIntTransSrcSystemId(intTransDto.getIntTransSrcSystemId());
        intTrans.setIntTransTechName1(intTransDto.getIntTransTechName1());
        intTrans.setIntTransTechName2(intTransDto.getIntTransTechName2());
        intTrans.setIntTransTechName3(intTransDto.getIntTransTechName3());
        intTrans.setIntTransTechName4(intTransDto.getIntTransTechName4());
        intTrans.setIntTransTechName5(intTransDto.getIntTransTechName5());
        intTrans.setIntTransTechVal1(intTransDto.getIntTransTechVal1());
        intTrans.setIntTransTechVal2(intTransDto.getIntTransTechVal2());
        intTrans.setIntTransTechVal3(intTransDto.getIntTransTechVal3());
        intTrans.setIntTransTechVal4(intTransDto.getIntTransTechVal4());
        intTrans.setIntTransTechVal5(intTransDto.getIntTransTechVal5());
        intTrans.setIntTransTransChildId(intTransDto.getIntTransTransChildId());
        intTrans.setIntTransTransChildUuid(intTransDto.getIntTransTransChildUuid());
        intTrans.setIntTransTransParentId(intTransDto.getIntTransTransParentId());
        intTrans.setIntTransTransParentUuid(intTransDto.getIntTransTransParentUuid());
        intTrans.setIntTransTrgSystemUuid(intTransDto.getIntTransTrgSystemUuid());
        intTrans.setIntTransTrgSystemId(intTransDto.getIntTransTrgSystemId());
        intTrans.setCreatedBy(intTransDto.getCreatedBy());
        intTrans.setActiveStatus(ActiveStatus.Y);
        this.intTransRepository.saveAndFlush(intTrans);
        return new Response("Success", "IntTrans save successfully", intTrans);

    }

    @Override
    public Response findAllIntTrans() {
        return new Response("Success", "IntTrans find successfully", this.intTransRepository.findAll());
    }

    @Override
    public Response findAllIntTransSearch(IntTransSearch intTransSearch) {
        return this.utilService.findAllIntTransSearch(intTransSearch);
    }

    @Override
    public Response findIntTransByIntTransUuid(String intTransUuid) {
        Optional<IntTrans> intTrans = this.intTransRepository.findByIntTransUuid(intTransUuid);
        if (intTrans.isPresent()) {
            return new Response("Success", "IntTrans find successfully", intTrans.get());
        } else {
            return new Response("Error", "IntTrans not find");
        }
    }

    @Override
    public Response deleteIntTransByIntTransUuid(String intTransUuid) {
        Optional<IntTrans> intTrans = this.intTransRepository.findByIntTransUuid(intTransUuid);
        intTrans.get().setActiveStatus(ActiveStatus.N);
        this.intTransRepository.saveAndFlush(intTrans.get());
        return new Response("Success", "IntTrans delete successfully");
    }
}
