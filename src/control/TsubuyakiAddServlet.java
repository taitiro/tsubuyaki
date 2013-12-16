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
@WebServlet("/TsubuyakiAddServlet")
public class TsubuyakiAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final TsubuyakiDAO tsubuyakiDAO = new TsubuyakiDAO();
    TsubuyakiBean tsubuyakiBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TsubuyakiAddServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String name = request.getParameter("name");
        String value = request.getParameter("value");
        String date = request.getParameter("date");
        if ((request.getParameter("date") == null) || (request.getParameter("date").equals(""))) {
            tsubuyakiBean = new TsubuyakiBean(name, value);
        } else {
            tsubuyakiBean = new TsubuyakiBean(name, value, date);
        }
        int ret;
        ret = tsubuyakiDAO.addTsubuyaki(tsubuyakiBean);
        if (ret != 1) {
            throw new DatabaseException();
        }
        response.sendRedirect("TsubuyakiGetServlet");
    }
}