package nl.vijfhart.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class HelloImpl {

    public HelloImpl() {
    }

    public String sayHello(@WebParam(name = "someName") String someName) {
        return String.format("And a special hello to %s!", someName);
    }
}