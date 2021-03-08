package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO {
    // J601用のパス
    private final String JDBC_URL = "jdbc:mysql://172.16.61.111:3306/test";
    private final String DB_USER = "yasui";
    private final String DB_PASS = "yasui";

//    // 自宅用のパス
//    private final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
//    private final String DB_USER = "root";
//    private final String DB_PASS = "root11pass";

    // 最初のドライバ接続処理
    public BookDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM book";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String isbn = rs.getString("isbn");
                int evaluation = rs.getInt("evaluation");

                Book book = new Book(id, title, price, isbn, evaluation);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return bookList;
    }

  //title曖昧検索用メソッド
    public List<Book> searchBook(String key){

        List<Book> bookList = new ArrayList<>();
        //DBにつなぐための処理
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

            String sql = "SELECT * FROM book WHERE title LIKE ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            //曖昧検索するためにプレースフォルダに渡す一文
            pStmt.setString(1, "%" + key + "%");

            ResultSet rs = pStmt.executeQuery();

            //フェッチ処理
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String isbn = rs.getString("isbn");
                int evaluation = rs.getInt("evaluation");
                Book  book = new Book(id, title, price, isbn, evaluation);
                bookList.add(book);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return bookList;
    }


    //ISBN検索用メソッド
    public List<Book> searchISBN(String key){

        List<Book> bookList = new ArrayList<>();
        //DBにつなぐための処理
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

            String sql = "SELECT * FROM book WHERE ISBN=?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            //検索するためにプレースフォルダに渡す一文
            pStmt.setString(1, key);

            ResultSet rs = pStmt.executeQuery();

            //フェッチ処理
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String isbn = rs.getString("isbn");
                int evaluation = rs.getInt("evaluation");
                Book  book = new Book(id, title, price, isbn, evaluation);
                bookList.add(book);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return bookList;
    }

    public void add(Book book) {
        List<Book> bookList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO book (title,price,isbn,evaluation) VALUES(?, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, book.getTitle());
            pStmt.setInt(2, book.getPrice());
            pStmt.setString(3, book.getIsbn());
            pStmt.setInt(4, book.getEvaluation());
            pStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int deleteId) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "DELETE FROM book WHERE id=?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, deleteId);
            pStmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();

        }
    }
}