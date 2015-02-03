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
import org.junit.Test;

import document.HelloDocument;
import document.HelloDocumentImpl;
import rpc.HelloWS;
import rpc.HelloWSImpl;

public class HelloDocumentTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Endpoint.publish("http://localhost:9999/document", new HelloDocumentImpl());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDocument() throws Exception{
		URL url = new URL("http://localhost:9999/document?wsdl");
		QName qname = new QName("http://com.me/v1", "HelloDocumentImplService");
		Service service = Service.create(url, qname);
		HelloDocument hello = service.getPort(HelloDocument.class);
		
		assertEquals("Hello World !", hello.getHello());
	}

}
