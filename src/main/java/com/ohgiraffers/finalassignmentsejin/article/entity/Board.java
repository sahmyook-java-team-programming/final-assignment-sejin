package com.ohgiraffers.finalassignmentsejin.article.entity;

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
@ToString
@Entity
@Table(name="board")
public class Board {
    @Id
    @Column(name = "board_code")
    private String boardCode;
    @Column(name = "board_name")
    private String boardName;
    public Board() {}
    public Board(String boardCode, String boardName) {
        super();
        this.boardCode = boardCode;
        this.boardName = boardName;
    }
}
