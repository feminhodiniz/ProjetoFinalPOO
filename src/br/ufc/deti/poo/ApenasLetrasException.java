package br.ufc.deti.poo;

public class ApenasLetrasException  extends Exception  {

		private static final long serialVersionUID = 1L;

		public ApenasLetrasException(){}
		
		public ApenasLetrasException(String mensagem){	
			 super(	mensagem);
		}

}
