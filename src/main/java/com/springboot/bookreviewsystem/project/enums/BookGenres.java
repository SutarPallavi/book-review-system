package com.springboot.bookreviewsystem.project.enums;

public enum BookGenres {

	FICTION ("fiction"),
	MYSTERY("Mystery"),
	HISTORICALFICTION ("Historical Fiction");

	public final String label;
	
	BookGenres(String string) {
		this.label = string;
	}
}
