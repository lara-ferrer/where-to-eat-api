package com.laraferrer.wheretoeat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private String name;
    private String address;
    private String phone;
    private String email;
    private boolean isOpen;
    private LocalDate creationDate;
    long cityId;
    long categoryId;
}
