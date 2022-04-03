package com.agroget.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroget.entity.FeedBackInfoTable;

public interface FeedBackInfoRepo extends JpaRepository<FeedBackInfoTable, Integer> {

}
