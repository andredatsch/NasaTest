package datsch.andre.endpoint.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Endpoint para os comandos do robo 
 * 
 * @author Andre
 */
@Path( "mars" )
public interface MarsEndpoint {

	/**
	 * 
	 * Processa os comandos do Robo
	 * 
	 * @param command comando a ser processado
	 * @return a posição final do robo
	 */
	@POST
	@Path( "{commando}" )
	Response commando( @PathParam( "commando" ) String command);

}
