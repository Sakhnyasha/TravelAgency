package org.sakhnyasha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView sayHello() {
        ModelAndView view = new ModelAndView();
        view.setViewName("test");
        view.addObject("name", "Ann");
        return view;
    }
}
