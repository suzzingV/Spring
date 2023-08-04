package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j //lombok이 13번째줄 자동으로 해줌
@RestController //문자 바로 HTTP 메시지 바디에 바로 입력
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass()); //getClass(): 내 클래스

    @RequestMapping("/log-test")
    public String logTest() {

        String name = "Spring";

        System.out.println("name = " + name);

        log.trace(" trace my log=" + name); //연산 일어나서 낭비g

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
