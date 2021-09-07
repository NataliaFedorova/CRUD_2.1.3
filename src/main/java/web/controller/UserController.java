package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(ModelMap model) {
        // показывает данные всех людей из бд
        model.addAttribute("users",userService.getAllUsers());
        return "users/get_all_users";
    }

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") int id, ModelMap model) {
        //показывает одного человека из бд
        model.addAttribute("user", userService.getOneUser(id));
        return "users/get_one_user";
    }

    @GetMapping("users/new")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user, BindingResult bindingResult) {
        // Добавляем пользователя в бд
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
    //возвращает html-стрраницу для редактирования человека
        model.addAttribute("user", userService.getOneUser(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") int id) {
        try {
            userService.deleteUser(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/users";
    }
}