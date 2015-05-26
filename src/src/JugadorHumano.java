public class JugadorHumano extends Jugador{
	JugadorHumano(String nom){
		super(nom);
	}

	public char colocar(Mesa m,Monton monton){
		Ficha f = null;
		char opcion = 0;
		boolean colocada;
		char posicion = 0;

		if(numFichas == 0)
			System.out.println("No hay fichas");
		else{
			int fichaColocar = 0;

			do{
				System.out.println(toString());
				String op = ES.pideCadena("¿Quieres colocar una ficha?s/n");
				opcion = op.charAt(0);
				
			}while(opcion!='s' && opcion!='n' && opcion!='S' && opcion!='N');

			if (opcion=='s' || opcion=='S'){
				do{
					do{	
						fichaColocar = ES.pideNumero("¿Que ficha quieres colocar?");
					}while ((fichaColocar<0) || (fichaColocar>getNumFichas()));

					f = montoncito[fichaColocar];
					
					do{
						String pos = ES.pideCadena("¿En que posicion quieres colocarla?Derecha=d,Izquierda=i");
						posicion = pos.charAt(0);
					}while(posicion!='d' && posicion!='i' && posicion!='D' && posicion!='I');

					colocada = m.colocarFicha(f,posicion);
					
					if (colocada==true){
						montoncito[fichaColocar]=montoncito[numFichas-1];
						System.out.println("Ficha colocada correctamente");
						numFichas--;
					}
					else{
						System.out.println("Esa ficha no es válida");
						System.out.println(toString());
					}
				}while(colocada==false);
			}
		}
		return opcion;
	}
}
