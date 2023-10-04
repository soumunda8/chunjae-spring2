<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Springframework Validator @InitBinder + @Valid 유효성 검사 - check5.jsp</title>
</head>
<body>
    <div class="container">
        <h2>Springframework Validator @InitBinder + @Valid 유효성 검증</h2>
        <hr />
        <form action="./check5" method="post">
            <!-- 영문 소문자와 숫자 조합 && 글자 길이 5~12 글자 사이의 유효성 -->
            id : <input type="text" name="id" id="id" /><br/><br/>
            <!-- 영문 소문자와 영문 대문자, 숫자 조합 && 글자 길이 8~12 글자 사이의 유효성 -->
            pw : <input type="password" name="pw" id="pw" /><br/><br/>
            <button type="submit">확인</button>
        </form>
    </div>
</body>
</html>