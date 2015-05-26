import java.util.Scanner;

public class ES{
	public static Scanner leer = new Scanner(System.in);
	
	public static String pideCadena (String mensaje){
		System.out.println(mensaje);
		return leer.nextLine();
	}
	
	public static int pideNumero(String mensaje){
		System.out.println(mensaje);
		return Integer.parseInt(leer.nextLine());
	}
}
