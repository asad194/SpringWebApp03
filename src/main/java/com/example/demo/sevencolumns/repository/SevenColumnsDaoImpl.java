package com.example.demo.sevencolumns.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.sevencolumns.entity.SevenColumns;


@Repository
public class SevenColumnsDaoImpl implements SevenColumnsDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SevenColumnsDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insertSevenColumns(SevenColumns sevenColumns) {
		jdbcTemplate.update("INSERT INTO seven_columns(edit_date, title, event, emotion, negative, distortion, reason, disproof, another, change_emo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", sevenColumns.getEditDate(), sevenColumns.getTitle(), sevenColumns.getEvent(), sevenColumns.getEmotion(), sevenColumns.getNegative(), sevenColumns.getDistortion(), sevenColumns.getReason(), sevenColumns.getDisproof(), sevenColumns.getAnother(), sevenColumns.getChangeEmo());
	}
	
	@Override
	public List<SevenColumns> getAll() {
			String sql = "SELECT * FROM seven_columns";
			// queryForListでレコードをDBから取得
			List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
			List<SevenColumns> list = new ArrayList<SevenColumns>();
			for(Map<String, Object> result : resultList) {
				SevenColumns sevenColumns = new SevenColumns();
				sevenColumns.setColumnId((int)result.get("columnId"));
				sevenColumns.setUserId((int)result.get("userId"));
				// 次ここから
				sevenColumns.setEditDate((LocalDate)result.get("editDate"));
				sevenColumns.setTitle((String)result.get("title"));
				sevenColumns.setEvent((String)result.get("event"));
				sevenColumns.setEmotion((String)result.get("emotion"));
				sevenColumns.setNegative((String)result.get("negative"));
				sevenColumns.setDistortion((String)result.get("distortion"));
				sevenColumns.setReason((String)result.get("reason"));
				sevenColumns.setDisproof((String)result.get("disproof"));
				sevenColumns.setAnother((String)result.get("another"));
				sevenColumns.setChangeEmo((String)result.get("changeEmo"));
				list.add(sevenColumns);
			}
		return list;
	}
	
	@Override
	public SevenColumns getDetail(Integer columnId) {
		String sql = "SELECT * FROM seven_columns WHERE column_id = ?";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, columnId);
		List<SevenColumns> columnList = new ArrayList<SevenColumns>();
		for(Map<String, Object> tmp : result) {
			SevenColumns hitColumns = new SevenColumns();
			hitColumns.setColumnId((Integer)tmp.get("column_id"));
			hitColumns.setUserId((Integer)tmp.get("user_id"));
			/*
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Date date = (Date)tmp.get("edit_date");
			LocalDate lDate = date.toLocalDate();
			String edate = lDate.format(formatter);
			hitColumns.setEditDate(edate);
			*/
			hitColumns.setEditDate((LocalDate)tmp.get("edit_date"));
			hitColumns.setTitle((String)tmp.get("title"));
			hitColumns.setEvent((String)tmp.get("event"));
			hitColumns.setEmotion((String)tmp.get("emotion"));
			hitColumns.setNegative((String)tmp.get("negative"));
			hitColumns.setDistortion((String)tmp.get("distortion"));
			hitColumns.setReason((String)tmp.get("reason"));
			hitColumns.setDisproof((String)tmp.get("disproof"));
			hitColumns.setAnother((String)tmp.get("another"));
			hitColumns.setChangeEmo((String)tmp.get("change_emo"));
			columnList.add(hitColumns);
		}
		SevenColumns sc = columnList.get(0);
		return sc;
	}


}
