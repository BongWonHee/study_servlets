<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <% System.out.println("HelloWorldJSP - doGet()"); %>


        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>HelloWordlJSP</title>
        </head>

        <body>
            <% String usernameSession=(String)session.getAttribute("username"); %>
                <div>
                    Username : <%= usernameSession %>
                </div>
                <div>
                    Login Status :
                    <% if (usernameSession==null){ %>
                        <button type="submit" formaction="/session/CreateServlet?username=yojulab&password=1234" method="get">Login</button>
                    <% }else{ %>
                        Logout
                    <% } %>
                </div>
                <% String contents=(String)request.getAttribute("contents"); %>
                    <div>
                        html Value : Yoju lab !
                    </div>

                    <div>
                        Code Value : <%= contents %>
                    </div>

        </body>

        </html>
        <% System.out.println("HelloWorldJSP - doGet() done."); %>