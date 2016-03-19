package datsch.andre.service.bean;

/**
 * Enum com a direção do robo
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
		setLeft(left);
		setRight(right);

	}

	/**
	 * Direção que o robo está apontado
	 */
	private String direcao;

	/**
	 * Direção a esquerda
	 */
	private String left;

	/**
	 * Direção a direita
	 */
	private String right;

	public String getDirecao( ) {

		return direcao;
	}

	public void setDirecao( String direcao ) {

		this.direcao = direcao;

	}

	public String getLeft( ) {

		return left;
	}

	public void setLeft( String left ) {

		this.left = left;
	}

	public String getRight( ) {

		return right;
	}

	public void setRight( String right ) {

		this.right = right;
	}

}
