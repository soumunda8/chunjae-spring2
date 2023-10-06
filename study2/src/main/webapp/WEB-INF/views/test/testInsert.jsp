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
    <title>RestfulAPI JSON Insert</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <div class="container">
        <h2>폼에서 유효성 검증</h2>
        <hr />
        <div>
            연번 : <input type="text" name="num" id="num" required /><br/><br/>
            제목 : <input type="text" name="title" id="title" required /><br/><br/>
            <input type="submit" id="btn1" value="등록" />
        </div>
        <script>
            $(document).ready(function(){
                $("#btn1").click(function(){
                    var test = {"num":$("#num").val(), "title":$("#title").val()}
                    $.ajax({
                        type:"post",
                        url:"${path }/json/insertForm",
                        data:test,
                        success:function (testVO) {
                            console.log("성공", testVO);
                            //var testVO1 = JSON.parse(testVO);    // parse : 일반 객체로 변경
                        },
                        error:function (err) {
                            console.log("실패", err);
                        },
                    });
                });
            });
        </script>
    </div>
</body>
</html>