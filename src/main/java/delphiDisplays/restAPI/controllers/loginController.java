package delphiDisplays.restAPI.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import delphiDisplays.restAPI.models.User;
import delphiDisplays.restAPI.models.userLogin;
import delphiDisplays.restAPI.services.userService;

@RestController
public class loginController {
	
	@Autowired
	userService uService; 
	
	//information from android login page comes here as Json File
	@PostMapping("/delphi/login")
	public ResponseEntity authenticateUser(userLogin login) {  //add @RequestBody 
		//get user email
		ArrayList<String> userEmail = uService.checkUserEmail(login.getEmail()); 
				
		if(userEmail.isEmpty())
			return new ResponseEntity("Email Address Not Found!", HttpStatus.NOT_FOUND);  
		
		//get user password
		String userPassword = uService.checkUserPasswordByEmail(login.getEmail()); 
		
		//validate the password
		if(!userPassword.equals(login.getPassword())) {
			System.out.println("password in db: " + userPassword);
			System.out.println("password in FORM: " + login.getPassword());
			return new ResponseEntity("Password Incorrect!", HttpStatus.BAD_REQUEST);  
		}
		
		System.out.println("Trying to get userInfo: ");
		User userInfo = uService.getUserDetailsByEmail(login.getEmail()); 
		System.out.println(userInfo);
		return new ResponseEntity(userInfo, HttpStatus.OK); 
	}
} 
