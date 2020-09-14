package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FabricaConexao;
import dao.PessoaDAO;
import model.Pessoa;

/**
 * Servlet implementation class ListarPessoaServlet
 */
@WebServlet("/ListarPessoaServlet")
public class ListarPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conn);
			
			List<Pessoa> listaPessoas = dao.GetAll();
			
			request.setAttribute("listaDePessoas", listaPessoas);
			
			RequestDispatcher redirecionador = request.getRequestDispatcher("/listarPessoas.jsp");
			
			redirecionador.forward(request, response);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			String mensagem = "ERRO NA APLICAÇÃO!!!";
			
			request.setAttribute("msg1", mensagem);
			
			RequestDispatcher redirecionador = request.getRequestDispatcher("/listarPessoas.jsp?msg2=ERRO NA APLICAÇÃO!!!");
			redirecionador.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
