package com.sendmail.dao;
import java.sql.*;

import com.sendmail.entities.Utilisateur;

public class UtilisateurDao implements IUtilisateurDao{
	private Connection connection = Singleton.getInstance().getConnection(); 

    @Override
    public  void add(Utilisateur o) {
        try {
        	
        	PreparedStatement stmt = connection.prepareStatement("INSERT INTO users(nom,prenom,email,password) VALUES (?,?,?,ENCRYPT(?,'dovecot'))");
        	stmt.setString(1,o.getNom());
        	stmt.setString(2,o.getPrenom());
        	stmt.setString(3,o.getEmail());
        	stmt.setString(4,o.getPassword());
        	stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

	@Override
	public Utilisateur find(String email) {
		Utilisateur utilisateur = null;
		 try {	
			 	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE email=?");
			 	stmt.setString(1, email);
	        	ResultSet set = stmt.executeQuery();
	        	if(set.next()) {
	        		utilisateur = new Utilisateur();
	        		utilisateur.setEmail(email);
	        		utilisateur.setNom(set.getString("nom"));
	        		utilisateur.setPrenom(set.getString("prenom"));
	        		
	        	}
	        }catch (Exception e){
	            e.printStackTrace();
	        }
		return utilisateur;
	}

	@Override
	public Utilisateur findByEmailAndPassword(String email, String password) {
		Utilisateur utilisateur = null;
		 try {	
			 	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE email=? AND `password`=ENCRYPT(?,'dovecot') ");
			 	stmt.setString(1, email);
			 	stmt.setString(2, password);
	        	ResultSet set = stmt.executeQuery();
	        	if(set.next()) {
	        		utilisateur = new Utilisateur();
	        		utilisateur.setEmail(email);
	        		utilisateur.setNom(set.getString("nom"));
	        		utilisateur.setPrenom(set.getString("prenom"));
	        		
	        	}
	        }catch (Exception e){
	            e.printStackTrace();
	        }
		return utilisateur;	
}
    


   
}
