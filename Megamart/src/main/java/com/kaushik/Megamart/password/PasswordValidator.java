package com.kaushik.Megamart.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kaushik.Megamart.model.Register;

 
 
public class PasswordValidator implements Validator {
 
	 private Pattern pattern;    
	 private Matcher matcher;
	 
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"    
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 private static final String STRING_PATTERN = "[a-zA-Z]+"; 
	 private static final String PASSWORD_PATTERN = 
             "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	 
 @Override
 public boolean supports(Class arg0) {
  return Register.class.equals(arg0);
 }
 
 @Override
 public void validate(Object obj, Errors e) {
   ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
   ValidationUtils.rejectIfEmpty(e, "email", "email.empty");
   ValidationUtils.rejectIfEmpty(e, "password", "password.empty");
   ValidationUtils.rejectIfEmpty(e, "confirmpassword", "confirmpassword.empty");
    
   Register user = (Register)obj;
   if(!user.getPassword().equals(user.getConfirmpassword())){
    e.rejectValue("confirmpassword","confirmpassword.notequal");
   }
// email validation in spring
   if (!(user.getEmail() != null && user.getEmail().isEmpty())) {    
	   pattern = Pattern.compile(EMAIL_PATTERN);    
	   matcher = pattern.matcher(user.getEmail());    
	   if (!matcher.matches()) {    
	    e.rejectValue("email", "email.incorrect",    
	      "Enter a correct email");    
	   }    
	  }
// input string contains characters only 
   if (!(user.getName() != null && user.getName().isEmpty())) {    
	   pattern = Pattern.compile(STRING_PATTERN);    
	   matcher = pattern.matcher(user.getName());    
	   if (!matcher.matches()) {    
	    e.rejectValue("name", "name.containNonChar",    
	      "Enter a valid name");    
	   }    
	  }   
// input password contains valid password only 
   if (!(user.getPassword() != null && user.getPassword().isEmpty())) {    
	   pattern = Pattern.compile(PASSWORD_PATTERN);    
	   matcher = pattern.matcher(user.getPassword());    
	   if (!matcher.matches()) {    
	    e.rejectValue("password", "password.invalidPassword",    
	      "must contains one digit from 0-9"); 
	    e.rejectValue("password", "password.invalidPassword",    
	  	      "must contains one lowercase characters"); 
	    e.rejectValue("password", "password.invalidPassword",    
		  	      "must contains one uppercase characters");
	    e.rejectValue("password", "password.invalidPassword",    
		  	      "must contains one special symbols in the list \"@#$%\"");
	   }    
	  } 
 }
 
}