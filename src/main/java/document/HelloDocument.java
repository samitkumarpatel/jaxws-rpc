package document;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "HelloDocument", targetNamespace = "http://com.me/v1")
@SOAPBinding(style = Style.DOCUMENT)
public interface HelloDocument {
	
	@WebMethod (operationName  = "getHello")
	@RequestWrapper(targetNamespace = "http://com.me/v1")
	@ResponseWrapper(targetNamespace = "http://com.me/v1")
	public @WebResult(name = "getHello" , targetNamespace = "http://com.me/v1" , partName = "getHello") String getHello();
}
