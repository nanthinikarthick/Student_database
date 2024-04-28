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


@WebServlet("/signup")
public class SignUp extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String school =req.getParameter("school");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		
		Student student = new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setName(name);
		student.setPassword(password);
		student.setPhone(phone);
		student.setSchool(school);
		
		StudentDao dao = new StudentDao();
		dao.saveStudent(student);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("signin.jsp");
		dispatcher.forward(req, resp);
		
		
		
		
	}
	
}
