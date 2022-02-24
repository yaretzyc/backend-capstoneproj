package com.example.bookclub.model;


import javax.persistence.*;

@Entity
@Table(name = "quotes")
public class quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer page;

    @Column
    private Integer chapter;

    @Column
    private String quote;


    public quote() {
    }

    public quote(Long id, String name, Integer page, Integer chapter, String quote) {
        this.id = id;
        this.name = name;
        this.page = page;
        this.chapter = chapter;
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
