package com.ohgiraffers.finalassignmentsejin.article.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO implements Serializable {
    private int articleCode;
    private String articleName;
    private String articleWriter;
    private String articleContext;
    private String articleDate;
    private int boardCode;
}
