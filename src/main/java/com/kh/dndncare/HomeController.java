package com.kh.dndncare;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	
	@GetMapping("home.do")
	public String home() {
		return "home";
	}
	
	public String generateState()
	{
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
	
	@GetMapping("naver.lo")
	public String naver() {
		return "naverTest";
	}
	
	@GetMapping("callback.lo")
	public String callback() {
		return "callback";
	}
	

}
