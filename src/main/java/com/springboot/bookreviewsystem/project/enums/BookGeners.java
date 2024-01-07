package com.springboot.bookreviewsystem.project.enums;

public enum BookGeners {

	FICTION ("fiction"),
	MYSTERY("Mystery"),
	HISTORICALFICTION ("Historical Fiction");

	public final String label;
	
	BookGeners(String string) {
		this.label = string;
	}
}
