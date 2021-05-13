package com.example.hello.controller;

import com.example.hello.dto.UserInfo;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당 클래스는 REST API를 처리하는 컨트롤러로 등록된다.
@RequestMapping("/api") // URI를 지정해주는 어노테이션
public class APIController {

  @GetMapping(path ="/hello") //http://localhost:9090/api/hello
  public String hello(){
    return "hello spring boot";
  }

  @RequestMapping(path = "/hi", method = RequestMethod.GET)
  public String hi(){
    return "hi";
  }

  @GetMapping(path = "/path-variable/{name}")
  public String pathVariable(
      //@PathVariable String name,
      @PathVariable(name = "name") String pathName
  ){
    System.out.println("PathVariable = " + pathName);
    return pathName;
  }

  //http://localhost:9090/api/query-param?user=steve&email=gonuu@gmail.com&age=30
  @GetMapping(path = "/query-param")
  public String queryParam(@RequestParam Map<String,String> queryParam){
    StringBuilder sb = new StringBuilder();
    queryParam.entrySet().forEach(entry -> {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
      System.out.println();
      sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
    });
    return sb.toString();
  }

  @GetMapping(path = "/query-param02")
  public String queryParam02(
      @RequestParam String user,
      @RequestParam String email,
      @RequestParam int age
  ){
    StringBuilder sb = new StringBuilder();
    sb.append(user + " " + email + " " + age);
    return sb.toString();
  }

  @GetMapping(path = "/query-param03")
  public String queryParam03(
      UserInfo userInfo
  ){
    System.out.println(userInfo.toString());
    return userInfo.toString();
  }
}
