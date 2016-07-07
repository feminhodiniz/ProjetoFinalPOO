package br.ufc.deti.poo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufc.deti.poo.TeclaInvalidaException;

public class Jogo extends JPanel {
	
	private Peca pecaJogador;
	private PecaRandom pecaRandom;
	private int contador;
	private boolean flag;
	private String melhorJogador;
	private int melhorPontuacao;
	
	
	public String getMelhorJogador() {
		return melhorJogador;
	}
	public void setMelhorJogador(String melhorJogador) {
		this.melhorJogador = melhorJogador;
	}
	public int getMelhorPontuacao() {
		return melhorPontuacao;
	}
	public void setMelhorPontuacao(int melhorPontuacao) {
		this.melhorPontuacao = melhorPontuacao;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	private static final long serialVersionUID = 1L;
	public Jogo(Color cor1, Color cor2, boolean tipo, String nomeDoJogador ) {
		//frame = new JFrame();
		//frame.setBounds(100, 100, 550, 550);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(550, 550));
		setLayout(null);
		setOpaque(true);
		contador = 0;
		flag = true;
		setMelhorPontuacao(99999999);
		setMelhorJogador("");
		
		pecaJogador = new Peca(cor1, 225, 25, tipo);
		pecaJogador.setBounds(pecaJogador.getX(), pecaJogador.getY(), 30, 30);
		add(pecaJogador);
		
		pecaRandom = new PecaRandom(cor2, tipo);
		pecaRandom.setBounds(pecaRandom.getX(), pecaRandom.getY(), 30, 30);
		add(pecaRandom);
			
		setFocusable(true);
		requestFocusInWindow();
		
		try {
			List<String> lines = Files.readAllLines(Paths.get("Ranking.txt"), Charset.forName("UTF-8"));
			for(String line:lines){
				int mark = 0;
				for(int i = 0; i < line.length(); i++)
				{
				    if(line.charAt(i) == ';')
				    {
				    	if(mark == 0)
				    		mark = i;
				    	else
				    	{
				    		if(getMelhorPontuacao() > Integer.parseInt(line.substring(mark+1,i)))
		    				{
					    		setMelhorPontuacao(Integer.parseInt(line.substring(mark+1,i)));	
					    		setMelhorJogador(line.substring(0,mark));
					    		System.out.println(getMelhorJogador() + " prontuacao: " + getMelhorPontuacao());
				    		}
				    		break;
				    	}
				    }
				    	
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel label = new JLabel("Melhor jogador: " + getMelhorJogador() + " prontuacao: " + getMelhorPontuacao());
		//label.setHorizontalAlignment(0);
		label.setBounds(10, 300, 300, 300);
		add(label);

		
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
		        			if(contador < 3)
		        				throw new TeclaInvalidaException("Não se pode mover para trás nas primeiras 3 jogadas");
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
	        			
	        			BufferedWriter out = null;
	        			try  
	        			{
	        			    FileWriter fstream = new FileWriter("Ranking.txt", true); //true tells to append data.
	        			    out = new BufferedWriter(fstream);
	        			    out.write(nomeDoJogador + ";" + contador + ";");
	        			    out.newLine();
	        			}
	        			catch (IOException ex)
	        			{
	        			    System.out.println("Error 1: " + ex.getMessage());
	        			}
	        			finally
	        			{
	        			    if(out != null) {
	        			    	try{
	        			    		out.close();
	        			    		 System.out.println("Deu certo");
	        			    	}catch (IOException ex)
	    	        			{
	    	        			    System.out.println("Error 2: " + ex.getMessage());
	    	        			}
	        			    }
	        			}
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
