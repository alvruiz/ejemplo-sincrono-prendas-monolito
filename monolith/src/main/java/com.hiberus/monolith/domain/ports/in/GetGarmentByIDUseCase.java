package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.Garment;

public interface GetGarmentByIDUseCase {
    Garment getGarment(String id);
}
