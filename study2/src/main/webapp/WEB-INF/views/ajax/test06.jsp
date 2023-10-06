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
    <title>Ajax Test06</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <nav>
        <h2>06_Post + @ModelAttribute + Object 전송</h2>
        <hr />
        <ul>
            <li><a href="${path }/ajax/">Home</a></li>
        </ul>
        <input type="text" name="age" id="age" placeholder="나이 입력" required /><br />
        <input type="text" name="name" id="name" placeholder="이름 입력" required /><br />
        <button id="btn06" type="button">Post 전송</button>
        <script>
            $(document).ready(function(){
                $("#btn06").click(function(){
                    var human = {"name" : $("#name").val(), "age" : parseInt($("#age").val())};
                    $.ajax({
                        type:"post",
                        url:"${path }/ajax/test06Pro",
                        data:human,
                        success:function(res) {
                            console.log("성공", res);
                        },
                        error:function(err) {
                            console.log("실패", err);
                        },
                    });
                });
            });
        </script>
    </nav>
</body>
</body>
</html>