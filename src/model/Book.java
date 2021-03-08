package model;

public class Book {
    private int id;
    private String title;
    private int price;
    private String isbn;
    private int evaluation;
    
    //引数なしのコンストラクタ
    public Book() {}
    
    //IDなしのコンストラクタ追加しました
    public Book(String title, int price, String isbn, int evaluation) {
        this.title = title;
        this.price = price;
        this.isbn = isbn;
        this.evaluation = evaluation;
    }


    public Book(int id, String title, int price, String isbn, int evaluation) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
        this.evaluation = evaluation;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getPrice() {
        return price;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getEvaluation() {
        return evaluation;
    }
}
