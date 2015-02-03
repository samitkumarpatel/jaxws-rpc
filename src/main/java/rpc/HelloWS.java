package rpc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name="HelloWS", targetNamespace ="http://com.samit/v1")
@SOAPBinding(style = Style.RPC)
public interface HelloWS {
	
    @WebMethod(operationName = "sayHello")
    @RequestWrapper(className = "java.lang.String", targetNamespace = "http://com.samit/v1")
    @ResponseWrapper(className = "java.lang.String", targetNamespace = "http://com.samit/v1")
    public @WebResult(targetNamespace = "http://com.samit/v1" , name = "sayHello" , partName = "sayHello") 
    				String sayHello(@WebParam(name = "message", targetNamespace = "http://com.samit/v1") String message);

}
