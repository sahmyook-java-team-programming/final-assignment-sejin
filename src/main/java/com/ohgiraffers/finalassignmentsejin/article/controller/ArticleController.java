package com.ohgiraffers.finalassignmentsejin.article.controller;

import com.ohgiraffers.finalassignmentsejin.article.dto.ArticleDTO;
import com.ohgiraffers.finalassignmentsejin.article.dto.BoardDTO;
import com.ohgiraffers.finalassignmentsejin.article.service.ArticleService;
import com.ohgiraffers.finalassignmentsejin.common.Pagenation;
import com.ohgiraffers.finalassignmentsejin.common.PagingButtonInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{articleCode}")
    public String findArticleByCode(@PathVariable int articleCode, Model model) {

        ArticleDTO article = articleService.findArticleByCode(articleCode);
        model.addAttribute("article", article);

        return "article/detail";
    }

    @GetMapping("/list")
    public String findMenuList(@PageableDefault Pageable pageable, Model model) {
        /* page -> number, size, sort 파라미터가 Pageable 객체에 담긴다. */
        // Pageable의 디폴트가 뭔지 로그 찍어보기
        log.info("pageable : {}", pageable);
        Page<ArticleDTO> articleList = articleService.findArticleList(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(articleList);
        model.addAttribute("paging", paging);
        model.addAttribute("articleList", articleList);
        return "article/list";
    }

    @GetMapping("querymethod")
    public void queryMethodPage() {}

    @GetMapping("search")
    public String findByArticleWriter(@RequestParam String articleWriter, Model model) {

        List<ArticleDTO> articleList = articleService.findByArticleWriter(articleWriter);
        model.addAttribute("articleList", articleList);
        model.addAttribute("articleWriter", articleWriter);

        return "article/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping(value = "board", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<BoardDTO> findAllBoard() {

        return articleService.findAllBoard();
    }

    @PostMapping("/regist")
    public String registNewMenu(ArticleDTO newArticle) {

        articleService.registNewArticle(newArticle);

        return "redirect:/article/list";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyArticle(ArticleDTO modifyArticle) {
        articleService.modifyArticle(modifyArticle);
        return "redirect:/article/" + modifyArticle.getArticleCode();
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteMenu(@RequestParam int articleCode) {
        articleService.deleteArticle(articleCode);
        return "redirect:/article/list";
    }
}
