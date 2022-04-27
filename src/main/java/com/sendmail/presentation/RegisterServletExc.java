package com.sendmail.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sendmail.dao.IUtilisateurDao;
import com.sendmail.dao.UtilisateurDao;
import com.sendmail.entities.Utilisateur;
import com.sendmail.metier.IUtilisateurMetier;
import com.sendmail.metier.imp.UtilisateurMetierImp;

@WebServlet("/users/save")
public class RegisterServletExc extends HttpServlet {
       
   private final IUtilisateurMetier utilisateurMetier = new UtilisateurMetierImp();
    public RegisterServletExc() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom =  request.getParameter("lastName");
		String prenom =  request.getParameter("firstName");
		String email =  request.getParameter("email");
		String password =  request.getParameter("password");
		Utilisateur user = new Utilisateur(nom,prenom,email,password);
		utilisateurMetier.create(user);
		response.sendRedirect(getServletContext().getContextPath()+"/login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
