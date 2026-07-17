package Scuola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Docente extends Persona {
    private String materiaInsegnata;
    private static final String[] MATERIE_VALIDE = {
        "Italiano", "Matematica", "Scienze", "Storia", "Inglese" 
    };
    private Scanner inputTesti = new Scanner(System.in);
    private Scanner inputNumeri = new Scanner(System.in);

    public Docente(String nome, String cognome, int annoNascita, String materiaInsegnata) {
        super(nome, cognome);
        setAnnoNascita(annoNascita);
        setMateriaInsegnata(materiaInsegnata);
    }

    public void setAnnoNascita(int annoNascita) {
    	if(annoNascita < 1965 || annoNascita > 1995)
    	{
    		System.out.println("Impossibile inserire l'età");
    		
    	}
    	else {
    		this.annoNascita = annoNascita;
    		
    	}
    }

    public String getMateriaInsegnata() {
        return materiaInsegnata;
    }

    public void setMateriaInsegnata(String materiaInsegnata) {
        boolean ancora = true;
        do {
            try {
                boolean valida = false;
                for (String m : MATERIE_VALIDE) {
                    if (m.equalsIgnoreCase(materiaInsegnata.trim())) {
                        this.materiaInsegnata = m;
                        valida = true;
                        ancora = false;
                        break;
                    }
                }
                if (!valida) {
                    System.out.println("Materia non valida (Inserire Italiano, Matematica, Scienze, Storia o Inglese). Reinserisci:");
                    materiaInsegnata = inputTesti.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Input errato! Reinserisci:");
                inputTesti.next();
            }
        } while (ancora);
    }

    public String toString() {
        return "Docente: " + getNome() + " " + getCognome() + ", Anno Nascita: " + getAnnoNascita() + ", Materia: " + getMateriaInsegnata();
    }
}