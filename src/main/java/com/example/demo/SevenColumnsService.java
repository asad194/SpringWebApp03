package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sevencolumns.entity.SevenColumns;

@Service
public class SevenColumnsService {
	
	private final SevenColumnsRepository repository;
	
	@Autowired
	public SevenColumnsService(SevenColumnsRepository repository) {
		this.repository = repository;
	}
	
	public SevenColumns createColumn(SevenColumns columns) {
		return repository.save(columns);
	}
	

}
