import java.util.Scanner;

public class entradasalida{
	public static Scanner leer = new Scanner (System.in);

	public static String pideCadena (String mensaje){
		System.out.print(mensaje);
		
		return leer.nextLine();
	}

	public static int pideNumero(String mensaje){
		System.out.print(mensaje);
	
		return Integer.parseInt(leer.nextLine());
	}
}
