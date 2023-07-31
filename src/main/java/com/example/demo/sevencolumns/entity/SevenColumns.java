package com.example.demo.sevencolumns.entity;

import java.time.LocalDate;

public class SevenColumns {
	
	private Integer columnId;
	private Integer userId;
	private LocalDate editDate;
	private String title;
	private String event;
	private String emotion;
	private String negative;
	private String distortion;
	private String reason;
	private String disproof;
	private String another;
	private String changeEmo;
	
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDate getEditDate() {
		return editDate;
	}
	public void setEditDate(LocalDate editDate) {
		this.editDate = editDate;
	}
	public LocalDate changeDateToLocalDate(String htmlDate) {
		LocalDate date = LocalDate.parse(htmlDate);
		return date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public String getNegative() {
		return negative;
	}
	public void setNegative(String negative) {
		this.negative = negative;
	}
	public String getDistortion() {
		return distortion;
	}
	public void setDistortion(String distortion) {
		this.distortion = distortion;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDisproof() {
		return disproof;
	}
	public void setDisproof(String disproof) {
		this.disproof = disproof;
	}
	public String getAnother() {
		return another;
	}
	public void setAnother(String another) {
		this.another = another;
	}
	public String getChangeEmo() {
		return changeEmo;
	}
	public void setChangeEmo(String changeEmo) {
		this.changeEmo = changeEmo;
	}

	
}
