package com.hiberus.monolith.infrastructure.adapter.out.persistence;

import com.hiberus.monolith.domain.model.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clothing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarmentEntity {

    @Id
    private String id;
    private String name;
    private int quantity;
    private Size size;



}
