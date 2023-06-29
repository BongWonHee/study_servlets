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