<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Notebook Application</title>
</head>
<body>
<div class="main">
    <h1>Note Application</h1>

    <a href="addpage.html">add</a>

    <form method="POST" action="/sortnotes.html">
        <input type="submit" value="sort"/>
    </form>
    <form method="POST" action="/searchnotes.html">
        <input type="text" name = "query" placeholder="Put the query here"/>
        <input type="submit" value="search"/>
    </form>
    <%
        List<String> notes = (List<String>) request.getAttribute("notes");
        if (notes != null && notes.size() !=0)
        {
    %>
    <ul>
        <%
            for (int i = 0;i<notes.size();i++)
            {
                String note = notes.get(i);
        %>
        <li><%=note%></li>
        <form method="POST" action="/deletenote.html?index=<%=i%>">
            <input type="submit" value="Delete"/>
        </form>
        <form method="POST" action="/editnote.html?index=<%=i%>">
            <input type="submit" value="Edit"/>
        </form>
        <% }

        } else
        {%>
        <p>Nothing found</p>
        <%}%>

    </ul>
</div>
</body>
</html>