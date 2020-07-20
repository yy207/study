package cn.cps.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class SessionController {

    private final String SESSION_NAME = "session_name";

    @GetMapping("/loginInfo")
    public String loginInfo(HttpServletRequest request){
        Object o = request.getSession().getAttribute(SESSION_NAME);
        return JSON.toJSONString(o);
    }

    @GetMapping("/loginInfo2")
    public String loginInfo(){
        return JSON.toJSONString("loginInfo2");
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        String name = request.getParameter("name");
        request.getSession().setAttribute(SESSION_NAME,name);
        return "登录成功!";
    }

}
