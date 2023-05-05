package delphiDisplays.restAPI.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import delphiDisplays.restAPI.services.userService;

@RestController 		
public class registerController {
	
	
	//call user service method to add a user
	
	@Autowired
	userService uService; 
	
	
	
	//parameters or data from the form comes here
	@PostMapping("/delphi/register")
	public ResponseEntity addNewUser(
			 @RequestParam("first_name") String first_name,
			 @RequestParam("last_name") String last_name,
			 @RequestParam("email") String email,
			 @RequestParam("password") String password,
			 @RequestParam("calories") String calories,
			 @RequestParam("total_fat") String total_fat,
			 @RequestParam("saturated_fat") String saturated_fat,
			 @RequestParam("sodium") String sodium, 
			 @RequestParam("carbohydrates") String carbohydrates, 
			 @RequestParam("sugars") String sugars, 
			 @RequestParam("protein") String protein) {
			
	
		//encrypt password
		
		
		
		//register User
		int result = uService.registerNewUserService(first_name, last_name, email, password, calories, total_fat, saturated_fat, sodium, carbohydrates, sugars, protein);
		
	
		if(result != 1)
			return new ResponseEntity<>("User Registration Failed", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
		
	}
}
