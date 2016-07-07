package br.ufc.deti.poo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufc.deti.poo.TeclaInvalidaException;

public class Jogo extends JPanel {
	
	private Peca pecaJogador;
	private PecaRandom pecaRandom;
	private int contador;
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	private static final long serialVersionUID = 1L;
	public Jogo(Color cor1, Color cor2, boolean tipo, String nomeDoJogador ){
		//frame = new JFrame();
		//frame.setBounds(100, 100, 550, 550);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(550, 550));
		setLayout(null);
		setOpaque(true);
		contador = 0;
		flag = true;
		
		pecaJogador = new Peca(cor1, 225, 25, tipo);
		pecaJogador.setBounds(pecaJogador.getX(), pecaJogador.getY(), 30, 30);
		add(pecaJogador);
		
		pecaRandom = new PecaRandom(cor2, tipo);
		pecaRandom.setBounds(pecaRandom.getX(), pecaRandom.getY(), 30, 30);
		add(pecaRandom);
			
		setFocusable(true);
		requestFocusInWindow();
		
		System.out.println("Mova o coração de encontro ao outro usando as setas do teclado");
		
		addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
            	if(flag)
            	{
            		try{
		        		if(e.getExtendedKeyCode()==37)
		        		{
		        			pecaJogador.decrementaX();
		        			pecaRandom.andaRandom();
		        		}
		        		else if(e.getExtendedKeyCode()==38)
		        		{
		        			pecaJogador.decrementaY();
		        			pecaRandom.andaRandom();
		        		}
		        		else if(e.getExtendedKeyCode()==39)
		        		{
		        			pecaJogador.incrementaX();
		        			pecaRandom.andaRandom();
		        		}
		        		else if(e.getExtendedKeyCode()==40){
		        			pecaJogador.incrementaY();
		        			pecaRandom.andaRandom();
		        		}
		        		else
		        			throw new TeclaInvalidaException("Mova apenas usando as setas do teclado");
	            		}catch(TeclaInvalidaException ex){
	            			System.out.println(ex.getMessage());
	            			contador--;
            		}

	        		contador++;
	        		if(pecaJogador.getX() == pecaRandom.getX() & pecaJogador.getY() == pecaRandom.getY())
	        		{
	        			setFlag(false);
	        			System.out.println("Parabens, " + nomeDoJogador + "! Você venceu o jogo em " + contador + " rodadas!");
	        		}
            	}
            }
        });
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	

	
}
