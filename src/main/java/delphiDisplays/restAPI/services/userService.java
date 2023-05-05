package delphiDisplays.restAPI.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delphiDisplays.restAPI.models.User;
import delphiDisplays.restAPI.repository.userRepository;

@Service	
public class userService {

	
	@Autowired
	userRepository userRepo; 
	
	
	public int registerNewUserService(String first_name, String last_name, String email, String password, String calories, String total_fat, String saturated_fat, String sodium, String carbohydrates, String sugar, String protein) {
		return userRepo.registerNewUser(first_name, last_name, email, password, calories, total_fat, saturated_fat, sodium, carbohydrates, sugar, protein);
	}
	
	
	
	//login Service Methods
	public ArrayList<String> checkUserEmail(String email){
		return userRepo.checkUserEmail(email);  
	}
	
	public String checkUserPasswordByEmail(String email){
		return userRepo.checkUserPasswordByEmail(email); 
	}
	public User getUserDetailsByEmail(String email){
		return userRepo.getUserDetailsByEmail(email); 
	} 
}
