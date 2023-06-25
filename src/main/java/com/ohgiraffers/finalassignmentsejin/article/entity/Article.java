package com.ohgiraffers.finalassignmentsejin.article.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name="article")
public class Article {
    @Id
    @Column(name = "article_code")
    private int articleCode;
    @Column(name = "article_name")
    private String articleName;
    @Column(name = "article_writer")
    private String articleWriter;
    @Column(name = "article_context")
    private String articleContext;
    @Column(name = "article_date")
    private String articleDate;
    @Column(name = "board_code")
    private int boardCode;

    public Article() {}

    public Article(int articleCode, String articleName, String articleWriter, String articleContext, String articleDate, int boardCode) {
        super();
        this.articleCode = articleCode;
        this.articleName = articleName;
        this.articleWriter = articleWriter;
        this.articleContext = articleContext;
        this.articleDate = articleDate;
        this.boardCode = boardCode;
    }
}
