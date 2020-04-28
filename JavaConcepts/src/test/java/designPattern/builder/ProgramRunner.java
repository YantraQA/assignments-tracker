package designPattern.builder;

import designPattern.builder.User;

public class ProgramRunner 
{
//	builder-It is one of the Gang of Four design patterns.
// Abstract interface for creating objects (product).
	public static void main(String[] args) 
	{
		User user = new User.UserBuilder()
		.withFirstNameAs("Pornima")
		.withLastNameAs("Alkari")
		.withAddressAs("Pune")
		.withMobileAs("123456789")
		.withAgeAs(15).build();
		
	}

}
