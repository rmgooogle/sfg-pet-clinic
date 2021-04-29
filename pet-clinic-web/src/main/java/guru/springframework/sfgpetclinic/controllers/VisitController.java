package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitController {


    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }
    @RequestMapping({"/visits", "/visits/index", "/visits/index.html","visits.html"})
    public String listVisits (Model model){
        model.addAttribute("visits", visitService.findAll());

        return "visits/index";
    }
}
