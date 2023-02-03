package com.hiberus.monolith.application.services;


import com.hiberus.monolith.domain.model.Garment;
import com.hiberus.monolith.domain.ports.in.GetGarmentByIDUseCase;
import com.hiberus.monolith.domain.ports.out.GarmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class GetGarmentByID implements GetGarmentByIDUseCase {
    private final GarmentPort garmentPort;

    @Override
    public Garment getGarment(String id) {
        return garmentPort.getGarment(id);
    }
}
