package datsch.andre.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;

import datsch.andre.service.api.MarsService;
import datsch.andre.service.bean.Direcao;
import datsch.andre.service.bean.Robo;

/**
 * Implementação do serviço de controle do Robo
 * 
 * @author Andre
 */
@Stateless
public class MarsServiceImpl implements MarsService {

	/**
	 * Tamanho do campo a ser explorado
	 */
	public static Integer tamanho = 5;

	
	@Override
	public String processaComando( String commando ) throws Exception {

		validaEntrada(commando);

		Robo robo = new Robo();

		for ( int i = 0; i < commando.length(); i++ ) {

			char comando = commando.charAt(i);
			
			if ( comando == 'M' ) {
				
				move(robo);
				
			} else {
				
				virar(robo, comando);
				
			}

		}

		return robo.getPosicaoAtual();
	}

	/**
	 * Identifica e gira o robo para o lado correto
	 * 
	 * @param robo Robo
	 * 
	 * @param direcao Direção para que o robo deve girar
	 */
	private void virar( Robo robo, char direcao ) {

		if ( direcao == 'L' ) {
			
			virarEsquerda(robo);
			
		} else {
			
			virarDireita(robo);
			
		}

	}

	/**
	 * Gira o robo para a esquerda
	 * 
	 * @param robo Robo
	 */
	private void virarEsquerda( Robo robo ) {

		robo.setDirecao(Direcao.valueOf(robo.getDirecao().getEsquerda()));

	}

	/**
	 * Gira o robo pra direita
	 * 
	 * @param robo robo
	 */
	private void virarDireita( Robo robo ) {

		robo.setDirecao(Direcao.valueOf(robo.getDirecao().getDireita()));

	}

	/**
	 * Move o robo para a direção que ele está apontado
	 * 
	 * @param robo Robo
	 * 
	 * @throws Exception
	 */
	private void move( Robo robo ) throws Exception {

		switch ( robo.getDirecao() ) {

			case NORTH:
				move(robo, 0, 1);

				break;

			case SOUTH:
				move(robo, 0, -1);

				break;

			case EAST:
				move(robo, 1, 0);

				break;

			case WEST:
				move(robo, -1, 0);

				break;

			default:
				break;
		}

		validaPosicao(robo);
	}

	/**
	 * Move o robo a distancia especificada
	 * 
	 * @param robo Robo
	 * @param x Distancia no eixo X
	 * @param y Distancia no eixo Y
	 */
	private void move( Robo robo, int x, int y ) {

		robo.setPosicaoX(robo.getPosicaoX() + x);
		robo.setPosicaoY(robo.getPosicaoY() + y);

	}

	/**
	 * Valida se o robo esta numa posição valida
	 * 
	 * @param robo robo
	 * @throws Exception
	 */
	private void validaPosicao( Robo robo ) throws Exception { 

		if ( (robo.getPosicaoX() >= tamanho || robo.getPosicaoX() < 0)
				|| (robo.getPosicaoY() >= tamanho || robo.getPosicaoY() < 0) ) {
			throw new Exception("Posição Inválida");
		}

	}

	/**
	 * Identifica se os comandos passados para o robo são válidos
	 * 
	 * @param command Comandos
	 * @throws Exception
	 */
	private void validaEntrada( String command ) throws Exception {

		Pattern p = Pattern.compile("(?:[^MRL])+");
		Matcher m = p.matcher(command);

		if ( m.find() ) {

			throw new Exception("Comando Inválido");

		}

	}

}
