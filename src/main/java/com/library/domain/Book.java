package com.library.domain;




import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "BOOKS")
public class Book {
    private Long id;
    private String title;
    private String author;
    private String kind;
    private Loan loan;
public Book(){

}
    public Book(Long id, String title, String author, String kind) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.kind = kind;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_BOOK")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "Author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Column(name = "kinds")
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    @OneToOne(mappedBy = "book",
            fetch = FetchType.LAZY
    )

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
