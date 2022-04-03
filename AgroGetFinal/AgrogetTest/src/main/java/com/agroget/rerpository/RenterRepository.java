package com.agroget.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.agroget.entity.FarmerEntity;
import com.agroget.entity.RenterEntity;

@Repository
public interface RenterRepository extends JpaRepository<RenterEntity, Integer> {

	@Query(value= "SELECT * FROM RENTER_INFO_TBL U WHERE U.RENTER_USERNAME=:uname AND U.RENTER_PASSWORD=:pass",nativeQuery=true)
	public RenterEntity loginRenter(@Param("uname") String username,
			@Param("pass") String password);



}
