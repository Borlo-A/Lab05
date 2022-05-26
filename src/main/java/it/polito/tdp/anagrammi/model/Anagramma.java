package it.polito.tdp.anagrammi.model;

public class Anagramma {
	
	String word;
	boolean correct;
	
	public Anagramma(String word, boolean correct) {
		this.word = word;
		this.correct = correct;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
}
