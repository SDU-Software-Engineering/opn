package dk.sdu.mmmi.opn.hellows;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.PersonApi;
import io.swagger.client.model.Person;
import io.swagger.client.model.StatusDTO;

public class Client {

	public static void main(String[] args) throws ApiException {
		ApiClient client = new ApiClient();
		client.setBasePath("http://localhost:8080");
		PersonApi api = new PersonApi(client);
		Person p1 = new Person().firstName("Ulrik").lastName("Schultz");
		System.out.println("Making call...");
		StatusDTO status = api.helloWorldHello(p1);
		System.out.println("Made call, status: "+status);
		System.out.println("Making two calls...");
		api.helloWorldHello(p1);
		status = api.helloWorldHello(p1);
		System.out.println("Made calls, status: "+status);
	}

}
