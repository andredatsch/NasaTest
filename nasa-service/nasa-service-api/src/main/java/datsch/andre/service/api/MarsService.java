package datsch.andre.service.api;

/**
 * 
 * Serviço de comandos do Robo
 * 
 * @author Andre
 */
public interface MarsService {

	/**
	 * Processa os comandos do robo
	 * 
	 * @param commando Comando a ser processado
	 * @return posição final do robo
	 * @throws Exception
	 */
	String processaComando( String commando ) throws Exception;

}
