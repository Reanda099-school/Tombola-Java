import java.time.LocalDate;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // Creazione della Tombola
        Tombola tombola = new Tombola(LocalDate.now(), "Tombola Natalizia", "Palestra");
                
        // Creazione dei giocatori
        Giocatore g1 = new Giocatore("Mario", "Rossi", false, false, 2, tombola);
        Giocatore g2 = new Giocatore("Lucia", "Bianchi", false, false, 3, tombola);
        Giocatore g3 = new Giocatore("Franco", "Verdi", false, false, 2, tombola);
        
        // Aggiunta giocatori alla tombola
        tombola.setGiocatore(g1, "add");
        tombola.setGiocatore(g2, "add");
        tombola.setGiocatore(g3, "add");
        
        // Visualizzazione informazioni
        System.out.println("=== TOMBOLA ===");
        System.out.println("Evento: " + tombola.getNomeEvento());
        System.out.println("Data: " + tombola.getData());
        System.out.println("Luogo: " + tombola.getLuogo());
        System.out.println("Numero schede in gioco: " + tombola.getSchede());
        System.out.println("Numero giocatori: " + tombola.getGiocatori());
        
        System.out.println("\n=== GIOCATORI ===");
        System.out.println("Giocatore 1: " + g1.getNome() + " " + g1.getCognome());
        System.out.println("Giocatore 2: " + g2.getNome() + " " + g2.getCognome());
        System.out.println("Giocatore 3: " + g3.getNome() + " " + g3.getCognome());

        // Inizia il gioco
        tombola.avviaGioco();
    }
}
