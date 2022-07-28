package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    public static long lastId;
    public static List<ArticleDto> articleDtos;
    static {
        lastId = 0;
        articleDtos = new ArrayList<>();
        listbox();
    }

    public List<ArticleDto> findAll() {
        return articleDtos;
    }

    public long Write(String title, String body) {
        long id = ++lastId;
        articleDtos.add(new ArticleDto(id, title,body));
        return id;
    }

    public ArticleDto findById(long id) {
        for (ArticleDto articleDto : articleDtos){
            if(articleDto.getId() == id){
                return articleDto;
            }
        }
        return null;
    }

    public long delete(long id) {
        for (ArticleDto articleDto : articleDtos){
            if(articleDto.getId() == id){
                articleDtos.remove(articleDto);
                return articleDto.getId();
            }
        }
        return 0;
    }
    private static void listbox() {
        for (int i = 1; i<=10; i++){
            lastId++;
            articleDtos.add(new ArticleDto(i,"제목"+i,"내용"+i));
        }
    }

    public void modify(long id, String title, String body) {
        for (ArticleDto articleDto : articleDtos){
            if(articleDto.getId() == id){
                articleDto.setTitle(title);
                articleDto.setBody(body);
            }
        }
    }
}
