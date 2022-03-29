package com.agroget.rerpository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.FarmerEntity;

public interface EquipmentRespository extends JpaRepository<EquipmentInfoTable, Integer> {

	@Query(value= "SELECT * FROM equipment_info_tbl e WHERE e.equipment_type=:type ",nativeQuery=true)
	public List<EquipmentInfoTable> findByEquipmentType(@Param("type") String type);
			
	
	
	
	
}
