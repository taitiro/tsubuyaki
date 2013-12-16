package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import exception.DatabaseException;

/**
 * Servlet implementation class TubuyakiAddServlet
 */
@WebServlet("/admin/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final UserDAO userDAO = new UserDAO();
	private String deleteUserName;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteUserName = request.getParameter("name");
        int ret = userDAO.deleteUser(deleteUserName);
        if( ret == -1){
            throw new DatabaseException("Something Differnt");
        }else if(ret == 0){
            System.out.println("No change at DATABASE");
        }
		response.sendRedirect("UsersGetServlet");
	}
}