<%--
  Created by IntelliJ IDEA.
  User: lishen
  Date: 6/9/20
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container{
            overflow: hidden;
        }
        #sub{
            width: 10%;
            float: right;
        }
    </style>
</head>
<body>

    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>新增书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
            <input type="hidden" name="bookID" value="${getBook.bookID}">
            <div class="form-group">
                <label for="bkName">书籍名称:</label>
                <input type="text" name="bookName" class="form-control" id="bkName" value="${getBook.bookName}">
            </div>
            <div class="form-group">
                <label for="bkCount">书籍数量:</label>
                <input type="text" name="bookCounts" class="form-control" id="bkCount" value="${getBook.bookCounts}">
            </div>
            <div class="form-group">
                <label for="bkDetail">书籍描述:</label>
                <input type="text" name="detail" class="form-control" id="bkDetail" value="${getBook.detail}">
            </div>
            <div id="sub">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>

    </div>

</body>
</html>
