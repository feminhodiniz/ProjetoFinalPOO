package br.ufc.deti.poo;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ProjetoFinal {

	private JFrame frame;
	private JTextField nomeDoJogador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjetoFinal window = new ProjetoFinal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjetoFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel primeiraCor = new JPanel();		
		JPanel segundaCor = new JPanel();
		
		Botao btnAzul = new Botao("Azul");
		btnAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(primeiraCor.getBackground().equals(new Color(238, 238, 238)))
				{
					primeiraCor.setBackground(Color.blue);
					btnAzul.setFoiClicado(true);
				}
				else if(segundaCor.getBackground().equals(new Color(238, 238, 238)))
				{
					segundaCor.setBackground(Color.blue);
					btnAzul.setFoiClicado(true);
				}
				else
					System.out.println("Você já escolheu duas cores. clique em jogar.");
			}
		});
		
		Botao btnAmarelo = new Botao("Amarelo");
		btnAmarelo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(primeiraCor.getBackground().equals(new Color(238, 238, 238)))
				{
					primeiraCor.setBackground(Color.yellow);
					btnAmarelo.setFoiClicado(true);
				}
				else if(segundaCor.getBackground().equals(new Color(238, 238, 238)))
				{
					segundaCor.setBackground(Color.yellow);
					btnAmarelo.setFoiClicado(true);
				}
				else
					System.out.println("Você já escolheu duas cores. clique em jogar.");
				
			}
		});
		
		Botao btnVerde = new Botao("Verde");
		btnVerde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(primeiraCor.getBackground().equals(new Color(238, 238, 238)))
				{
					primeiraCor.setBackground(Color.green);
					btnVerde.setFoiClicado(true);
				}
				else if(segundaCor.getBackground().equals(new Color(238, 238, 238)))
				{
					segundaCor.setBackground(Color.green);
					btnVerde.setFoiClicado(true);
				}
				else
					System.out.println("Você já escolheu duas cores. clique em jogar.");
			}
		});
		
		Botao btnVermelho = new Botao("Vermelho");
		btnVermelho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(primeiraCor.getBackground().equals(new Color(238, 238, 238)))
				{
					primeiraCor.setBackground(Color.red);
					btnVermelho.setFoiClicado(true);
				}
				else if(segundaCor.getBackground().equals(new Color(238, 238, 238)))
				{
					segundaCor.setBackground(Color.red);
					btnVermelho.setFoiClicado(true);
				}
				else
					System.out.println("Você já escolheu duas cores. clique em jogar.");
				
			}
		});
		
		Botao btnRoxo = new Botao("Roxo");
		btnRoxo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				if(primeiraCor.getBackground().equals(new Color(238, 238, 238)))
				{
					primeiraCor.setBackground(new Color(108, 21, 91));
					btnRoxo.setFoiClicado(true);
				}
				else if(segundaCor.getBackground().equals(new Color(238, 238, 238)))
				{
					segundaCor.setBackground(new Color(108, 21, 91));
					btnRoxo.setFoiClicado(true);
				}
				else
					System.out.println("Você já escolheu duas cores. clique em jogar.");
			}
		});
		
		Botao btnPreto = new Botao("Preto");
		btnPreto.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				if(primeiraCor.getBackground().equals(new Color(238, 238, 238)))
				{
					primeiraCor.setBackground(Color.black);
					btnPreto.setFoiClicado(true);
				}
				else if(segundaCor.getBackground().equals(new Color(238, 238, 238)))
				{
					segundaCor.setBackground(Color.black);
					btnPreto.setFoiClicado(true);
				}
				else
					System.out.println("Você já escolheu duas cores. clique em jogar.");	
			}
		});
		
		nomeDoJogador = new JTextField();
		nomeDoJogador.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome da jogadora");
		
		JLabel lblEscolhaDuasCores = new JLabel("Escolha duas cores que combinam");
		
		JButton btnJogar = new JButton("Jogar!");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnAzul.isFoiClicado() & btnRoxo.isFoiClicado())
				{
					frame.setVisible(false);	
					JFrame jframe = new JFrame("Jogo <3");
					jframe.setLayout(new FlowLayout());
					jframe.setSize(550, 550);
					jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
					jframe.getContentPane().setBackground(Color.gray);
					jframe.add(new Jogo(primeiraCor.getBackground(), segundaCor.getBackground(),true, nomeDoJogador.getText()));
					jframe.setVisible(true);
				}
				else
				{
					frame.setVisible(false);	
					JFrame jframe = new JFrame("Mate a barata");
					jframe.setLayout(new FlowLayout());
					jframe.setSize(550, 550);
					jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
					jframe.getContentPane().setBackground(Color.gray);
					jframe.add(new Jogo(primeiraCor.getBackground(), segundaCor.getBackground(),false, nomeDoJogador.getText()));
					jframe.setVisible(true);	
				}

			}
		});
		
		GroupLayout Layout = new GroupLayout(frame.getContentPane());
		Layout.setHorizontalGroup(
			Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Layout.createSequentialGroup()
					.addGap(110)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(nomeDoJogador, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(170))
				.addGroup(Layout.createSequentialGroup()
					.addGroup(Layout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAzul, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAmarelo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
					.addGroup(Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(Layout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnVerde, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRoxo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(Layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVermelho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPreto, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addComponent(primeiraCor, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(segundaCor, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
				.addGroup(Layout.createSequentialGroup()
					.addGap(233)
					.addComponent(btnJogar, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(231))
				.addGroup(Layout.createSequentialGroup()
					.addGap(49)
					.addComponent(lblEscolhaDuasCores)
					.addContainerGap(347, Short.MAX_VALUE))
		);
		Layout.setVerticalGroup(
			Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Layout.createSequentialGroup()
					.addGap(47)
					.addGroup(Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nomeDoJogador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(35)
					.addComponent(lblEscolhaDuasCores)
					.addGap(18)
					.addGroup(Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(Layout.createSequentialGroup()
							.addComponent(segundaCor, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Layout.createSequentialGroup()
							.addGroup(Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(Layout.createSequentialGroup()
									.addGroup(Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAmarelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnVerde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRoxo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(24)
									.addGroup(Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAzul, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnVermelho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnPreto, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
									.addGap(23))
								.addGroup(Layout.createSequentialGroup()
									.addComponent(primeiraCor, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(btnJogar)
							.addGap(17))))
		);
		frame.getContentPane().setLayout(Layout);
	}
}
