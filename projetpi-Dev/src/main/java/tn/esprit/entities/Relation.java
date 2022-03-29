package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for Relation
 */

public class Relation implements Serializable{

	private Long id;
	private Word word1;
	private Word word2;
	public Relation(Long id, Word word1, Word word2) {
		super();
		this.id = id;
		this.word1 = word1;
		this.word2 = word2;
	}
	public Relation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Word getWord1() {
		return word1;
	}
	public void setWord1(Word word1) {
		this.word1 = word1;
	}
	public Word getWord2() {
		return word2;
	}
	public void setWord2(Word word2) {
		this.word2 = word2;
	}
	
}