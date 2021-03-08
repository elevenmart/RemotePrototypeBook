package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	    
	    request.setCharacterEncoding("UTF-8");
	    
	    //addからパラメーターの取得
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String isbn = request.getParameter("isbn");
        String evaluation = request.getParameter("evaluation");
        
        //Bookのpriceがintのためintに変換
        int intPrice = Integer.parseInt(price);
        int intEvaluation = Integer.parseInt(evaluation);
        
        //Bookインスタンスを作成
        Book book = new Book(title, intPrice, isbn, intEvaluation);
        
        //add()を使うためにbookDAOを作成
        BookDAO bookDAO = new BookDAO();
        bookDAO.add(book);
        
        request.getRequestDispatcher("/WEB-INF/jsp/addResult.jsp").forward(request, response);

	}

}
