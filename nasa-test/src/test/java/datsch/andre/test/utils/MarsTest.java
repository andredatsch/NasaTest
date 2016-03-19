package datsch.andre.test.utils;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response.Status;

import org.junit.Test;


public class MarsTest  {

	private static final String URL = "http://localhost:8080/rest/mars/";

	@Test
	public void testCase1( ) {

		String command = "MMRMMRMMRMMR";
		
		Retorno retorno = NasaRestClient.post(URL + command);

		assertEquals(Status.OK.getStatusCode(), retorno.getStatus());
		assertEquals("0, 0, N", retorno.getRetorno());
	}
	
	@Test
	public void testCase2( ) {
		
		String command = "MML";
		
		Retorno retorno = NasaRestClient.post(URL + command);
		
		assertEquals(Status.OK.getStatusCode(), retorno.getStatus());
		assertEquals("0, 2, W", retorno.getRetorno());
	}
	
	@Test
	public void testCase3( ) {
		
		String command = "AAA";
		
		Retorno retorno = NasaRestClient.post(URL + command);
		
		assertEquals(Status.BAD_REQUEST.getStatusCode(), retorno.getStatus());
	}
	
	@Test
	public void testCase4( ) {
		
		String command = "MMMMMMMMMMMM";
		
		Retorno retorno = NasaRestClient.post(URL + command);
		
		assertEquals(Status.BAD_REQUEST.getStatusCode(), retorno.getStatus());
	}
	
	@Test
	public void testCase5( ) {

		String command = "MMMMRMMMMRMMMMRMMMMR";
		
		Retorno retorno = NasaRestClient.post(URL + command);

		assertEquals(Status.OK.getStatusCode(), retorno.getStatus());
		assertEquals("0, 0, N", retorno.getRetorno());
	}
	
}
