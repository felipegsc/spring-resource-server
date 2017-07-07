package demos.resourceserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = { "/hello", "/hello-admin", "/hello-user" })
public class HelloController {
	
	@GetMapping
	@ResponseBody
	public String sayHello() {
		return "Hello, it's me!";
	}

}
