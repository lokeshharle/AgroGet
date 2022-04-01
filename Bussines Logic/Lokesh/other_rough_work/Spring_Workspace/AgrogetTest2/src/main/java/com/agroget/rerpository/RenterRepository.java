package com.agroget.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroget.entity.FarmerEntity;
import com.agroget.entity.RenterEntity;

public interface RenterRepository extends JpaRepository<RenterEntity, Integer> {

	@Query(value= "SELECT * FROM RENTER_INFO_TBL U WHERE U.RENTER_USERNAME=:uname AND U.RENTER_PASSWORD=:pass",nativeQuery=true)
	public FarmerEntity loginFarmer(@Param("uname") String username,
			@Param("pass") String password);



}
