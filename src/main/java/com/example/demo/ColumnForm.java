package com.example.demo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColumnForm {
	@NotNull
	private Integer userId;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date editDate;
	@NotNull
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
