package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
Faker f=new Faker(); //Faker class is a predefined class which generate fake user,passwords,emailids
public String randomusername() {
	return f.name().username();
	
}
public String randompassword() {
	return f.internet().password();
}
public String randomfullname() {
	return f.name().fullName();
	
}
public String randomemailid() {
	return f.internet().emailAddress();
}
public String randomphonenumber() {
	return f.phoneNumber().cellPhone();
}
}
