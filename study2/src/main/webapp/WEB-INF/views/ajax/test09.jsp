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
    <title>Ajax Test09</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <nav>
        <h2>09_Post + Parameter + ResponseEntity Object 전송</h2>
        <hr />
        <ul>
            <li><a href="${path }/ajax/">Home</a></li>
        </ul>
        <input type="text" name="num" id="num" placeholder="연번 입력" value="12" readonly required /><br />
        <input type="text" name="title" id="title" placeholder="제목 입력" required /><br />
        <button id="btn09" type="button">Post 전송</button>
        <button id="empty" type="button">결과 비우기</button>
        <hr />
        <h3>결과 목록</h3>
        <ul id="res"></ul>
        <script>
            $(document).ready(function(){
                $("#btn09").click(function(){
                    var test = {"num" : parseInt($("#num").val()), "title" : $("#title").val()};
                    var txt = "";
                    $.ajax({
                        type:"post",
                        url:"${path }/ajax/test09Pro",
                        data:JSON.stringify(test),
                        dataType:"json",
                        contentType:"application/json",
                        success:function(res) {
                            console.log("성공", res);
                            console.log("번호 : "+res.num);
                            console.log("제목 : "+res.title);
                            $("#res").append("<li>"+res.num+", "+res.title+"</li>");
                        },
                        error:function(err) {
                            console.log("실패", err);
                        },
                    });
                });
                $("#empty").click(function(){
                    $("#res").empty();
                });
            });
        </script>
    </nav>
</body>
</body>
</html>