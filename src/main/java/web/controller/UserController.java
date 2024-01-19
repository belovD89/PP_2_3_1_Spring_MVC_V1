package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.servise.UserService;

import java.util.List;

@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView findAll() {
        return new ModelAndView("index").addObject("users", userService.findAll());
    }

    @GetMapping("/user-create")
    public ModelAndView createUserFrom(@ModelAttribute("user") User user) {
        return new ModelAndView("user-create");
    }

    @PostMapping("/user-create")
    public ModelAndView createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("user-delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("user-update/{id}")
    public ModelAndView updateUserForm(@PathVariable("id") Long id) {
        return new ModelAndView("user-update").addObject("user", userService.findById(id));
    }

    @PostMapping("/user-update")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return new ModelAndView("redirect:/");
    }
}
