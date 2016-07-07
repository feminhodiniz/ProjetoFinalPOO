package br.ufc.deti.poo;
import javax.swing.JButton;

public class Botao extends JButton {

	//eu fiz isso com a intenção de fazer algo legal mas acabei
	//nem fazendo. desconsidere esse classe idiota.
	public Botao(String nome){
		this.setText(nome);
		this.setFoiClicado(false);
	}
	
	private static final long serialVersionUID = 1L;
	
	private boolean foiClicado;

	public boolean isFoiClicado() {
		return foiClicado;
	}

	public void setFoiClicado(boolean foiClicado) {
		this.foiClicado = foiClicado;
	}
	

}
