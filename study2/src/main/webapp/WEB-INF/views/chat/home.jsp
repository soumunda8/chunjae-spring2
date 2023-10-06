<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DATEPICKER 라이브러리</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <nav>
        <a href="${path }/char/home">HOME</a>
    </nav>
    <h2>HOME</h2>
    <hr />

    <div id="chat">
        <ul class="list-group" id="chatRoomList" style="margin: 10px 0;">
            <c:forEach var="chatRoom" items="${lists }">
                <li class="list-group-item list-group-item-success">${chatRoom.name }</li>
            </c:forEach>
        </ul>
        <div>
            <input type="text" id="nickNm" placeholder="이름을 입력해주세요."/>
            <button id="connect" onclick="connect();">연결</button>
        </div>
    </div>

    <script>
        function connect() {
            var data = {name: $("#nickNm").val()};
            $.ajax({
                type:"post",
                url:"${path }/chat/createRoom",
                data: data,
                success: function(res){
                    $("#chatRoomList").append("<li>" + res.data + "</li>");
                },
                error:function(err) {
                    console.log("실패", err);
                },
            });
        }
    </script>
</body>
</html>