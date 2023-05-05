package delphiDisplays.restAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delphi")
public class getUserInfoController {
	
	@GetMapping("/test")
	public String testEndpoint() {
		return "testEndPoint() works!!"; 
	}
}
