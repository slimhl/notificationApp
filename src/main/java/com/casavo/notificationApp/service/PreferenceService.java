package com.casavo.notificationApp.service;

import com.casavo.notificationApp.dto.PreferenceDTO;
import com.casavo.notificationApp.entity.Preference;
import com.casavo.notificationApp.entity.RealEstate;
import com.casavo.notificationApp.mapper.PreferenceMapper;
import com.casavo.notificationApp.repository.PreferenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PreferenceService {
    private PreferenceRepository preferenceRepository;
    private PreferenceMapper preferenceMapper;

    public PreferenceDTO createPreference(final Preference preference){
        return  preferenceMapper.toPreferenceDTO(preferenceRepository.save(preference));
    }

    public List<Preference> getMatchedPreference(RealEstate realEstate) {
        return preferenceRepository.findByRealEstate(realEstate.getPrice(),realEstate.getNumberOfRooms()
        ,realEstate.getCity(),realEstate.getArea(),realEstate.getBuiltDate());
    }
}
