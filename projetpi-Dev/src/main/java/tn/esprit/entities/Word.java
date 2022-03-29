package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for Word
 */

public class Word implements Serializable {
	
	private Long id;
	private String value;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Word(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(String wordVal) {
        return value.equalsIgnoreCase(wordVal);
    }

    /**
     * Method for comparing word with other word value.
     * Method will ignore upper/lower case.
     *
     * @param wordVal value of word
     * @return true - if value of this word contains provided value
     */
    public boolean like(String wordVal) {
        return value.toLowerCase().contains(wordVal.toLowerCase());
    }

	public Word(Long id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
