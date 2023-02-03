package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.Size;

public interface DeleteGarmentUseCase {

    boolean deleteGarment(String name, Size size);
}
