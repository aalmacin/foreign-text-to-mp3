package com.raidrin.foreigntexttomp3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConvertController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/generate")
    public String generate(
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String lang,
            @RequestParam(name = "multi-mp3", required = false) Boolean multipleMP3,
            Model model
    ) {
        List<String> errors = new ArrayList<>();
        boolean emptyText = text == null || text.isEmpty();
        boolean emptyLang = lang == null || lang.isEmpty();
        if (emptyText) {
            errors.add("Text cannot be empty");
        }
        if(emptyLang) {
            errors.add("Language cannot be empty");
        }
        if(emptyLang || emptyText) {
            model.addAttribute("errors", errors);
            return "index";
        }
        model.addAttribute("text", text);
        model.addAttribute("lang", lang);
        model.addAttribute("multiMP3", multipleMP3 ? "multi mp3" : "single mp3");
        return "generated";
    }

    @PostMapping("/g")
    public String gx() {
        return "generated";
    }
}
