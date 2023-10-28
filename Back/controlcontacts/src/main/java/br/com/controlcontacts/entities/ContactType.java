package br.com.controlcontacts.entities;

import java.util.stream.Stream;

public enum ContactType {
	
	PHONE(0), MOBILE(1);
	
	private int value;

	private ContactType(int value) {
		this.value = value;
	}
	
	public int getValue() {
        return value;
    }

    public static ContactType of(int value) {
        return Stream.of(ContactType.values())
          .filter(p -> p.getValue() == value)
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }

}
