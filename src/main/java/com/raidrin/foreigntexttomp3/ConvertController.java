package com.raidrin.foreigntexttomp3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/generate")
    public String generate(@RequestParam String text, @RequestParam String lang, Model model) {
        model.addAttribute("text", text);
        model.addAttribute("lang", lang);
        return "generated";
    }

    @PostMapping("/g")
    public String gx() {
        return "generated";
    }
}
