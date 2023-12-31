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
    <title>Ajax Test07</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <nav>
        <h2>07_Post + @RequestBody + Object 전송</h2>
        <hr />
        <ul>
            <li><a href="${path }/ajax/">Home</a></li>
        </ul>
        <input type="text" name="age" id="age" placeholder="나이 입력" required /><br />
        <input type="text" name="name" id="name" placeholder="이름 입력" required /><br />
        <button id="btn07" type="button">Post 전송</button>
        <button id="remove" type="button">결과 비우기</button>
        <hr />
        <h3>입력된 데이터</h3>
        <div id="res"></div>
        <script>
            $(document).ready(function(){
                $("#btn07").click(function(){
                    var test = {"name" : $("#name").val(), "age" : parseInt($("#age").val())};
                    $.ajax({
                        type:"post",
                        url:"${path }/ajax/test07Pro",
                        data:JSON.stringify(test),
                        dataType:"json",
                        contentType:"application/json",
                        success:function(res) {
                            console.log("이름", res.name);
                            console.log("나이", res.age);
                            var txt = "<span>이름 : " + res.name +"</span><br><span>나이 : " + res.age + "</span><hr />";
                            $("#res").append(txt);
                        },
                        error:function(err) {
                            console.log("실패", err);
                        },
                    });
                });
                $("#remove").click(function(){
                    $("#res").empty();
                });
            });
        </script>
    </nav>
</body>
</body>
</html>