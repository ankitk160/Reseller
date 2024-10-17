package com.reseller.model;

import java.time.LocalDateTime;

public class Operator {
	private Integer id;
	private String name;
	private Integer status;
	private LocalDateTime addtime;
	private LocalDateTime edittime;
	private Integer territoryid;
	private String initials;
	private String territory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Integer getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(Integer territoryid) {
		this.territoryid = territoryid;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", name=" + name + ", status=" + status + ", addtime=" + addtime + ", edittime="
				+ edittime + ", territoryid=" + territoryid + ", initials=" + initials + ", territory=" + territory
				+ "]";
	}
}
