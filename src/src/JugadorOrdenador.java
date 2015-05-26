public class JugadorOrdenador extends Jugador{
	JugadorOrdenador(String nom){
		super(nom);
	}

	public char colocar(Mesa m, Monton monton){
		Ficha f;
		boolean opcion2;
		char opcion = 'n';

		if(m.numFichas == 0){
			f = montoncito[0];
			opcion2= m.colocarFicha(f, 'd');
			montoncito[0] = montoncito[numFichas-1];
			numFichas--;
			opcion = 's';
		}else{
			int i=0;
			int j=0;

			do{
				opcion2 = m.colocarFicha(montoncito[i], 'd');
				i++;
			}while(i<numFichas && opcion2 == false);

			if(opcion2==true){
				montoncito[i-1]=montoncito[numFichas-1];
				numFichas--;
				opcion='s';
			}else{
				do{
					opcion2 = m.colocarFicha(montoncito[j], 'i');
					j++;
				}while(j<numFichas && opcion2 == false);
				
				if(opcion2==true){
					montoncito[j-1]=montoncito[numFichas-1];
					numFichas--;
					opcion='s';
				}
					
			}
		}
		return opcion;
	}
}
