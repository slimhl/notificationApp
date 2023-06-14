package com.casavo.notificationApp.service;


import com.casavo.notificationApp.dto.ClientDTO;
import com.casavo.notificationApp.entity.Client;
import com.casavo.notificationApp.entity.Preference;
import com.casavo.notificationApp.entity.RealEstate;
import com.casavo.notificationApp.mapper.ClientMapper;
import com.casavo.notificationApp.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
   private ClientRepository clientRepository;
   private ClientMapper clientMapper;
   private PreferenceService preferenceService;
   public ClientDTO createClient(Client client){
     return   clientMapper.toClientDTO(clientRepository.save(client));
   }

    public List<Client> getEligibleClients(RealEstate realEstate) {
       //compare the real estate properties and get all matched client preferences
        List<Preference> preferences=preferenceService.getMatchedPreference(realEstate);
        if(CollectionUtils.isEmpty(preferences)) return Collections.emptyList();
        Set<Long> clientIds=preferences.stream().map(Preference::getClientId).collect(Collectors.toSet());
        return  clientRepository.findAllById(clientIds);
    }
}
