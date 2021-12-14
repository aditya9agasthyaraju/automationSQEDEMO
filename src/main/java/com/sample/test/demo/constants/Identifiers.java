package com.sample.test.demo.constants;

public enum Identifiers {

	ID("ID"), 
	XPATH("xpath"), 
	CSS("css"), 
	CLASSNAME("className"), 
	LINKTEXT("linkText"), 
	PARTIALLINKTEXT("partialLinkText"),
	TAGNAME("tagName");

	private String value;

	Identifiers(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
