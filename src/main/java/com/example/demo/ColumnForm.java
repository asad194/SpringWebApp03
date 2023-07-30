package com.example.demo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.sevencolumns.entity.SevenColumns;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColumnForm {
	@NotNull
	private Integer userId;
	@NotNull(message = "日付を選んでください")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate editDate;
	@NotNull(message = "題名を入力してください")
	private String title;
	private String event;
	private String emotion;
	private String negative;
	private String distortion;
	private String reason;
	private String disproof;
	private String another;
	private String changeEmo;
	
	public SevenColumns changeToEntity() {
		SevenColumns columns = new SevenColumns();
		
		columns.setUserId(this.userId);
		columns.setEditDate(this.editDate);
		columns.setTitle(this.title);
		if (StringUtils.isNotEmpty(this.event)) {
			columns.setEvent(this.event);
		}
		if (StringUtils.isNotEmpty(this.emotion)) {
			columns.setEmotion(this.emotion);
		}
		if(StringUtils.isNotEmpty(this.negative)) {
			columns.setNegative(this.negative);
		}
		if(StringUtils.isNotEmpty(this.distortion)) {
			columns.setDistortion(this.distortion);
		}
		if(StringUtils.isNotEmpty(this.reason)) {
			columns.setReason(this.reason);
		}
		if(StringUtils.isNotEmpty(this.disproof)) {
			columns.setDisproof(this.disproof);
		}
		if(StringUtils.isNotEmpty(this.another)) {
			columns.setAnother(this.another);
		}
		if(StringUtils.isNotEmpty(this.changeEmo)) {
			columns.setChangeEmo(this.changeEmo);
		}
		
		return columns;
	}
}
