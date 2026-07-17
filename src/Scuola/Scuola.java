package Scuola;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scuola {
    public static void main(String[] args) {
        ArrayList<Studente> studenti = new ArrayList<>();
        ArrayList<Docente> docenti = new ArrayList<>();
        ArrayList<SocioClub> iscrittiClub = new ArrayList<>();
        Scanner inputTesti = new Scanner(System.in);
        Scanner inputNumeri = new Scanner(System.in);
        int scelta = 0;

        do {
        	System.out.println("------------------------------------------------");
            System.out.println("\n--- MENU SCUOLA PRIMARIA CON PALESTRA CLUB ---");
            System.out.println("1. Inserisci Studente");
            System.out.println("2. Inserisci Docente");
            System.out.println("3. Inserisci un socio club pallavolo");
            System.out.println("4. Stampa gli studenti registrati");
            System.out.println("5. Stampa tutti i docenti");
            System.out.println("6. Stampa i soci club pallavolo");
            System.out.println("7. Esci");
            System.out.print("Scegli un'opzione: ");

            try {
                scelta = inputNumeri.nextInt();
                switch (scelta) {
                    case 1:
                        System.out.print("Nome studente: ");
                        String nomeS = inputTesti.nextLine();
                        System.out.print("Cognome studente: ");
                        String cognomeS = inputTesti.nextLine();
                        
                        int annoS = 0;
                        boolean ancoraAnnoS = true;
                        while (ancoraAnnoS) {
                            try {
                            	System.out.println("N.B : Le date di nascita non sono modificabili!, Studenti fra 2016 e 2023");
                                System.out.println("Anno di nascita: ");

                                annoS = inputNumeri.nextInt();
                                ancoraAnnoS = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Formato non valido! Reinserisci numero:");
                                inputNumeri.next();
                            }
                        }

                        int classeS = 0;
                        boolean ancoraClasseS = true;
                        while (ancoraClasseS) {
                            try {
                                System.out.print("Classe (1-5): ");
                                classeS = inputNumeri.nextInt();
                                ancoraClasseS = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Formato non valido! Reinserisci numero:");
                                inputNumeri.next();
                            }
                        }

                        System.out.print("Sezione (A-D): ");
                        char sezioneS = inputTesti.nextLine().charAt(0);

                        Studente nuovoStudente = new Studente(nomeS, cognomeS, annoS, classeS, sezioneS);
                        
                        if (nuovoStudente.getAnnoNascita() == 0) {
                            System.out.println("Inserimento annullato. Lo studente NON è stato aggiunto.");
                        } else {
                            System.out.print("Vuoi inserire il certificato medico? (S/N): ");
                            String rispS = inputTesti.nextLine();
                            if (rispS.equalsIgnoreCase("S")) {
                                int annoC = 0;
                                boolean ancoraAnnoC = true;
                                while (ancoraAnnoC) {
                                    try {
                                        System.out.print("Anno rilascio certificato: ");
                                        annoC = inputNumeri.nextInt();
                                        ancoraAnnoC = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Formato non valido! Reinserisci numero:");
                                        inputNumeri.next();
                                    }
                                }
                                System.out.print("Cognome medico: ");
                                String medicoC = inputTesti.nextLine();
                                nuovoStudente.inserisciCertificato(annoC, medicoC);
                            }
                            studenti.add(nuovoStudente);
                            System.out.println("Studente registrato con successo.");
                        }
                        break;

                    case 2:
                        System.out.print("Nome docente: ");
                        String nomeD = inputTesti.nextLine();
                        System.out.print("Cognome docente: ");
                        String cognomeD = inputTesti.nextLine();
                        
                        int annoD = 0;
                        boolean ancoraAnnoD = true;
                        while (ancoraAnnoD) {
                            try {
                            	System.out.println("N.B : Le date di nascita non sono modificabili!, Docenti fra 1965 e 1995");
                                System.out.println("Anno di nascita: ");
                                annoD = inputNumeri.nextInt();
                                ancoraAnnoD = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Formato non valido! Reinserisci numero:");
                                inputNumeri.next();
                            }
                        }
                        System.out.println("Materie disponibili [Italiano,Matematica,Inglese,Storia,Scienze]");
                        System.out.print("Materia insegnata: ");
                        String materiaD = inputTesti.nextLine();

                        Docente nuovoDocente = new Docente(nomeD, cognomeD, annoD, materiaD);
                        
                        if (nuovoDocente.getAnnoNascita() == 0) {
                            System.out.println("Inserimento annullato. Il docente NON è stato aggiunto.");
                        } else {
                            docenti.add(nuovoDocente);
                            System.out.println("Docente registrato con successo.");
                        }
                        break;

                    case 3:
                        System.out.print("Nome socio: ");
                        String nomeClub = inputTesti.nextLine();
                        System.out.print("Cognome socio: ");
                        String cognomeClub = inputTesti.nextLine();

                        SocioClub nuovoSocio = new SocioClub(nomeClub, cognomeClub);

                        int annoCertClub = 0;
                        boolean ancoraAnnoClub = true;
                        while (ancoraAnnoClub) {
                            try {
                                System.out.print("Anno rilascio certificato: ");
                                annoCertClub = inputNumeri.nextInt();
                                ancoraAnnoClub = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Formato non valido! Reinserisci numero:");
                                inputNumeri.next();
                            }
                        }
                        System.out.print("Cognome medico: ");
                        String medicoClub = inputTesti.nextLine();

                        nuovoSocio.inserisciCertificato(annoCertClub, medicoClub);
                        iscrittiClub.add(nuovoSocio);
                        System.out.println("Socio club registrato con successo.");
                        break;

                    case 4:
                        System.out.println("\n--- ELENCO STUDENTI ---");
                        if (studenti.isEmpty()) {
                            System.out.println("Elenco Vuoto");
                        }
                        for (Studente s : studenti) {
                            System.out.println(s);
                        }
                        break;

                    case 5:
                        System.out.println("\n--- ELENCO DOCENTI ---");
                        if (docenti.isEmpty()) {
                            System.out.println("Elenco Vuoto");
                        }
                        for (Docente d : docenti) {
                            System.out.println(d);
                        }
                        break;

                    case 6:
                        System.out.println("\n--- ELENCO SOCI CLUB REGISTRATI ---");
                        if (iscrittiClub.isEmpty()) {
                            System.out.println("Nessun socio in elenco.");
                        }
                        for (SocioClub i : iscrittiClub) {
                            System.out.println(i);
                        }
                        break;

                    case 7:
                        System.out.println("Chiusura del programma");
                        System.exit(0);

                    default:
                        System.out.println("Opzione non valida! Scegliere un numero da 1 a 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Errore durante l'inserimento, reinserisci:");
                inputNumeri.next();
            }
        } while (scelta != 7);
    }
}