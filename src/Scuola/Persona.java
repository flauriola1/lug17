package Scuola;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Persona {
    protected String nome;
    protected String cognome;
    protected int annoNascita;
    Scanner inputTesti = new Scanner(System.in);

    public Persona(String nome, String cognome) {
        setNome(nome);
        setCognome(cognome);
    }
    
    public void setNome(String nome) {
        boolean ancora = true;
        do {
            try {
                if (nome.length() <= 2) {
                    System.out.println("Il nome deve essere di almeno 3 caratteri. Reinserisci:");
                    nome = inputTesti.nextLine();
                } else {
                    this.nome = nome;
                    ancora = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input errato! Reinserisci:");
                inputTesti.next();
            }
        } while (ancora);
    }
    
    public void setCognome(String cognome) {
        boolean ancora = true;
        do {
            try {
                if (cognome.length() <= 2) {
                    System.out.println("Il cognome deve essere di almeno 3 caratteri. Reinserisci:");
                    cognome = inputTesti.nextLine();
                } else {
                    this.cognome = cognome;
                    ancora = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input errato! Reinserisci:");
                inputTesti.next();
            }
        } while (ancora);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getAnnoNascita() {
        return annoNascita;
    }

    public abstract void setAnnoNascita(int annoNascita);
}