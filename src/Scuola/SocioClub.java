package Scuola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SocioClub implements Certificato {
    private String nome;
    private String cognome;
    private int annoCertificato;
    private String cognomeMedico;
    private Scanner inputTesti = new Scanner(System.in);
    private Scanner inputNumeri = new Scanner(System.in);

    public SocioClub(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void inserisciCertificato(int anno, String medico) {
        boolean ancora = true;
        do {
            try {
                if (anno < 2024 || anno > 2026) {
                    System.out.println("Anno certificato non valido. Reinserisci anno:");
                    anno = inputNumeri.nextInt();
                } else if (medico == null || medico.trim().isEmpty()) {
                    System.out.println("Il cognome del medico non puo' essere vuoto o minore di 2 caratteri. Reinserisci:");
                    medico = inputTesti.next();
                } else {
                    this.annoCertificato = anno;
                    this.cognomeMedico = medico;
                    ancora = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input errato! Reinserisci anno:");
                inputNumeri.next();
            }
        } while (ancora);
    }

    public int getAnnoCertificato() {
        return annoCertificato;
    }

    public String getCognomeMedico() {
        return cognomeMedico;
    }

    public String toString() {
        return "Iscritto Club: " + getNome() + " " + getCognome() + ", Certificato Medico del: " + getAnnoCertificato() + " (Dr. " + getCognomeMedico() + ")";
    }
}
