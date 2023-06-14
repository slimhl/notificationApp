package com.casavo.notificationApp.mapper;

import com.casavo.notificationApp.dto.PreferenceDTO;
import com.casavo.notificationApp.dto.RealEstateDTO;
import com.casavo.notificationApp.entity.Preference;
import com.casavo.notificationApp.entity.RealEstate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PreferenceMapper {
    PreferenceDTO toPreferenceDTO (final Preference preference);
}
