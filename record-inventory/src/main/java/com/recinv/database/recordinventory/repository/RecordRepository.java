package com.recinv.database.recordinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recinv.database.recordinventory.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer>{

}
