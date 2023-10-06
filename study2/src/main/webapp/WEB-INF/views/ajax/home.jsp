<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajax Home</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <nav>
        <ul>
            <li><a href="${path }/ajax/test01">01. Get 전송</a></li>
            <li><a href="${path }/ajax/test02">02. Post 전송</a></li>
            <li><a href="${path }/ajax/test03">03. Get + Parameter</a></li>
            <li><a href="${path }/ajax/test04">04. Post + Parameter</a></li>
            <li><a href="${path }/ajax/test05">05. Get + @ModelAttribute + Object 전송</a></li>
            <li><a href="${path }/ajax/test06">06. Post + @ModelAttribute + Object 전송</a></li>
            <li><a href="${path }/ajax/test07">07. Post + @RequestBody + Object 전송</a></li>
            <li><a href="${path }/ajax/test08">08. Post + Parameter + List 전송</a></li>
            <li><a href="${path }/ajax/test09">09. Post + Parameter + ResponseEntity + Object 전송</a></li>
            <li><a href="${path }/ajax/test10">10. Post + Parameter + ResponseEntity + List 전송</a></li>
        </ul>
    </nav>
</body>
</html>