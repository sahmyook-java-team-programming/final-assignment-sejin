package com.ohgiraffers.finalassignmentsejin.article.repository;

import com.ohgiraffers.finalassignmentsejin.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    // 간단한 기능들은 JpaRepository안에 CRUD 레포에 있음
    List<Article> findByArticleWriterContains(String article_writer);
}
