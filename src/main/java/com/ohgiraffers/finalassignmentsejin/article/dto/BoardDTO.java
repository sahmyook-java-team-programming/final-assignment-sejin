package com.ohgiraffers.finalassignmentsejin.article.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO implements Serializable {
    private String boardCode;
    private String boardName;
}
