package datsch.andre.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;

import datsch.andre.service.api.MarsService;
import datsch.andre.service.bean.Direcao;
import datsch.andre.service.bean.Robot;

/**
 * Implementação do serviço de controle do Robo
 * @author Andre
 */
@Stateless
public class MarsServiceImpl implements MarsService {

	/**
	 * Tamanho do campo a ser explorado
	 */
	public static Integer tamanho = 5;

	
	@Override
	public String processaComando( String command ) throws Exception {

		validaEntrada(command);

		Robot robot = new Robot();
		robot.init();

		for ( int i = 0; i < command.length(); i++ ) {

			char comando = command.charAt(i);
			
			if ( comando == 'M' ) {
				
				move(robot);
				
			} else {
				
				turn(robot, comando);
				
			}

		}

		return robot.getPosicaoAtual();
	}

	/**
	 * Identifica e gira o robo para o lado correto
	 * @param robot Robo
	 * @param direcao Direção para que o robo deve girar
	 */
	private void turn( Robot robot, char direcao ) {

		if ( direcao == 'L' ) {
			
			turnLeft(robot);
			
		} else {
			
			turnRight(robot);
			
		}

	}

	/**
	 * Gira o robo para a esquerda
	 * @param robot Robo
	 */
	private void turnLeft( Robot robot ) {

		robot.setDirecao(Direcao.valueOf(robot.getDirecao().getLeft()));

	}

	/**
	 * Gira o robo pra direita
	 * @param robot robo
	 */
	private void turnRight( Robot robot ) {

		robot.setDirecao(Direcao.valueOf(robot.getDirecao().getRight()));

	}

	/**
	 * Move o robo para a direção que ele está apontado
	 * 
	 * @param robot Robo
	 * @throws Exception
	 */
	private void move( Robot robot ) throws Exception {

		switch ( robot.getDirecao() ) {

			case NORTH:
				move(robot, 0, 1);

				break;

			case SOUTH:
				move(robot, 0, -1);

				break;

			case EAST:
				move(robot, 1, 0);

				break;

			case WEST:
				move(robot, -1, 0);

				break;

			default:
				break;
		}

		validaPosicao(robot);
	}

	/**
	 * Move o robo a distancia especificada
	 * 
	 * @param robot Robo
	 * @param x Distancia no eixo X
	 * @param y Distancia no eixo Y
	 */
	private void move( Robot robot, int x, int y ) {

		robot.setPosicaoX(robot.getPosicaoX() + x);
		robot.setPosicaoY(robot.getPosicaoY() + y);

	}

	/**
	 * Valida se o robo esta numa posição valida
	 * 
	 * @param robot robo
	 * @throws Exception
	 */
	private void validaPosicao( Robot robot ) throws Exception { 

		if ( (robot.getPosicaoX() >= tamanho || robot.getPosicaoX() < 0)
				|| (robot.getPosicaoY() >= tamanho || robot.getPosicaoY() < 0) ) {
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
