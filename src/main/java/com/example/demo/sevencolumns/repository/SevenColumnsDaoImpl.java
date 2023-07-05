package com.example.demo.sevencolumns.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.sevencolumns.entity.SevenColumns;


@Repository
public class SevenColumnsDaoImpl implements SevenColumnsDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SevenColumnsDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
				sevenColumns.setEditDate((String)result.get("editDate"));
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
	
	


}
