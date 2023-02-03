package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.Garment;

import java.util.List;

public interface GetClothingUseCase {
    List<Garment> getClothing();
}
