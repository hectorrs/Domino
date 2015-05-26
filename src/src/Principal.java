
public class Principal {
	public static void main(String [] args){
		int numJugadores;
		int contador=0;
		
		do{
			numJugadores = ES.pideNumero("¿Cuantos jugadores van a jugar?2-3-4");
		}while(numJugadores<2 || numJugadores>4);		
		
		Jugador [] jugadores;
		jugadores = new Jugador[numJugadores];
		
		for(int i=0;i<numJugadores;i++){
			int tipo;
			do{
				tipo = ES.pideNumero("¿Qué tipo de jugador es?:1-JugadorHumano,2-JugadorOrdenador");
			}while(tipo != 1 && tipo != 2);
			if(tipo == 1){
				String nombre=ES.pideCadena("Introduzca el nombre: ");
				jugadores[i] = new JugadorHumano(nombre);
			}else{
				String nombre=ES.pideCadena("Introduzca el nombre: ");
				jugadores[i] = new JugadorOrdenador(nombre);
			}
		}
		
		Mesa mesa;
		mesa = new Mesa();
		Monton monton;
		monton = new Monton();
		
		for(int i=0;i<numJugadores;i++){
			for (int j=0;j<7;j++){
				jugadores[i].robar(monton);
			}
		}
		System.out.println("                                                                              COMIENZA LA PARTIDA");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Le toca a: " + jugadores[0].getNombre());
		char opcion;
		do{
			opcion = jugadores[0].colocar(mesa,monton);
		}while(opcion == 'N'|| opcion == 'n');
		System.out.println("                                                                                      MESA");
		System.out.println("****************************************************************************************************************************************************************************************");
		System.out.println(mesa.toString());
		System.out.println("****************************************************************************************************************************************************************************************");
		
		boolean fin = false;
		int turno = 1;
		do{
				turno = turno%numJugadores;
				System.out.println("Le toca a: " + jugadores[turno].getNombre());
				opcion = jugadores[turno].colocar(mesa,monton);
				if(opcion=='n'|| opcion=='N'){
					if(monton.getNumFichas()!=0){
						jugadores[turno].robar(monton);
						System.out.println("                                                                                      MESA");
						System.out.println("****************************************************************************************************************************************************************************************");
						System.out.println(mesa.toString());
						System.out.println("****************************************************************************************************************************************************************************************");
						jugadores[turno].toString();
						opcion = jugadores[turno].colocar(mesa,monton);
						System.out.println("                                                                                      MESA");
						System.out.println("****************************************************************************************************************************************************************************************");
						System.out.println(mesa.toString());
						System.out.println("****************************************************************************************************************************************************************************************");
						if(opcion=='s' || opcion=='S'){
							contador=0;
						}
					}else 
						contador++;
				}else{
					System.out.println("                                                                                      MESA");
					System.out.println("****************************************************************************************************************************************************************************************");
					System.out.println(mesa.toString());
					System.out.println("****************************************************************************************************************************************************************************************");
					contador=0;
					if (jugadores[turno].getNumFichas()==0){
						fin = true;
						    System.out.println(" _____________________________________________________");
							System.out.println("|                                                     |");
							System.out.println("              El ganador es: " + jugadores[turno].getNombre()     );
							System.out.println("|_____________________________________________________|");
					}
				}
				turno++;
				
				if(contador==numJugadores){
					fin=true;
					int jugador=0;
				    int menor=jugadores[0].getNumFichas();
				    for(int i=1; i<numJugadores;i++){
				    	if(jugadores[i].getNumFichas()<menor){
				    		menor=jugadores[i].getNumFichas();
				    		jugador=i;
				    	}
				    }
				    System.out.println(" _____________________________________________________");
					System.out.println("|                                                     |");
					System.out.println("              El ganador es: " + jugadores[jugador].getNombre()     );
					System.out.println("|_____________________________________________________|");
	
				}
		}while(fin==false);
	}
}
