package com.casavo.notificationApp.mapper;

import com.casavo.notificationApp.dto.ClientDTO;
import com.casavo.notificationApp.dto.RealEstateDTO;
import com.casavo.notificationApp.entity.Client;
import com.casavo.notificationApp.entity.RealEstate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RealEstateMapper {
    RealEstateDTO toRealEstateDTO (final RealEstate realEstate);
}
