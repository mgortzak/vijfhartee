
package nl.vijfhart.soap;

import nl.vijfhart.ws.HelloWorld;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

@WebService(
        portName = "HelloWorldImplPort",
        serviceName = "/ws/hello/HelloWorldService",
        targetNamespace = "http://ws.vijfhart.nl/",
        wsdlLocation = "http://localhost:7003/VijfhartWebapp/ws/hello/HelloWorldService?wsdl",
        endpointInterface = "nl.vijfhart.ws.HelloWorld"
)
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class HelloWorldImpl implements HelloWorld {


    public HelloWorldImpl() {
    }

    /**
     * @param text
     * @return returns java.lang.String
     */
    @Override
    public String getHelloWorldAsString(String text) {
        return String.format("Hello %s!", text);
    }
}
