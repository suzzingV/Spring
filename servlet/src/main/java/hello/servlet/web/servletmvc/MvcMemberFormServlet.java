package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; //WEB-INF 밑의 자원들은 외부에서 호출되지 않음 컨트롤러 통해서만
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath); //controller에서 view로 이동할 때 사용
        dispatcher.forward(req, resp); //서블릿에서 jsp 호출 //서버내에서 다시 호출(리다이렉트 아님)

    }
}
