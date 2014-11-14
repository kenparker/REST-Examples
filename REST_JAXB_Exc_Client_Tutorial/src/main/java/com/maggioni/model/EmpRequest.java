package com.maggioni.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * http://www.javacodegeeks.com/2012/10/rest-using-jersey-complete-tutorial-with-jaxb-exception-handling-and-client-program.html
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
