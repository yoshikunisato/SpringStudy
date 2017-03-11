package com.lab.study.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lab.study.form.LoginForm;
import com.lab.study.model.Users;
import com.lab.study.repository.UsersRepository;
import com.lab.study.validation.GroupOrder;

// コントローラのアノテーション
@Controller
public class LoginController {
	@Autowired
	private UsersRepository userRep;
	
	// 呼び出されるURL(リクエスト)を明示するアノテーション
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	// 呼び出されるURL(リクエスト)を明示するアノテーション
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @Validated(GroupOrder.class) @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}

		List<Users> userList = userRep.findById(loginForm.getUserId());

		if (userList.size() > 0) {
			model.addAttribute("userName", userList.get(0).getName());
			return "top";
		} else {
			return "index";
		}

	}
}