import java.lang.Math;

public class Monton {
	private Ficha[] monton;
	private int numFichas;
	
	public Monton(){
		numFichas = 28;
		monton = new Ficha[numFichas];
		
		int numeroFichas=0;
		for (int i=0; i<=6; i++)
			for (int j=i; j<=6; j++)
				monton[numeroFichas++] = new Ficha(i,j);
	}
	
	public int getNumFichas(){
		return numFichas;
	}	
	
	public int buscarFicha(Ficha f){
		int pos = 0;
		for(int i=0;i<getNumFichas();i++){
			if (monton[i].equals(f))
				pos = i;
		}
		return pos;	
	}
	
	public Ficha robarMonton(){
		int pos = (int) (Math.random()*numFichas);
		Ficha ficha1 = monton[pos];
		
		for(int i=pos;i<getNumFichas()-1;i++)
			monton[i]=monton[i+1];
		numFichas--;

		return ficha1;
	}
}
