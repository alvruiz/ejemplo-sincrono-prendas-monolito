package com.hiberus.monolith.application.services;


import com.hiberus.monolith.domain.model.Garment;
import com.hiberus.monolith.domain.ports.in.GetClothingUseCase;
import com.hiberus.monolith.domain.ports.out.GarmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class GetClothing implements GetClothingUseCase {
    private final GarmentPort garmentPort;

    @Override
    public List<Garment> getClothing() {
        return garmentPort.getListClothing();
    }
}
