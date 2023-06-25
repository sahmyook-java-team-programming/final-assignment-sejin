package com.ohgiraffers.finalassignmentsejin.article.repository;

import com.ohgiraffers.finalassignmentsejin.article.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    // 간단한 기능들은 JpaRepository안에 CRUD 레포에 있음

    @Query(value = "SELECT board_code, board_name FROM board ORDER BY board_code ASC ",
            nativeQuery = true)
    public List<Board> findAllBoard();
}
