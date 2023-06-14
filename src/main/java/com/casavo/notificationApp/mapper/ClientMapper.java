package com.casavo.notificationApp.mapper;

import com.casavo.notificationApp.dto.ClientDTO;
import com.casavo.notificationApp.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toClientDTO (final Client client);

    List<ClientDTO> toClientDTOs(List<Client> clients);
}
