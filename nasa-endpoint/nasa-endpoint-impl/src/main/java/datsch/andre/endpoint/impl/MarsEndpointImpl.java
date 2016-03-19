package datsch.andre.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import datsch.andre.endpoint.api.MarsEndpoint;
import datsch.andre.service.api.MarsService;

/**
 * 
 * Implementação do Endpoint de comandos do Robo
 * @author Andre
 */
public class MarsEndpointImpl implements MarsEndpoint {

	@EJB
	private MarsService marsService;

	@Override
	public Response command( String command ) {

		try {

			String retorno = marsService.processaComando(command);

			return Response.ok(retorno).build();

		} catch ( Exception e ) {

			return Response.status(Status.BAD_REQUEST).build();

		}

	}

}