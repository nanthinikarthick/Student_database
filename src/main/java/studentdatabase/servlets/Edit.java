package studentdatabase.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentdatabase.dao.StudentDao;
import studentdatabase.dto.Student;
@WebServlet("/edit")
public class Edit extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		Student stu  = dao.findStudent(id);
		if(stu!=null) {
			req.setAttribute("student",stu);
			RequestDispatcher dispatcher= req.getRequestDispatcher("edit.jsp");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher= req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
}
