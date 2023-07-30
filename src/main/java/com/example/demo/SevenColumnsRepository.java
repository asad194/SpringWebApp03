package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.sevencolumns.entity.SevenColumns;

@Repository
public interface SevenColumnsRepository extends JpaRepository<SevenColumns, Integer> {

}
