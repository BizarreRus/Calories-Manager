package com.bizarrerus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bizarrerus.AuthorizedUser;
import com.bizarrerus.service.MealService;
import com.bizarrerus.util.MealsUtil;

@Controller
public class RootController {

    @Autowired
    private MealService mealService;

    @GetMapping("/")
    public String root() {
        return "redirect:meals";
    }

    @GetMapping("/users")
    public String users(Model model) {
        return "users";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/meals")
    public String meals(Model model) {
        model.addAttribute("meals",
                MealsUtil.getWithExceeded(mealService.getAll(AuthorizedUser.id()), AuthorizedUser.getCaloriesPerDay()));
        return "meals";
    }
}