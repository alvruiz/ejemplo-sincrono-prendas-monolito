package com.hiberus.monolith.domain.ports.out;



import com.hiberus.monolith.domain.model.Garment;
import com.hiberus.monolith.domain.model.Size;

import java.util.List;

public interface GarmentPort {



    boolean createGarment(Garment garment);

    boolean deleteGarment(String name, Size size);

    List<Garment> getListClothing();

    Garment getGarment(String id);
}
