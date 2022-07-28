package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    List<ArticleDto> articleDtos;
    ArticleRepository articleRepository;
    ArticleService(){
        articleRepository = new ArticleRepository();
        articleDtos = new ArrayList<>();
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
    }

    public long Write(String title,String body) {
        return articleRepository.Write(title, body);
    }

    public long delete(long id) {
        return articleRepository.delete(id);
    }

    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }

    public void modify(long id, String title, String body) {
        articleRepository.modify(id, title, body);
    }
}
