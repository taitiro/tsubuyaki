package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TsubuyakiDAO;
import dao.UserDAO;
import beans.TsubuyakiArrayBean;
import beans.UserBean;

/**
 * Servlet implementation class TubuyakiAddServlet
 */
@WebServlet("/TsubuyakiGetServlet")
public class TsubuyakiGetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final TsubuyakiDAO tsubuyakiDAO = new TsubuyakiDAO();
    private static final UserDAO userDAO = new UserDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TsubuyakiGetServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("name") != null) {
            TsubuyakiArrayBean tsubuyakiArrayBean=tsubuyakiDAO.getTsubuyakiByName(request.getParameter("name"));
            UserBean userBean =userDAO.getUser(request.getParameter("name"));
            request.setAttribute("thisTsubuyakiArray", tsubuyakiArrayBean);
            request.setAttribute("thisUser", userBean);
            request.getRequestDispatcher("profilepage.jsp").forward(request, response);
        }
        else {
            TsubuyakiArrayBean tsubuyakiArrayBean=tsubuyakiDAO.getAllTsubuyaki();
            tsubuyakiArrayBean.setName("all");
            getServletContext().setAttribute("allTsubuyaki", tsubuyakiArrayBean);
            response.sendRedirect("index.jsp");
        }
    }
}