package com.casavo.notificationApp.mapper;

import com.casavo.notificationApp.dto.PreferenceDTO;
import com.casavo.notificationApp.entity.Preference;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-13T11:07:14+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class PreferenceMapperImpl implements PreferenceMapper {

    @Override
    public PreferenceDTO toPreferenceDTO(Preference preference) {
        if ( preference == null ) {
            return null;
        }

        PreferenceDTO preferenceDTO = new PreferenceDTO();

        return preferenceDTO;
    }
}
