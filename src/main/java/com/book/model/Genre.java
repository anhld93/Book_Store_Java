package com.book.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

//    @OneToMany(mappedBy = "genre")
//    private List<Book> book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Book> getBook() {
//        return book;
//    }
//
//    public void setBook(List<Book> book) {
//        this.book = book;
//    }
}
