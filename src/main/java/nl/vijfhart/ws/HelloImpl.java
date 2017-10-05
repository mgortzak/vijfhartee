package nl.vijfhart.ws;

import javax.jws.WebService;

@WebService
public class HelloImpl {

    public HelloImpl() {
    }

    public String sayHello(String name) {
        return String.format("Hello %s!", name);
    }
}