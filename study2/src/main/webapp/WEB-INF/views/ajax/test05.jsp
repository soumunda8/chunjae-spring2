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
    <title>Ajax Test05</title>
    <script  src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <nav>
        <h2>05_Get + @ModelAttribute + Object 전송</h2>
        <hr />
        <ul>
            <li><a href="${path }/ajax/">Home</a></li>
        </ul>
        <button id="btn05" type="button" age="20" name="몬스타엑스">Get 전송</button>
        <script>
            $(document).ready(function(){
                $("#btn05").click(function(){
                    var human = {"name" : $(this).attr("name"), "age" : parseInt($(this).attr("age"))};
                    $.ajax({
                        type:"get",
                        url:"${path }/ajax/test05Pro",
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