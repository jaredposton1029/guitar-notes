package com.guitar.notes;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

  @GetMapping("/greeting")
  public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
      Model model) {
    model.addAttribute("name", name);
    return "greeting";
  }

  @GetMapping("/6-string-guitar")
  public String guitar(Model model) {
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList("E", "A", "D", "G", "B", "E"));
    model.addAttribute("strings", strings);
    return "6-string-guitar";
  }
}
