package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); //메시지 바디의 내용 바이트 코드로 바로 얻을 수 있음
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//StreamUtils: 스프링이 제공

        System.out.println("messageBody = " + messageBody); //메시지 바디에 있는 내용 그대로 나옴

        response.getWriter().write("ok");
    }
}
