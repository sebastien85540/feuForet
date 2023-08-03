package com.cirilgroup.feuforet.controller;

import com.cirilgroup.feuforet.model.Foret;
import com.cirilgroup.feuforet.service.ForetFeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@Scope("request")
public class FeuForetController {

    @Autowired
    private ForetFeuService feuService;

    @GetMapping("/")
    public String vueForm(Model model){
        model.addAttribute("foret", new Foret(10, 10));
        return "feuForetForm";
    }

    @PostMapping("/feu-foret")
    public String simulationFeuForet(@RequestBody Foret foret, Model model){
        int nbreCoups = feuService.simulationFeuForet(foret);
        model.addAttribute("coups", nbreCoups);
        return "feuForet";
    }
}
