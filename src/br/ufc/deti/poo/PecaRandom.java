package br.ufc.deti.poo;

import java.awt.Color;
import java.util.Random;

public class PecaRandom extends Peca{

	public PecaRandom(Color cor, boolean tipo) {
		super(cor, 225, 475, tipo);
	}
	
	public void andaRandom()
	{
		Random lado = new Random();
		int i = lado.nextInt(5);
		if(i==0)
			incrementaX();
		else if(i==1)
			incrementaY();
		else if(i==2)
			decrementaX();
		else if(i==3)
			decrementaY();
		else
			System.out.println("Não houveram movimentos.");
		System.out.println("Sua vez");
	}

}
