package com.example.demo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ColumnForm {
	private Integer userId;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date editDate;
	
	private String title;
	private String event;
	private String emotion;
	private String negative;
	private String distortion;
	private String reason;
	private String disproof;
	private String another;
	private String changeEmo;
}
