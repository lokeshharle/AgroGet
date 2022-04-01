package com.agroget.rerpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agroget.entity.ImageInfoTable;

@Repository
public interface ImageInfoRepository extends JpaRepository<ImageInfoTable, Integer>{

}
