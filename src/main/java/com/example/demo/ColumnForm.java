package com.example.demo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.sevencolumns.entity.SevenColumns;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColumnForm {
	private Integer userId;
	@NotNull(message = "日付は必須です")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate editDate;
	@NotNull(message = "題名は必須です")
	private String title;
	private String event;
	@NotNull(message = "気分は必須です")
	private String emotion;
	private String negative;
	private String distortion;
	private String reason;
	private String disproof;
	private String another;
	private String changeEmo;
		
	public SevenColumns changeFormToColumns() {
		SevenColumns column = new SevenColumns();
		column.setUserId(this.userId);
		column.setEditDate(this.editDate);
		column.setTitle(this.title);
		if( StringUtils.isNotEmpty(this.event) ) {
			column.setEvent(this.event);
		}
		column.setEmotion(this.emotion);
		if( StringUtils.isNotEmpty(this.negative) ) {
			column.setNegative(this.negative);
		}
		if( StringUtils.isNotEmpty(this.distortion) ) {
			column.setDistortion(this.distortion);
		}
		if( StringUtils.isNotEmpty(this.reason) ) {
			column.setReason(this.reason);
		}
		if( StringUtils.isNotEmpty(this.disproof) ) {
			column.setDisproof(this.disproof);
		}
		if( StringUtils.isNotEmpty(this.another) ) {
			column.setAnother(this.another);
		}
		if( StringUtils.isNotEmpty(this.changeEmo) ) {
			column.setChangeEmo(this.changeEmo);
		}
		return column;
	}
}
