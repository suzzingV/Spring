package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; //WEB-INF 밑의 자원들은 외부에서 호출되지 않음 컨트롤러 통해서만
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath); //controller에서 view로 이동할 때 사용
        dispatcher.forward(req, resp);
    }
}
