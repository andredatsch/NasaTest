package datsch.andre.service.bean;

/**
 * Classe representando um robo
 * 
 * @author Andre
 *
 */
public class Robo {

	/**
	 * Ao criar um novo robo, configurar ele na posi��o inicial
	 */
	public Robo(){
		
		init();
		
	}
	
	/**
	 * Inicializa o robo na posi��o 0, 0, N
	 */
	public void init( ) {

		setPosicaoX(0);
		setPosicaoY(0);
		setDirecao(Direcao.NORTH);

	}

	/**
	 * Poisi��o no eixo X
	 */
	private Integer posicaoX;

	/**
	 * Posi��o no eixo Y
	 */
	private Integer posicaoY;

	/**
	 * Dire��o na qual o robo esta apontado
	 */
	private Direcao direcao;

	public Integer getPosicaoX( ) {

		return posicaoX;
	}

	public void setPosicaoX( Integer posicaoX ) {

		this.posicaoX = posicaoX;
	}

	public Integer getPosicaoY( ) {

		return posicaoY;
	}

	public void setPosicaoY( Integer posicaoY ) {

		this.posicaoY = posicaoY;
	}

	public Direcao getDirecao( ) {

		return direcao;
	}

	public void setDirecao( Direcao direcao ) {

		this.direcao = direcao;
	}

	public String getPosicaoAtual( ) {

		StringBuilder sb = new StringBuilder();

		sb.append(posicaoX).append(", ").append(posicaoY).append(", ").append(direcao.getDirecao());

		return sb.toString();

	}

}
