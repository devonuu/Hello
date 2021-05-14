package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @GetMapping(path = "/hello")
  public String hello(Model model){
    model.addAttribute("data", "hello!!");
    return "hello";
  }

  @GetMapping(path = "/hello-mvc")
  public String helloMvc(
      @RequestParam(name = "name", required = true, defaultValue = "default") String name,
      Model model
  ){
    model.addAttribute("name", name);
    return "hello-template";
  }

  @GetMapping(path = "/hello-string")
  @ResponseBody
  public String helloString(@RequestParam("name") String name){
    return "hello" + name;
  }

  @GetMapping(path = "/hello-api")
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
