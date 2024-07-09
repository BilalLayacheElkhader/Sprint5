package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.controller;


import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.dto.dtoBranch;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/branch")
    public class BranchController {
        @Autowired
        private BranchService branchService;

        @GetMapping("/home")
        public String index (Model model){
            model.addAttribute("branch", branchService.getAllBranch());
            return "home";
        }
        @PostMapping("/add")
        public String addBranch(@ModelAttribute("newBranch")dtoBranch dtobranch){
            branchService.save(dtobranch);
            return "redirect:/branch/home";
        }
        @GetMapping("/addBranch")
        public String addBranch(Model model){
            dtoBranch dtoBranch = new dtoBranch();
            model.addAttribute("newBranch",dtoBranch);
            return "addBranch";
        }
        @PostMapping("/update")
        public String updateBranch(@ModelAttribute("branchUpdate")dtoBranch dtobranch){
            branchService.updateBranch(dtobranch);
            return "redirect:/branch/home";
        }
        @GetMapping("/update/{id}")
        public String updateForm(@PathVariable int id, Model model){
            dtoBranch dtobranch = branchService.getById(id);
            model.addAttribute("branchUpdate",dtobranch);
            return "editBranchForm";
        }
        @GetMapping("/delete/{id}")
        public String deleteBranch(@PathVariable int id){
            branchService.deleteBranch(id);
            return "redirect:/branch/home";
        }
}
