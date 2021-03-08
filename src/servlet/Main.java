package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String check = request.getParameter("check");
        String forwardPath = null;

        List<Book> bookList = new ArrayList<>();
        BookDAO bookDAO = new BookDAO();
        bookList = bookDAO.findAll();

        switch (check) {
        //case0メイン画面へ移動するための処理を追加しました
        case "0":
            forwardPath="/WEB-INF/jsp/main.jsp";
            break;

        case "1":
            forwardPath="/WEB-INF/jsp/search.jsp";
            break;

        case "2":

        	request.setAttribute("bookList", bookList);
            forwardPath="/WEB-INF/jsp/delete.jsp";
            break;

        case "3":

            forwardPath="/WEB-INF/jsp/add.jsp";
            break;

        case "4":



            request.setAttribute("bookList", bookList);
            forwardPath="/WEB-INF/jsp/update.jsp";
            break;

        }
        request.getRequestDispatcher(forwardPath).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String key = request.getParameter("key");
        String keyword = request.getParameter("keyword");
        String isbn = request.getParameter("isbn");



        List<Book> bookList= new ArrayList<>();
        BookDAO bookDAO = new BookDAO();

       switch(key) {

       case"1":


           bookList = bookDAO.searchBook(keyword);
           request.setAttribute("bookList", bookList);
           break;

       case"2":


           bookList= bookDAO.searchISBN(isbn);
           request.setAttribute("bookList", bookList);
           break;

       }


        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/jsp/searchResult.jsp").forward(request, response);
    }
}

