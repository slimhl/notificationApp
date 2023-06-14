package com.casavo.notificationApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
