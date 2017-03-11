package com.lab.study;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.lab.study.validation.GroupOrder1;
import com.lab.study.validation.GroupOrder2;

public class LoginForm {
	@NotNull(groups = { GroupOrder1.class }, message = "ユーザ名を入力してください。")
	private Integer userId;

	@NotEmpty(groups = { GroupOrder1.class }, message = "パスワードを入力してください。")
	@Size(min=8,max=16,groups={GroupOrder2.class},message="パスワードは{min}文字以上{max}文字以下です。")
	@Pattern(regexp = "[a-zA-Z0-9]*", groups = { GroupOrder2.class }, message = "パスワードは英数である必要があります。")
	private String loginPassword;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}