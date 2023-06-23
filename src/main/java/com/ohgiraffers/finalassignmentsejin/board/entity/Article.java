package com.ohgiraffers.finalassignmentsejin.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name="artcicle")
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
    @Column(name = "ref_board_code")
    private int ref_board_code;

    public Article() {}
}
