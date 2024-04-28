package studentdatabase.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentdatabase.dao.StudentDao;
import studentdatabase.dto.Student;

@WebServlet("/signin")
public class SignIn extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao dao = new StudentDao();
		Student stu = dao.loginStudent(email, password);
		
		if(stu!=null) {
			req.setAttribute("name",stu.getName());
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("signin.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
}
