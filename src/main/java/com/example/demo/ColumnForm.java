package com.example.demo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.sevencolumns.entity.SevenColumns;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColumnForm {
	@NotNull
	private Integer userId;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate editDate;
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
		
	public SevenColumns changeFormToColumns() {
		SevenColumns column = new SevenColumns();
		
		
		
		return column;
	}
}
