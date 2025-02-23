package com.pga;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pga.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * Servlet implementation class SaveStudentRecordServlet
 */
@WebServlet("/saveRecord")
public class SaveStudentRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveStudentRecordServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Transaction tx = null;
			Session session = HibernateUtils.getSessionFactory().openSession();
			
			tx = session.beginTransaction();
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			float marks = Float.parseFloat(request.getParameter("marks"));
			session.persist(new Student(id,name, marks)); // insert into student values(10 ..)
			tx.commit();
	
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}catch (Exception e) {
			e.printStackTrace();
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
