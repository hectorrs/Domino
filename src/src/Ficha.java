public class Ficha {
	private int izquierda;
	private int derecha;

	public Ficha(int izq, int der){
		izquierda = izq;
		derecha = der;
	}

	public int getDer(){
		return derecha;
	}

	public int getIzq(){
		return izquierda;
	}

	public String toString(){
		return "[ " + izquierda + " : " + derecha + " ] ";
	}

	public boolean equals(Ficha f){
		if (izquierda == f.izquierda && derecha == f.derecha) return true;
		else return false;
	}
}
