package com.casavo.notificationApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PreferenceDTO {

    private Long id;
    private Long clientId;
    private BigDecimal minimumPrice;
    private BigDecimal maximumPrice;
    private Integer numberOfRooms;
    private String city;
}
