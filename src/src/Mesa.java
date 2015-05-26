import java.util.Deque;
import java.util.ArrayDeque;

public class Mesa {
	protected Deque<Ficha> mesa;
	protected int numFichas;
	
	public Mesa(){
		mesa = new ArrayDeque<Ficha>();
	}

	public String toString(){
		String ret=" ";
		for(Ficha i: mesa)
			ret += i.toString();
		return ret;
	}

	public  Ficha swap(Ficha f){
		if (f == null) throw new NullPointerException();
		return new Ficha(f.getDer(), f.getIzq());
	}

	public  boolean colocarFicha(Ficha f, char posicion){
		if (numFichas==0){
			mesa.addLast(f);
			numFichas++;
			return true;
		}else{
			if(posicion == 'd'){
				if(mesa.getLast().getDer() == f.getIzq()){
					mesa.addLast(f);
					numFichas++;
					return true;
				}else{
					if(mesa.getLast().getDer() == f.getDer()){
						mesa.addLast(swap(f));
						numFichas++;
						return true;
					}
					else{
						return false;
					}
				}
			}else{
				if(posicion == 'i'){
					if(mesa.getFirst().getIzq() == f.getDer()){
						mesa.addFirst(f);
						numFichas++;
						return true;
					}else{
						if(mesa.getFirst().getIzq() == f.getIzq()){
							mesa.addFirst(swap(f));
							numFichas++;
							return true;
						}else {
							return false;
						}
					}
				}
			}
			return false;
		}	
	}
	
	int getNumFichas(){
		return numFichas;
	}
}
