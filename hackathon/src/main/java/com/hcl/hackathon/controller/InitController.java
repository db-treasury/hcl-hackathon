package com.hcl.hackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {
  @RequestMapping("/hackathon")
  @ResponseBody
  public String index(){
    return "Hackthon 2021";
  }
}
