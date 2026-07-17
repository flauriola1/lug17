package Scuola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Studente extends Persona implements Certificato {
    private int classe;
    private char sezioneFrequentata;
    private String matricola;
    private int annoCertificato;
    private String cognomeMedico;
    private static int progressivoMatricola = 1;
    private Scanner inputTesti = new Scanner(System.in);
    private Scanner inputNumeri = new Scanner(System.in);

    public Studente(String nome, String cognome, int annoNascita, int classe, char sezioneFrequentata) {
        super(nome, cognome);
        setAnnoNascita(annoNascita);
        setClasse(classe);
        setSezioneFrequentata(sezioneFrequentata);
        generaMatricola();
    }

    public void setAnnoNascita(int annoNascita) {
    	if(annoNascita < 2016 || annoNascita > 2023)
    	{
    		System.out.println("Impossibile inserire l'età");
    		
    	}
    	else {
    		this.annoNascita = annoNascita;
    		
    	}
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        boolean ancora = true;
        do {
            try {
                if (classe < 1 || classe > 5) {
                    System.out.println("La classe deve essere compresa fra 1 e 5. Reinserisci:");
                    classe = inputNumeri.nextInt();
                } else {
                    this.classe = classe;
                    ancora = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input errato! Reinserisci:");
                inputNumeri.next();
            }
        } while (ancora);
    }

    public char getSezioneFrequentata() {
        return sezioneFrequentata;
    }

    public void setSezioneFrequentata(char sezioneFrequentata) {
        boolean ancora = true;
        char sezione = Character.toUpperCase(sezioneFrequentata);
        do {
            try {
                if (sezione != 'A' && sezione != 'B' && sezione != 'C' && sezione != 'D') {
                    System.out.println("La sezione deve essere A, B, C o D. Reinserisci:");
                    String temp = inputTesti.next();
                    sezione = Character.toUpperCase(temp.charAt(0));
                } else {
                    this.sezioneFrequentata = sezione;
                    ancora = false;
                }
            } catch (Exception e) {
                System.out.println("Input errato! Reinserisci:");
                inputTesti.next();
            }
        } while (ancora);
    }

    public String getMatricola() {
        return matricola;
    }

    private void generaMatricola() {
        int ultimeDueCifre = getAnnoNascita() % 100;
        this.matricola = String.format("%02d%03d%c", ultimeDueCifre, progressivoMatricola, getSezioneFrequentata());
        progressivoMatricola = (progressivoMatricola + 1) % 1000;
    }

    public void inserisciCertificato(int anno, String medico) {
        boolean ancora = true;
        do {
            try {
                if (anno < 2020 || anno > 2026) {
                    System.out.println("Anno certificato non valido. Reinserisci anno:");
                    anno = inputNumeri.nextInt();
                } else if (medico == null || medico.trim().isEmpty()) {
                    System.out.println("Il cognome del medico non puo' essere vuoto. Reinserisci:");
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
    	
        String certInfo = (getAnnoCertificato() != 0) ? ", Certificato Medico del: " + getAnnoCertificato() + " (Dottore. " + getCognomeMedico() + ")" : ", Certificato Medico: assente";
        return "Studente: " + getNome() + " " + getCognome() + ", Anno Nascita: " + getAnnoNascita() + ", Classe: " + getClasse() + getSezioneFrequentata() + ", Matricola: " + getMatricola() + certInfo;
    }
}