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

@WebServlet("/update")
public class update extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String school = req.getParameter("school");
		String mail = req.getParameter("mail");
		String address = req.getParameter("address");
		String password = req.getParameter("password");

		Student stu = new Student();
		StudentDao dao = new StudentDao();
		stu.setAddress(address);
		stu.setEmail(mail);

		stu.setName(name);
		stu.setPassword(password);
		stu.setPhone(phone);
		stu.setSchool(school);

		if (dao.editStudent(id, stu) != null) {

			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
