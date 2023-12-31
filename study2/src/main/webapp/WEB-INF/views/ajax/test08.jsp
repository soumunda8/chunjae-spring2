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
    <title>Ajax Test08</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <style>
        #tb1 { border-collapse: collapse; }
        #tb1 th { border-top:2px solid #333; border-bottom:2px solid #333; background-color:gold; line-height:30px; min-width:150px;
            padding-left: 24px; padding-right: 24px; }
        #tb1 td { border-bottom:1px solid #333;  line-height: 30px; min-width:150px;  padding-left: 24px; padding-right: 24px; }
        #tb1 tbody tr:last-child td { background-color:#eee; }
    </style>
</head>
<body>
    <nav>
        <h2>08_Post + Parameter/Object + List 전송</h2>
        <hr />
        <ul>
            <li><a href="${path }/ajax/">Home</a></li>
        </ul>
        <input type="text" name="num" id="num" placeholder="연번 입력" value="12" readonly required /><br />
        <input type="text" name="title" id="title" placeholder="제목 입력" required /><br />
        <button id="btn08" type="button">Post 전송</button>
        <button id="empty" type="button">결과 비우기</button>
        <hr />
        <h3>결과 목록</h3>
        <div id="res">
            <table id="tb1">
                <thead>
                <tr>
                    <th>연번</th>
                    <th>제목</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
        <script>
            $(document).ready(function(){
                $("#btn08").click(function(){
                    var test = {"num" : parseInt($("#num").val()), "title" : $("#title").val()};
                    var txt = "";
                    $.ajax({
                        type:"post",
                        url:"${path }/ajax/test08Pro",
                        data:JSON.stringify(test),
                        dataType:"json",
                        contentType:"application/json",
                        success:function(res) {
                            console.log("성공", res);
                            console.log("성공", res[0]);
                            for(let i in res) {
                                console.log(res[i]);
                                txt += "<tr><td>" + res[i].num +"</td><td>" + res[i].title + "</td></tr>";
                            }
                            $("#tb1 tbody").html(txt);
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