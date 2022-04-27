package com.sendmail.metier.imp;

import com.sendmail.dao.IUtilisateurDao;
import com.sendmail.dao.UtilisateurDao;
import com.sendmail.entities.Utilisateur;
import com.sendmail.metier.IUtilisateurMetier;

public class UtilisateurMetierImp implements IUtilisateurMetier {
	private IUtilisateurDao utilisateurDao = new UtilisateurDao();

	@Override
	public void create(Utilisateur utilisateur) {
		utilisateurDao.add(utilisateur);
	}

	@Override
	public Utilisateur login(Utilisateur utilisateur) {
		return utilisateurDao.findByEmailAndPassword(utilisateur.getEmail(),utilisateur.getPassword());
	}

}
