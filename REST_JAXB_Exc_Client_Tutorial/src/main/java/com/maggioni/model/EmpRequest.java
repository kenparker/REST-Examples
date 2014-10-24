package com.maggioni.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magang
 */
@XmlRootElement(name = "empRequest")
public class EmpRequest {
	private int id;
	private String name;

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
}
