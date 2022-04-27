package com.sendmail.metier;

import com.sendmail.entities.Utilisateur;

public interface IUtilisateurMetier {
	void create(Utilisateur utilisateur);
	Utilisateur login(Utilisateur utilisateur);
}
