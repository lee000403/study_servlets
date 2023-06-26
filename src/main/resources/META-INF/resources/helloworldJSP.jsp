<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% System.out.println("HelloWorldJSP - doGet()"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <% String uernameSession = (String) session.getAttribute("username");  %>
    <div>
        User Name : <%= uernameSession %>
    </div>
    <div>
        Login Status :
        <form action="">
            <% if(uernameSession == null) { %>
                <button type="submit" formaction="/session/CreateServlet?username=yojulab&password=1234" method="get">Login</button>
            <% } else { %>
                <button type="submit" formaction="/session/DeleteServlet" method="get">Logout</button>
            <% } %>
        </form>
    </div>
    <% String contents = (String)request.getAttribute("contents"); %>
    <div>
        HTML Value : Yoju Lab !
    </div>
    <DIV>
        Code Value : <%= contents%>
    </DIV>
    
</body>
</html>
<% System.out.println("HelloWorldJSP - doGet() done."); %>