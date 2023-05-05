package delphiDisplays.restAPI.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import delphiDisplays.restAPI.models.User;
import jakarta.transaction.Transactional;

@Repository
public interface userRepository extends CrudRepository<User, String>{
	//to check if email exists in the db
	
	@Query(value = "SELECT email FROM users WHERE email = :email", nativeQuery = true)
	ArrayList<String> checkUserEmail(@Param("email") String email); 
	
	//to get the password for that email and verify it with whats provided in the form
	@Query(value = "SELECT password FROM users WHERE email = :email", nativeQuery = true)
	String checkUserPasswordByEmail(@Param("email") String email);
	
	//to get the password for that email and verify it with whats provided in the form
	@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
	User getUserDetailsByEmail(@Param("email") String email);

	
	/**
	 * @param user_id
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param password
	 * @param calories
	 * @param total_fat
	 * @param saturated_fat
	 * @param sodium
	 * @param carbohydrates
	 * @param sugars
	 * @param protein
	 */
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO USERS(first_name, last_name, email, password, calories, total_fat, saturated_fat, sodium, carbohydrates, sugars, protein)"
					+ "VALUES(:first_name, :last_name, :email, :password, :calories, :total_fat, :saturated_fat, :sodium, :carbohydrates, :sugars, :protein)", nativeQuery = true)
	int registerNewUser(
					 @Param("first_name") String first_name,
					 @Param("last_name") String last_name,
					 @Param("email") String email,
					 @Param("password") String password,
					 @Param("calories") String calories,
					 @Param("total_fat") String total_fat,
					 @Param("saturated_fat") String saturated_fat,
					 @Param("sodium") String sodium, 
					 @Param("carbohydrates") String carbohydrates, 
					 @Param("sugars") String sugars, 
					 @Param("protein") String protein); 
			
}
