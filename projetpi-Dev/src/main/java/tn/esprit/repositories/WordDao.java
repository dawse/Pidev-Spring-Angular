package tn.esprit.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tn.esprit.entities.Relation;
import tn.esprit.entities.Word;



@Repository
public class WordDao {
    /**
     * Words collection
     */
    private static List<Word> words;

    /**
     * Relations between words
     * representing relations between words and synonyms
     */
    private static List<Relation> relations;

    /**
     * Insert some dummy default data...
     *
     * This part of code will generate structure of
     * words and synonyms like this:
     *
     * -----------------------
     * [0] Clean
     *      | [1] Wash
     * [1] Wash
     * [2] Run
     * [3] Build
     * [4] Create
     * [5] Make
     *      | [4] Create
     *      | [3] Build
     * -----------------------
     */
    static {
        words = new LinkedList<>();
        relations = new LinkedList<>();

        // Insert some dummy data
        
        words.add(new Word("Informatique"));
        words.add(new Word("Industrie"));
        words.add(new Word("agroalimentaire"));
        words.add(new Word("Commerce"));
        words.add(new Word("automatique"));
        words.add(new Word("robotique"));
        words.add(new Word("electronique"));
        words.add(new Word("telegestion"));
        words.add(new Word("telematique"));
        words.add(new Word("teleinformatique"));
        words.add(new Word("affaires"));
        words.add(new Word("business"));
        words.add(new Word("marketing"));
        words.add(new Word("marchandise"));
        words.add(new Word("fabrication"));
        words.add(new Word("marchandise"));
        words.add(new Word("nutrition"));
        words.add(new Word("bioalimentaire"));

        // Make Create as synonym of informatique
        addRelation(words.get(0), words.get(4));
        addRelation(words.get(0), words.get(5));
        addRelation(words.get(0), words.get(6));
        addRelation(words.get(0), words.get(7));
        addRelation(words.get(0), words.get(8));
        addRelation(words.get(0), words.get(9));

        // Make Create as synonym of Commerce
        addRelation(words.get(1), words.get(10));
        addRelation(words.get(1), words.get(11));
        addRelation(words.get(1), words.get(12));
        addRelation(words.get(1), words.get(13));
        // Make Create as synonym of ...
        addRelation(words.get(2), words.get(14));
        // Make Create as synonym of ...
        addRelation(words.get(3), words.get(15));
        addRelation(words.get(3), words.get(16));
        addRelation(words.get(3), words.get(17));
    }
    
    private static void addRelation(Word w1, Word w2) {
        // TODO:
        // Before creating relation, first check if relation already exists?

        relations.add(new Relation(null, w1, w2));
    }

    /**
     * Find word in database
     *
     * @param word - word which need to be found
     * @return founded word or null if nothing is found
     */
    public Word findWord(String word) {
    	for(Word w : words) {
    		if(w.equals(word)) {
    			return w;
    		}
    	}

        return null;
    }

    /**
     * Insert word into database
     *
     * @param word value of word
     * @return added word
     */
    public Word addWord(String word) throws Exception {
        if(findWord(word) != null) {
            throw new Exception(String.format("Word <%s> already exist in database", word));
        }
        
        Word _word = new Word(word);
        words.add(_word);

        return _word;
    }

    /**
     * Attach synonym to word
     *
     * @param word value of word
     * @param synonym value of synonym
     * @return Word object of created synonym
     * @throws Exception If word does not exist in database
     */
    public Word addSynonymForWord(String word, String synonym) throws Exception {
        Word dbWord = findWord(word);
        
        if(dbWord == null) {
            throw new Exception(String.format("Word <%s> does not exist in database", word));
        }
        
        return addSynonymForWord(dbWord, synonym);
    }
    
    /**
     * 
     * @param word word
     * @param synonym synonym that needs to be added
     * @return Word object of created synonym
     * @throws Exception If word does not exist in database
     */
    public Word addSynonymForWord(Word word, String synonym) throws Exception {
    	Word dbSynonym = findWord(synonym);
        
        if(dbSynonym == null) {
            addWord(synonym);
            dbSynonym = findWord(synonym);
        }
        
        addRelation(word, dbSynonym);

        return dbSynonym;
    }

    /**
     * Search for words by keyword
     *
     * @param keyword searching pattern
     * @return list of matching words
     */
    public List<Word> search(String keyword) {
        List<Word> results = new LinkedList<>();

        for(Word w : words) {
            if(w.like(keyword)) {
                results.add(w);
            }
        }

        return results;
    }
    
    /**
     * Fetch synonyms for word
     * @param word Word which synonyms needs to be fetched
     * @param results Reference to results list
     */
    private void fetchSynonyms(Word word, List<Word> results) {
    	if(results.contains(word)) {
    		return;
    	}
    	
    	results.add(word);
    	
    	if(word != null) {
    		for(Relation rel : relations) {
                if(rel.getWord1() == word) {
                	fetchSynonyms(rel.getWord2(), results);
                } else if(rel.getWord2() == word) {
                	fetchSynonyms(rel.getWord1(), results);
                }
            }
    	}
    }
    
    /**
     * 
     * @param word - Word of which synonyms will be searched
     * @return List of synonyms of word
     */
    public List<Word> synonyms(Word word) {
    	List<Word> results = new LinkedList<Word>();
    	
        fetchSynonyms(word, results);
        
        results.remove(0);
        
        return results;
    }

    /**
     * Searching for synonyms of a word
     *
     * @param word value of word
     * @return List of synonyms for a word
     */
    public List<Word> synonyms(String word) {
        return synonyms(findWord(word));
    }
}
