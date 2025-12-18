package com.bst.repository;

import com.bst.entity.TreeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRecordRepository extends JpaRepository<TreeRecord, Long> {
    
}