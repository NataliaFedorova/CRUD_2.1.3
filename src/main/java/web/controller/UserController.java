package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(ModelMap model) {
        // показывает данные всех людей из бд
        model.addAttribute("users",userService.getAllUsers());
        return "get_all_users";
    }

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") Long id, ModelMap model) {
        //показывает данные одного человека из бд по ID
        model.addAttribute("user", userService.getOneUser(id));
        return "get_one_user";
    }

    @GetMapping("/new")
    public String createUserForm (Model model) {
        //возвращает html-страницу для добавления нового пользователя
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm (Model model, @PathVariable("id") Long id) {
        //возвращает html-страницу для редактирования человека
        model.addAttribute("user", userService.getOneUser(id));
        return "edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        // добавляет пользователя в бд
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, @PathVariable("id") Long id, BindingResult bindingResult) {
        // обновляет данные пользователя в бд
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable("id") Long id) {
        // удаляет пользователя
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
