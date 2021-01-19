package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ConnectBd;

@WebServlet("/servletController")
public class servletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(!login.isEmpty() && !password.isEmpty())
		{
			ConnectBd connection = new ConnectBd();
			PrintWriter printer = response.getWriter();
			if(connection.getUser(login, password) != null)
			{
				printer.print("Bienvenue dans l'application Web !");
			}
			else
			{
				printer.print("Mauvaise combinaison login/password !");
			}
		}
	}
}