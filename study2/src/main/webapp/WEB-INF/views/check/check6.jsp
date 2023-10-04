<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Springframework Validator 유효성 검사 - check6.jsp</title>
</head>
<body>
    <div class="container">
        <h2>Springframework Validator 유효성 검증</h2>
        <hr />
        <form:form action="./check6" method="post" modelAttribute="chk">
            아이디 : <form:input path="id"/>
            <form:errors path="id" element="div" delimiter=" "/><br><br>

            비밀번호 : <form:password path="pw"/>
            <form:errors path="pw" element="div" delimiter=" "/><br><br>

            <button class="btn" type="submit"> 전송 </button>
        </form:form>
        <hr />
        <h2>check6 결과</h2>
        <p>${chk.id }</p>
        <p>${chk.pw }</p>
    </div>
</body>
</html>