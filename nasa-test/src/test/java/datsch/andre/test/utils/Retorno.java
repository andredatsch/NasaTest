package datsch.andre.test.utils;

/**
 * Retorno do restclient
 * @author Andre
 *
 */
public class Retorno {
	
	/**
	 * Status da chamada
	 */
	private int status;
	
	/**
	 * Retorno da chamada
	 */
	private String retorno;
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getRetorno() {
		return retorno;
	}
	
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
}
