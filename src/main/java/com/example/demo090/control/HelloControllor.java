package com.example.demo090.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//这个类的所有方法的返回数据直接写给浏览器，对象为json
@ResponseBody
//可替代上面两个
//@RestController
public class HelloControllor {


    @RequestMapping("/hello")
    public String showHello(){
        return "hello";
    }
}
