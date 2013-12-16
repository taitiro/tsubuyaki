package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TsubuyakiDAO;
import exception.DatabaseException;
import beans.TsubuyakiBean;

/**
 * Servlet implementation class TubuyakiAddServlet
 */
@WebServlet("/TsubuyakiDeleteServlet")
public class TsubuyakiDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final TsubuyakiDAO tsubuyakiDAO = new TsubuyakiDAO();
    TsubuyakiBean tsubuyakiBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TsubuyakiDeleteServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String name = request.getParameter("name");
        int ret;
        ret = tsubuyakiDAO.deleteTsubuyakiByName(name);
        if (ret != 1) {
            throw new DatabaseException("something different");
        }
        response.sendRedirect("TsubuyakiGetServlet");
    }
}