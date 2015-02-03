package servicetest;

import static org.junit.Assert.*;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import rpc.HelloWS;
import rpc.HelloWSImpl;

public class HelloWSTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Endpoint.publish("http://localhost:9999/rpc", new HelloWSImpl());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRpc() throws Exception{
		URL url = new URL("http://localhost:9999/rpc?wsdl");
		QName qname = new QName("http://com.samit/v1", "HelloWSImplService");
		Service service = Service.create(url, qname);
		HelloWS hello = service.getPort(HelloWS.class);
		
		assertEquals("Hello ! samit", hello.sayHello("samit"));
	}

}
