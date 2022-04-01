package com.agroget.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroget.entity.OrderInfoTable;

public interface OrderInfoRepository extends JpaRepository<OrderInfoTable, Integer>{

}
