package com.ohgiraffers.finalassignmentsejin.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ArticleDTO implements Serializable {
    private int articleCode;
    private String articleName;
    private String articleWriter;
    private String articleContext;
    private String articleDate;
    private int ref_board_code;
}
