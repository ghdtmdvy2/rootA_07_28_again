package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    ArticleService articleService;
    public ArticleController(){
        articleService = new ArticleService();
    }
    public void showList(Rq rq) {
        List<ArticleDto> articleDtos = articleService.findAll();
//        List<ArticleDto> articleDtos = listbox();
        rq.setAttr("articles",articleDtos);
        rq.view("/usr/article/list");
    }



    public void showWrite(Rq rq) {
        rq.view("/usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title","");
        String body = rq.getParam("body","");
        long id = articleService.Write(title,body);
        rq.replace("/usr/article/list","%d번 게시물이 작성 되었습니다.".formatted(id));
    }

    public void showDelete(Rq rq) {
        long id = rq.getLongPathValueByIndex(1,-1);
        articleService.delete(id);
        rq.replace("/usr/article/list","%d번 게시물이 삭제 되었습니다.".formatted(id));
    }

    public void showModify(Rq rq) {
        rq.view("/usr/article/modify");
    }

    public void doModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1,-1);
        String title = rq.getParam("title","");
        String body = rq.getParam("body","");
        articleService.modify(id,title,body);
        rq.replace("/usr/article/list","%d번 게시물이 수정 되었습니다.".formatted(id));
    }
}
