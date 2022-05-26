package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;
import it.polito.tdp.anagrammi.DAO.Parola;

public class Model {
	
	private DizionarioDAO dizionarioDAO;
	List<Anagramma> anagrammi;

	public Model() {
		this.dizionarioDAO = new DizionarioDAO();
	}
	
	public List<Parola> getParole() 
	{
		return this.dizionarioDAO.getParole();
	}
	
	public List<Anagramma> anagramma(String s) 
	{
		anagrammi = new LinkedList<Anagramma>();
		anagramma_ricorsiva("", 0, s);
		check();
		return anagrammi;
	}
	
	public void anagramma_ricorsiva(String parziale, int l, String rimanenti) 
	{
		//casi terminali
		if(rimanenti.compareTo("")==0)
		{
			anagrammi.add(new Anagramma(parziale, false));
		}
		
		//casi intermedi
		else 
		{
			for(int pos=0; pos<rimanenti.length(); pos++)
			{
				anagramma_ricorsiva(parziale+rimanenti.charAt(pos), l+1, rimanenti.substring(0, pos)+ rimanenti.substring(pos+1));
			}
		}
	}
	
	public void check() 
	{
		List<Parola> dizionario = getParole();
		
		for(int i=0; i<dizionario.size(); i++)
		{
			for(int j=0; j<anagrammi.size(); j++)
			{
				if(anagrammi.get(j).getWord().compareTo(dizionario.get(i).getParola())==0)
				{
					anagrammi.get(j).setCorrect(true);
				}		
			}
		}
	}
}
