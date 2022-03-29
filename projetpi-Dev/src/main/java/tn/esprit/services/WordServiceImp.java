package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Word;

public interface WordServiceImp {
	public Word addWord(String word) throws Exception;
	 public Word addSynonymForWord(Word word, String synonym) throws Exception;
	 public Word addSynonymForWord(String word, String synonym) throws Exception;
	 public Word findWord(String word) ;
	 public List<Word> search(String keyword);
	 public List<Word> synonyms(Word word);
	 public List<Word> synonyms(String word);

}
