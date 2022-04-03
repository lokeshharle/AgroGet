package com.agroget.rerpository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.agroget.entity.OrderInfoTable;


public interface OrderInfoRepository extends JpaRepository<OrderInfoTable, Integer>{

	@Query(value= "SELECT * FROM order_info_tbl e WHERE e.farmer_id=:farmerId",nativeQuery=true)
	public List<OrderInfoTable> findByFarmerId(@Param("farmerId") int farmerId);
	
	//---------------------
	// search by farmer id and where status AND cost is zero 0 
	
	@Query(value= "SELECT * FROM order_info_tbl e WHERE e.farmer_id=:farmerId AND e.order_total_cost=:tc AND e.order_status=:st",nativeQuery=true)
	public List<OrderInfoTable> findByFarmerIdCostStatus(@Param("farmerId") int farmerId,int tc, int st);
	// handle exception if no value is present
	
	
	@Transactional
	@Modifying
	@Query(value="Update order_info_tbl e set e.order_total_cost=:ordercost, e.order_status=:orderstatus where e.order_id=:orderId AND e.farmer_id=:farmerId",nativeQuery=true)
	public int updateOI(@Param("orderId") int orderId,@Param("farmerId") int farmerId, @Param("ordercost") double d, @Param("orderstatus") int orderstatus);
	
}
