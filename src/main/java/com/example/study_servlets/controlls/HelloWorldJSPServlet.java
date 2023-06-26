package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldJSPServlet")
public class HelloWorldJSPServlet extends HttpServlet {
<<<<<<< HEAD
=======
    // MVC Client-controller-view 삼각관계에서 중재자 역할.
>>>>>>> dd4ef621225f021a02c143296c37e58b8ffe4b15
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
<<<<<<< HEAD

            // 클라이언트에게 네트워크를 통해서 전송 하는 것

            String contents = "Yoju Lab !";
            request.setAttribute("contents", contents);
            // 다음 파일 호출 하자.
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/HelloWorldJSP.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

=======
            String contents = "hello";
            // client 에 들어온 url을 받아 여기 있는 변수의 contensts를
            // JSP로 호출하여 변수를 넘겨준다.
            // 결국 client에게 표시
request.setAttribute("contents",contents);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloworldJSP.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("HelloWorldServlet - doGet() done.");
>>>>>>> dd4ef621225f021a02c143296c37e58b8ffe4b15
    }

}
