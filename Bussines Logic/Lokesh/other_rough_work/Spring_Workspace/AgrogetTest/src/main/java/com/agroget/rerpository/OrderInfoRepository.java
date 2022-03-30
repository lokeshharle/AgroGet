package com.agroget.rerpository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.agroget.entity.OrderInfoTable;

public interface OrderInfoRepository extends JpaRepository<OrderInfoTable, Integer>{

	@Query(value= "SELECT * FROM order_info_tbl e WHERE e.farmer_id=:farmerId",nativeQuery=true)
	public List<OrderInfoTable> findByFarmerId(@Param("farmerId") int farmerId);
	
	
	
}
