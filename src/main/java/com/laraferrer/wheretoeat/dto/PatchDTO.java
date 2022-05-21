package com.laraferrer.wheretoeat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchDTO {
    private String key;
    private String value;
}
