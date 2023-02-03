package com.hiberus.monolith.domain.ports.in;


import com.hiberus.monolith.domain.model.Garment;

public interface UpgradeDowngradeQuantityUseCase {

    boolean upgrade(Garment garment);
    boolean downgrade(Garment garment);
}
