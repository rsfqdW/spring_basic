package spring.study1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // spring framework 를 사용하기 위해
public class HelloController {

    @GetMapping("hello") // 웹 어플리케이션에서 /hello로 들어오면 해당 메서드 호출
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        // attribute 의 이름이 "data"인 곳에 value 로 "hello!!" 가 들어감
        return "hello";
        //return값이 hello이므로 hello.html을 찾아서 들어감
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloSpring(@RequestParam("name") String name){
        return "hello " + name;
    }

    //json(key:value)형식으로 값 출력
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}