package com.sendmail.presentation;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sendmail.entities.Email;
import com.sendmail.entities.Utilisateur;
import com.sendmail.util.SendMail;

/**
 * Servlet implementation class SendMailServletExc
 */
@WebServlet("/SendMailServletExc")
public class SendMailServletExc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final SendMail mail = new SendMail();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailServletExc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
	            Email email = new Email();
	            HttpSession httpSession = request.getSession();
	            Utilisateur user = (Utilisateur) httpSession.getAttribute("user");
	            email.setFrom(user.getEmail());
	            email.setMessage(request.getParameter("message"));
	            email.setTo(request.getParameter("to"));
	            email.setSubject(request.getParameter("subject"));
	            email.setCreatedAt(new Date());
	            mail.send(email, user);
	            response.sendRedirect(getServletContext().getContextPath());
	        }catch (Exception e){
	            response.sendRedirect(getServletContext().getContextPath()+"/mail?message="+e.getMessage());
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
