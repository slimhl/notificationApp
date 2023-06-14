package com.casavo.notificationApp.service;

import com.casavo.notificationApp.dto.RealEstateDTO;
import com.casavo.notificationApp.entity.RealEstate;
import com.casavo.notificationApp.mapper.RealEstateMapper;
import com.casavo.notificationApp.repository.RealEstateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RealEstateService {
    private RealEstateRepository realEstateRepository;
    private RealEstateMapper realEstateMapper;

    public RealEstateDTO createRealEstate(final RealEstate realEstate){
        return  realEstateMapper.toRealEstateDTO(realEstateRepository.save(realEstate));
    }

}
