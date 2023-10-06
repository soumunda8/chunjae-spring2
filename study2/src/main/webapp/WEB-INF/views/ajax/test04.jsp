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
    <title>Ajax Test04</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <nav>
        <h2>04_Post + Parameter</h2>
        <hr />
        <ul>
            <li><a href="${path }/ajax/">Home</a></li>
        </ul>
        <input type="text" name="msg" id="msg" placeholder="메시지 입력">
        <button id="btn04" type="button">Post 전송</button>
        <script>
            $(document).ready(function(){
                $("#btn04").click(function() {
                    var msg = $("#msg").val();
                    if(msg==""){
                        msg = "Post Parameter 전송";
                    }
                    var obj = { "msg": msg};
                    $.ajax({
                        type:"post",
                        url:"${path }/ajax/test04pro",
                        data:obj,
                        success:function(res) {
                            console.log("성공", res);
                            },
                        error:function(err) {
                            console.log("실패", err);
                        }
                    });
                });
            });
        </script>
    </nav>
</body>
</body>
</html>