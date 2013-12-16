package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import exception.DatabaseException;
import beans.UserBean;

/**
 * Servlet implementation class TubuyakiAddServlet
 */
@WebServlet("/admin/UserEditServlet")
public class UserEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final UserDAO userDAO = new UserDAO();
    private UserBean userBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        userBean = new UserBean(request.getParameter("name"), request.getParameter("password"),
                request.getParameter("role"),request.getParameter("userdesc"),request.getParameter("icon"),
                request.getParameter("address"),request.getParameter("homepage"),request.getParameter("realname"));
        int ret = userDAO.editUser(userBean);
        if (ret == -1) {
            throw new DatabaseException("Something Differnt");
        } else if (ret == 0) {
            System.out.println("No change at DATABASE");
        }
        response.sendRedirect("UsersGetServlet");
    }
}