import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	
	static String entradaUsuario;
	static Scanner scanner = new Scanner(System.in);
	static String pasta = System.getProperty("user.dir") + "/" + "palavras.txt";
	static char[] palavra;
	static boolean verificar = false;
	
	private static void tratarEntrada() {
		
		if(entradaUsuario.matches("[a-zA-Z]+") && entradaUsuario.length() <= 16) {
	    	entradaUsuario = entradaUsuario.toUpperCase().trim();
	    	palavra = entradaUsuario.toCharArray();
	    	verificar = true;
		} else if(entradaUsuario.length() > 16){
	    	System.out.println("Palavra excedeu o limite de 16 caracteres!");
	    } else {
	    	System.out.println("Palavra com caracteres inapropriados!");
	    }		
	}
	
	private static void verificarAnagramas( ) {
		Arrays.sort(palavra);
		int quantidadeAnagramas = 0;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(pasta));

		     while(br.ready()){
		        String linha = br.readLine();
		        char[] linhaAnagrama = linha.toCharArray();
		        Arrays.sort(linhaAnagrama);
		        if (Arrays.equals(palavra, linhaAnagrama)) {
			        System.out.println(linha);
			        quantidadeAnagramas++;
			    } 		        
		     }
		     br.close();
		     if(quantidadeAnagramas == 0) {
		    	 System.out.println("Não foi encontrado nenhum anagrama!");
		     }
		  }catch(IOException ioe){
		     ioe.printStackTrace();
		  }
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Digite a palavra a ser verificada se existe anagramas no programa: ");
		entradaUsuario = scanner.nextLine();	   
	    
		tratarEntrada();
		if(verificar) verificarAnagramas();
	}

}
