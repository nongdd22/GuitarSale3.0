package Guitar.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Guitar.Dao.DaoFactory;
import Guitar.Dao.IGuitarDaoFactory;

/**
 * Servlet implementation class DelGuitar
 */
@WebServlet("/DelGuitar")
public class DelGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String ID = request.getParameter("ID");
		System.out.println(ID);
		
		IGuitarDaoFactory dao = DaoFactory.createGuitarDao();
		dao.delGuitar(ID);
		request.setAttribute("list", dao.searchallGuitar());
		request.getRequestDispatcher("Delguitar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
