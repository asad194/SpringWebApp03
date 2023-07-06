package com.example.demo.sevencolumns.repository;

import java.util.List;

import com.example.demo.sevencolumns.entity.SevenColumns;

public interface SevenColumnsDao {
	void insertSevenColumns(SevenColumns sevenColumns);
	List<SevenColumns> getAll();
	SevenColumns getDetail(Integer columnId);
}
