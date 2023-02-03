package com.hiberus.monolith.infrastructure.DTO;

import com.hiberus.monolith.domain.model.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GarmentDTO {
    private String name;
    private int quantity;
    private Size size;
}
