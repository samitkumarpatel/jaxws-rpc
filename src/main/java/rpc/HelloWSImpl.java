package rpc;

import javax.jws.WebService;

@WebService(endpointInterface = "rpc.HelloWS", targetNamespace = "http://com.samit/v1")
public class HelloWSImpl implements HelloWS {

	@Override
	public String sayHello(String message) {
		return "Hello ! "+message;
	}

}
