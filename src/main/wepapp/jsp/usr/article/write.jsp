<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>게시물 등록</h1>
<script>
    function article__submit(form){
        form.title.value = form.title.value.trim();
        form.body.value = form.body.value.trim();
        if(form.title.value.length == 0){
            alert('제목을 입력해주세요.');
            form.title.focus();
            return;
        }
        if(form.body.value.length == 0){
            alert('내용을 입력해주세요.');
            form.body.focus();
            return;
        }
        form.submit();
    }

</script>
<form method="POST" onsubmit="article__submit(this); return false;">
    <span>제목</span>
    <input type="text" name="title"/>
    <span>내용</span>
    <input type="text" name="body"/>
    <input type="submit" value="작성"/>
</form>