package com.hiberus.monolith.infrastructure.adapter.out.persistence;

import com.hiberus.monolith.domain.model.Garment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GarmentMapper {

    static Garment mapToDomainEntity(GarmentEntity entity) {
        return new Garment(entity.getId(),entity.getName(),entity.getQuantity(),entity.getSize());
    }

    static GarmentEntity mapToEntityDomain(Garment garment) {
        return new GarmentEntity(garment.getId(),garment.getName(),garment.getQuantity(),garment.getSize());
    }
    static List<Garment> mapToDomainList(List<GarmentEntity> entities){
        List<Garment> list = new ArrayList<>();

        for(GarmentEntity entity: entities){
            list.add(mapToDomainEntity(entity));
        }
        return list;
    }
}
