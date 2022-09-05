package com.laraferrer.wheretoeat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    private String address;
    private int age;
    private LocalDate creationDate;
    private long cityId;
}
