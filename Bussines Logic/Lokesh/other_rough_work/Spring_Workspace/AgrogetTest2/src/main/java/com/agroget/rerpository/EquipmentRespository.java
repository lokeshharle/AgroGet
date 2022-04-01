package com.agroget.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroget.entity.EquipmentInfoTable;

public interface EquipmentRespository extends JpaRepository<EquipmentInfoTable, Integer> {

}
