package com.agroget.rerpository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroget.entity.OrderEquipmentTable;
import com.agroget.entity.OrderInfoTable;

public interface OrderEquipmentRepository extends JpaRepository<OrderEquipmentTable, Integer>{

	@Query(value= "SELECT * FROM order_equipment_tbl e WHERE e.order_id=:orderId",nativeQuery=true)
	public List<OrderEquipmentTable> findByOrderId(@Param("orderId") int orderId);
	
	@Query(value= "SELECT * FROM order_equipment_tbl e WHERE e.order_id=:orderId AND e.equipment_id=:equipmentId",nativeQuery=true)
	public OrderEquipmentTable findByOrderIdEqId(@Param("orderId") int orderId,@Param("equipmentId") int eqId);
	
}