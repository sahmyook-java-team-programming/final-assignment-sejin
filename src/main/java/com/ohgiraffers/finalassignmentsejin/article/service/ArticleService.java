package com.ohgiraffers.finalassignmentsejin.article.service;

import com.ohgiraffers.finalassignmentsejin.article.dto.ArticleDTO;
import com.ohgiraffers.finalassignmentsejin.article.dto.BoardDTO;
import com.ohgiraffers.finalassignmentsejin.article.entity.Article;
import com.ohgiraffers.finalassignmentsejin.article.entity.Board;
import com.ohgiraffers.finalassignmentsejin.article.repository.ArticleRepository;
import com.ohgiraffers.finalassignmentsejin.article.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    // 의존성 주입해야함
    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    public ArticleService(BoardRepository boardRepository, ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.boardRepository = boardRepository;
        this.modelMapper = modelMapper;
        this.articleRepository = articleRepository;
    }

    /* 1. 메뉴 코드로 메뉴 하나 조회 : findById */
    public ArticleDTO findArticleByCode(int articleCode) {

        Article article = articleRepository.findById(articleCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(article, ArticleDTO.class);
    }

    /* 2. 페이징 해서 조회하기 */
    public Page<ArticleDTO> findArticleList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("articleCode").descending());
        Page<Article> articleList = articleRepository.findAll(pageable);

        return articleList.map(article -> modelMapper.map(article, ArticleDTO.class));
    }

    public List<ArticleDTO> findByArticleWriter(String articleWriter) {

        List<Article> articleList = articleRepository.findByArticleWriterContains(articleWriter);

        return articleList.stream().map(article -> modelMapper.map(article, ArticleDTO.class)).collect(Collectors.toList());
    }

    public  List<BoardDTO> findAllBoard() {
        List<Board> boardList = boardRepository.findAllBoard();

        return boardList.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());

    }

    @Transactional
    public void registNewArticle(ArticleDTO newArticle) {

        articleRepository.save(modelMapper.map(newArticle, Article.class));
    }

    @Transactional
    public void modifyArticle(ArticleDTO modifyArticle) {
        Article foundArticle = articleRepository.findById(modifyArticle.getArticleCode())
                .orElseThrow(IllegalArgumentException::new);
        foundArticle.setArticleContext(modifyArticle.getArticleContext());
    }

    @Transactional
    public void deleteArticle(Integer articleCode) {
        articleRepository.deleteById(articleCode);
    }
}