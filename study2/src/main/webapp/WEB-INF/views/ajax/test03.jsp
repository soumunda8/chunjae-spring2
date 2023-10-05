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
    <title>Ajax Test03</title>
    <script  src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <nav>
        <h2>03_Get + Parameter</h2>
        <hr />
        <ul>
            <li><a href="${path }/ajax/">Home</a></li>
        </ul>
        <button id="btn03" type="button">Get 전송</button>
        <script>
            $(document).ready(function(){
                let fn3 = () => $.ajax({
                    type:"get",
                    url:"${path }/ajax/test03pro?msg=Parameter Get 전송",
                    success:function(res) {
                        console.log("성공", res);
                        },
                    error:function(err) {
                        console.log("실패", err);
                    }
                });
                $("#btn03").on("click", function(){fn3()});
            });
        </script>
    </nav>
</body>
</body>
</html>