package com.hiberus.monolith.application.services;


import com.hiberus.monolith.domain.model.Garment;
import com.hiberus.monolith.domain.ports.in.CreateGarmentUseCase;
import com.hiberus.monolith.domain.ports.out.GarmentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CreateGarment implements CreateGarmentUseCase {
    private final GarmentPort garmentPort;

    @Override
    public boolean createGarment(Garment garment){
        return garmentPort.createGarment(garment);
    }
}
