package document;

import javax.jws.WebService;

@WebService (endpointInterface = "document.HelloDocument", targetNamespace = "http://com.me/v1")
public class HelloDocumentImpl implements HelloDocument {

	@Override
	public String getHello() {
		return "Hello World !";
	}

}
