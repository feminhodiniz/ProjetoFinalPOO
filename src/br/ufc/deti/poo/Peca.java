package br.ufc.deti.poo;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JLabel;

public class Peca extends JLabel{

	
	private int x;
	private int y;
	private Color cor;
	private ImageIcon imagem;
	private static final long serialVersionUID = 1L;

	public Peca(Color cor,int y, int x, boolean tipo)
	{
		setPreferredSize(new Dimension(30, 30));
		setCor(cor);
		setY(y);
		setX(x);
		setLayout(null);
		if(tipo)
		{
			if(cor == Color.blue)
				imagem = new ImageIcon(getClass().getResource("img/CoracaoAzul.png"));
			else if (cor == Color.yellow)
				imagem = new ImageIcon(getClass().getResource("img/CoracaoAmarelo.png"));
			else if (cor == Color.red)
				imagem = new ImageIcon(getClass().getResource("img/CoracaoVermelho.png"));
			else if (cor == Color.green)
				imagem = new ImageIcon(getClass().getResource("img/CoracaoVerde.png"));
			else if (cor == Color.black)
				imagem = new ImageIcon(getClass().getResource("img/CoracaoPreto.png"));
			else if (cor.getRGB() == new Color(108, 21, 91).getRGB())
				imagem = new ImageIcon(getClass().getResource("img/CoracaoRoxo.png"));
			else
				imagem = new ImageIcon(getClass().getResource("img/CoracaoPreto.png"));
		}
		else
		{
			if(x == 475)
			{
				if(cor == Color.blue)
					imagem = new ImageIcon(getClass().getResource("img/BarataAzul.png"));
				else if (cor == Color.yellow)
					imagem = new ImageIcon(getClass().getResource("img/BarataAmarela.png"));
				else if (cor == Color.red)
					imagem = new ImageIcon(getClass().getResource("img/BarataVermelha.png"));
				else if (cor == Color.green)
					imagem = new ImageIcon(getClass().getResource("img/BarataVerde.png"));
				else if (cor == Color.black)
					imagem = new ImageIcon(getClass().getResource("img/BarataPreta.png"));
				else if (cor.getRGB() == new Color(108, 21, 91).getRGB())
					imagem = new ImageIcon(getClass().getResource("img/BarataRoxa.png"));
				else
					imagem = new ImageIcon(getClass().getResource("img/BarataPreta.png"));
			}
			else
			{
				if(cor == Color.blue)
					imagem = new ImageIcon(getClass().getResource("img/ChineloAzul.png"));
				else if (cor == Color.yellow)
					imagem = new ImageIcon(getClass().getResource("img/ChineloAmarelo.png"));
				else if (cor == Color.red)
					imagem = new ImageIcon(getClass().getResource("img/ChineloVermelho.png"));
				else if (cor == Color.green)
					imagem = new ImageIcon(getClass().getResource("img/ChineloVerde.png"));
				else if (cor == Color.black)
					imagem = new ImageIcon(getClass().getResource("img/ChineloPreto.png"));
				else if (cor.getRGB() == new Color(108, 21, 91).getRGB())
					imagem = new ImageIcon(getClass().getResource("img/ChineloRoxo.png"));
				else
					imagem = new ImageIcon(getClass().getResource("img/ChineloPreto.png"));
			}
		}
		setIcon(imagem);
	}
		

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		setLocation(x, y);
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
		setLocation(x, y);
	}
	public Color getCor() {
		return cor;
	}
	public void setCor(Color cor) {
		this.cor = cor;
		
	}

	public void incrementaX()
	{
		if(x == 475)
			setX(25);
		else
		{
			setX(x += 50);
		}
	}
	
	public void decrementaX()
	{
		if(x == 25)
			setX(475);
		else
		{
			setX(x -= 50);
		}
	}
	
	public void incrementaY()
	{
		if(y == 475)
			setY(25);
		else
		{
			setY(y += 50);
		}
	}	
	
	public void decrementaY()
	{
		if(y == 25)
			setY(475);
		else
		{
			setY(y -= 50);	
		}
	}
	
	
}
