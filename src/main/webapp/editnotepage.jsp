<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Notebook Application</title>
</head>
<body>
<div class="main">
    <h1>Note Application</h1>

    <form method="POST" action="/replacenote.html?index=<%=request.getAttribute("index")%>">
        <input type="text" name="note" placeholder="Enter note here" value="<%=request.getAttribute("note")%>"/>
        <input type="text" name="content" placeholder="Enter content here" value="<%=request.getAttribute("content")%>"/>
        <input type="submit" value="add"/>
    </form>

    </ul>
</div>
</body>
</html>