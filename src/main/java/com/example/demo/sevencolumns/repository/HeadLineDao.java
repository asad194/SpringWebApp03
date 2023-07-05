package com.example.demo.sevencolumns.repository;

import java.util.List;

import com.example.demo.sevencolumns.entity.HeadLine;

public interface HeadLineDao {

	List<HeadLine> getHeadLine(int userId);
	
}
