package com.example.demo.sevencolumns.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.sevencolumns.entity.HeadLine;

@Repository
public class HeadLineDaoImpl implements HeadLineDao {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public HeadLineDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<HeadLine> getHeadLine(int userId) {
		String sql = "SELECT edit_date, title, emotion FROM seven_columns WHERE user_id = ?";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, userId);
		List<HeadLine> list = new ArrayList<HeadLine>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for(Map<String, Object> result : resultList) {
			HeadLine headLine = new HeadLine();
			
			Date date = (Date)result.get("edit_date");
			LocalDate lDate = date.toLocalDate();
			String edate = lDate.format(formatter);
			
			headLine.setEditDate(edate);
			headLine.setTitle((String)result.get("title"));
			headLine.setEmotion((String)result.get("emotion"));
			list.add(headLine);
		}
		
		return list;

	}
	
	
	
}
