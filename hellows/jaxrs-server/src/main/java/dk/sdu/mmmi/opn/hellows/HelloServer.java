package dk.sdu.mmmi.opn.hellows;

import io.swagger.model.Person;
import io.swagger.model.StatusDTO;

public class HelloServer {

	public static HelloServer get() {
		return singleton;
	}
	private static final HelloServer singleton = new HelloServer();
	private int helloCount = 0;
	public StatusDTO hello(Person who) {
		System.out.println("Hello, "+who.getFirstName()+" "+who.getLastName());
		return new StatusDTO().helloCount(helloCount++);
	}
}
