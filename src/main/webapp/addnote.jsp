<<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Notebook Application</title>
</head>
<body>
<div class="main">
  <h1>Search Result</h1>
  <%
    List<String> patients = (List<String>) request.getAttribute("notes");
    if (patients.size() !=0)
    {
  %>
  <ul>
    <%
      for (String patient : patients)
      {
    %>
    <li><%=patient%></li>
    <% }
    } else
    {%>
    <p>Nothing found</p>
    <%}%>
  </ul>
</div>
</body>
</html>
