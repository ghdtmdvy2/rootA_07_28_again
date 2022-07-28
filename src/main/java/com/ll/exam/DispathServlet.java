package com.ll.exam;

import com.ll.exam.article.ArticleController;
import com.ll.exam.article.dto.ArticleDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleController articleController = new ArticleController();
        Rq rq = new Rq(req,resp);
        switch (rq.getRouteMethod()){

            case "GET":
                switch (rq.getActionPath()){
                    case "/usr/article/list":
                        articleController.showList(rq);
                        break;
                    case "/usr/article/write":
                        articleController.showWrite(rq);
                        break;
                    case "/usr/article/delete":
                        articleController.showDelete(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.showModify(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getActionPath()){
                    case "/usr/article/write":
                        articleController.doWrite(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.doModify(rq);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
