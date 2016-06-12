package Guitar.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Guitar.Dao.DaoFactory;
import Guitar.Dao.IGuitarDaoFactory;
import Guitar.Model.Guitar;
import Guitar.Model.GuitarSpec;


/**
 * Servlet implementation class AddGuitar
 */
@WebServlet("/AddGuitar")
public class AddGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGuitar() {
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
		String price = request.getParameter("price");
		String builder = request.getParameter("builder");
		String type = request.getParameter("type");
		String Wood = request.getParameter("Wood");

		System.out.println(builder);
		System.out.println(type);
		System.out.println(price);

		Guitar guitar = new Guitar();
		GuitarSpec guitarspec = new GuitarSpec();
		
		guitar.setID(ID);
		guitar.setPrice(price);
		guitarspec.setBuilder(builder);
		guitarspec.setType(type);
		guitarspec.setWood(Wood);
		guitar.setSpec(guitarspec);
		
		IGuitarDaoFactory dao = DaoFactory.createGuitarDao();
		dao.addGuitar(guitar);
		request.setAttribute("list", dao.searchallGuitar());
		request.getRequestDispatcher("Addguitar.jsp").forward(request, response);

	}		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
