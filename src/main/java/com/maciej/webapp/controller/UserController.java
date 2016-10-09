package com.maciej.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.webapp.dao.UserDAO;
import com.maciej.webapp.model.User;

@Controller
public class UserController {

	@Autowired
	protected UserDAO user;

	@RequestMapping(value = { "/*", "/users" })
	public String getUsers(Model model) {
		List<User> users = user.list();
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping(value = "create-user")
    public String createUserGet(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }
 
    @RequestMapping(value = "create-user", method = RequestMethod.POST)
    public String createUserPost(@ModelAttribute("user") User newUser) {
        user.save(newUser);
        return "redirect:users";
    }
}