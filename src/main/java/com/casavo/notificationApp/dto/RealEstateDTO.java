package com.casavo.notificationApp.dto;

import com.casavo.notificationApp.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RealEstateDTO {

    private Long id;
    private String  name;
    private String description;
    private Type type;
    private BigDecimal price;
    private Integer numberOfRooms;
    private Integer area;
    private LocalDate builtDate;
    private String city;
}
