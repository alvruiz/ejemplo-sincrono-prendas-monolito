package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.Garment;

public interface CreateGarmentUseCase {

    boolean createGarment(Garment garment);

}
