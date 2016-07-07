package br.ufc.deti.poo;

public class TeclaInvalidaException extends Exception  {

		private static final long serialVersionUID = 1L;

		public TeclaInvalidaException(){}
		
		public TeclaInvalidaException(String mensagem){	
			 super(	mensagem);
		}

}
