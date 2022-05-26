package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DizionarioDAO {

	public List<Parola> getParole() 
	{
		final String sql = "SELECT nome FROM parola";
		
		List<Parola> parole = new ArrayList<Parola>();
		
		PreparedStatement st;
		try 
		{
			Connection conn = ConnectDB.getConnection();
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				String nome = rs.getString("nome");
				
				//System.out.println(nome);
				
				parole.add(new Parola(nome));
			}
			
			conn.close();
			
			return parole;	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DizionarioDAO", e);
		}	
	}
}
