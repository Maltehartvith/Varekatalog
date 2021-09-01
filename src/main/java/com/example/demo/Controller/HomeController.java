package com.example.demo.Controller;

import com.example.demo.Model.Vare;
import com.example.demo.Service.VareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    VareService vareService;

    @GetMapping("/")
    public String index(Model model){
        List<Vare> vareList = vareService.showAllVare();
        model.addAttribute("vare", vareList );
        return "/index";
    }
    @GetMapping("/viewVare/{id}")
    public String viewVare(@PathVariable("id") int id, Model model){
        model.addAttribute("vare", vareService.findVareById(id));
        return "/Home/viewVare";
    }
    @GetMapping("/updateVare/{id}")
    public String updateVare(@PathVariable("id") int id, Model model){
        model.addAttribute("vare", vareService.findVareById(id));
        return "/Home/updateVare";
    }
    @PostMapping("/updateVare")
    public String updateVare(@ModelAttribute Vare v){
        vareService.updateVare(v);
        return "redirect:/";
    }
    @GetMapping("/deleteVare/{id}")
    public String deleteVare(@PathVariable("id") int id, Model model){
        vareService.deleteVare(id);
        return "redirect:/";
    }
    @GetMapping("/createVare")
    public String createVare(){
        return "/Home/createVare";
    }

    @PostMapping("/createVare")
    public String createVare(@ModelAttribute Vare v){
        vareService.createVare(v);
        return "redirect:/";
    }

}
