package com.reseller.model;

import java.time.LocalDateTime;

public class Promoter {
	private Integer id;
	private String name;
	private Integer status;
	private LocalDateTime addtime;
	private LocalDateTime edittime;
	private String initials;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getAddtime() {
		return addtime;
	}

	public void setAddtime(LocalDateTime addtime) {
		this.addtime = addtime;
	}

	public LocalDateTime getEdittime() {
		return edittime;
	}

	public void setEdittime(LocalDateTime edittime) {
		this.edittime = edittime;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	@Override
	public String toString() {
		return "Promoter [id=" + id + ", name=" + name + ", status=" + status + ", addtime=" + addtime + ", edittime="
				+ edittime + ", initials=" + initials + "]";
	}
}
