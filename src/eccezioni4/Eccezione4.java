package eccezioni4;

public class Eccezione4 {

	public static void main(String[] args) {
		int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
		int denom[] = { 2, 0, 4, 4, 0, 8 };

		for (int i = 0; i < numer.length; i++) {

			try { // try unico
				System.out.println(numer[i] + "/" + denom[i] + "=" + (numer[i] / denom[i]));
			} catch (ArithmeticException e) {
				System.out.println("Non puoi dividere " + numer[i] + " per 0!");
			}
			
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Denominatore mancante, programma terminato!"); // non posso scrivere "Programma terminat" perchè il ciclo continua inutilmente mancando tutti i denominatori successivi; soluzione migliore: Eccezioni3.java
				
				
				
			}

		}

	}

}
