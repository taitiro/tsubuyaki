package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import beans.UserArrayBean;

/**
 * Servlet implementation class TubuyakiAddServlet
 */
@WebServlet("/admin/UsersGetServlet")
public class UsersGetServlet extends HttpServlet {
    private static final UserDAO userDAO = new UserDAO();
    private UserArrayBean userArrayBean = new UserArrayBean();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersGetServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userArrayBean.setUsersArray(userDAO.getAllUsers());
        getServletContext().setAttribute("allUsers", userArrayBean);
        response.sendRedirect("userlist.jsp");
    }
}