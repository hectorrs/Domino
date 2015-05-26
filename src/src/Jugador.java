public abstract class Jugador {
	protected Ficha [] montoncito;
	protected int numFichas;
	private String nombre;
	
	public Jugador(String nom){
		nombre = nom;
		numFichas = 0;
		montoncito = new Ficha [28];
	}

	public String getNombre(){
		return nombre;
	}

	public int getNumFichas(){
		return numFichas;
	}

	public String toString(){
		String ret=" ";
		for(int i=0;i<getNumFichas();i++)
			ret+=montoncito[i].toString();
		
		return ret;
	}

	public void robar(Monton m){
		if (m.getNumFichas() == 0){
			System.out.println("No hay fichas en el monton");}
		else{
			montoncito[getNumFichas()] = m.robarMonton();
			numFichas++;
		}
	}
	
	public abstract char colocar(Mesa m, Monton monton);
}
