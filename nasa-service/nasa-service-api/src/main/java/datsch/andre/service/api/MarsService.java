package datsch.andre.service.api;

/**
 * 
 * Servi�o de comandos do Robo
 * 
 * @author Andre
 */
public interface MarsService {

	/**
	 * Processa os comandos do robo
	 * 
	 * @param commando Comando a ser processado
	 * @return posi��o final do robo
	 * @throws Exception
	 */
	String processaComando( String commando ) throws Exception;

}
