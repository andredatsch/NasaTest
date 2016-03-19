package datsch.andre.service.bean;

/**
 * Enum com a direção do robo
 * 
 * @author Andre
 *
 */
public enum Direcao {

	NORTH( "N" , "WEST" , "EAST"),

	EAST( "E" , "NORTH" , "SOUTH"),

	SOUTH( "S" , "EAST" , "WEST"),

	WEST( "W" , "SOUTH" , "NORTH");

	Direcao( String d, String left, String right ) {

		setDirecao(d);
		setEsquerda(left);
		setDireita(right);

	}

	/**
	 * Direção que o robo está apontado
	 */
	private String direcao;

	/**
	 * Direção a esquerda
	 */
	private String esquerda;

	/**
	 * Direção a direita
	 */
	private String direita;

	public String getDirecao( ) {

		return direcao;
	}

	public void setDirecao( String direcao ) {

		this.direcao = direcao;

	}

	public String getEsquerda( ) {

		return esquerda;
	}

	public void setEsquerda( String esquerda ) {

		this.esquerda = esquerda;
	}

	public String getDireita( ) {

		return direita;
	}

	public void setDireita( String direita ) {

		this.direita = direita;
	}

}
