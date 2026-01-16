import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tombola
{
    private LocalDate data;
    private String nomeEvento;
    private String luogo;
    private ArrayList<Scheda> schede = new ArrayList<>();
    private ArrayList<Giocatore> giocatori = new ArrayList<>();

    private Boolean ambo = false;
    private Boolean terna = false;
    private Boolean quaterna = false;
    private Boolean cinquina = false;

    private Boolean tombola = false; 
    private List<Integer> sacchetto;

    public void preparaPartita()
    {
        // Crea il sacchetto con i numeri da 1 a 90 e li mescola
        sacchetto = IntStream.rangeClosed(1, 90).boxed().collect(Collectors.toList()); //.boxed trasforma gli int in Integer
        Collections.shuffle(sacchetto); // Mescola i numeri in modo casuale
    }

    public Tombola(LocalDate data, String nomeEvento, String luogo)
    {
        this.data = data;
        this.nomeEvento = nomeEvento;
        this.luogo = luogo;
    }

    public LocalDate getData()
    {
        return data;
    }

    public String getNomeEvento()
    {
        return nomeEvento;
    }

    public String getLuogo()
    {
        return luogo;
    }

    public Integer getSchede()
    {
        return schede.size();
    }

    public void setSchede(Scheda scheda)
    {
        schede.add(scheda);
    }

    public void addScheda(Giocatore giocatore)
    {
        Boolean isIn = false;
        for (Giocatore g : giocatori)
        {
            if (giocatore.equals(g))
            {
                isIn = true;
            }
        }

        if (isIn)
        {
            giocatore.addCartella();
        }
        else
        {
            System.err.println("Giocatore non trovato");
        }
    }

    public Integer getGiocatori()
    {
        return giocatori.size();
    }

    public void setGiocatore(Giocatore giocatore, String choice)
    {
        Boolean isIn = false;

        if (choice.equalsIgnoreCase("add"))
        {
            for (Giocatore g : giocatori)
            {
                if (g.equals(giocatore))
                {
                    isIn = true;
                }
            }

            if (!isIn)
            {
                this.giocatori.add(giocatore);
            }
            else
            {
                System.err.println("Giocatore già presente");
            }
        }
        else if (choice.equalsIgnoreCase("rem"))
        {
            for (Giocatore g : giocatori)
            {
                if (g.equals(giocatore))
                {
                    isIn = true;
                }
            }

            if (isIn)
            {
                this.giocatori.remove(giocatore);
            }
            else
            {
                System.err.println("Giocatore non presente");
            }
        }
    }

    public void avviaGioco()
    {
        preparaPartita();
        int turno = 0;

        while (!tombola && turno < sacchetto.size())
        {
            int estratto = sacchetto.get(turno++);
            System.out.println("\nNumero estratto: " + estratto);

            for (Giocatore g : giocatori)
            {
                // Ogni giocatore controlla le sue schede
                for (Scheda s : g.getSchede())
                {
                    if (s.controllaNumero(estratto))
                    {
                        verificaPremi(g, s);
                    }
                }
            }

            System.out.println("Premi vinti finora: " + (ambo?"Ambo ":"") + (terna?"Terna ":"") + (tombola?"TOMBOLA!":""));
            // Pausa tra i turni (facoltativo)
            // sc.nextLine(); 
        }
    }

    private void verificaPremi(Giocatore g, Scheda s)
    {
        int maxSuRiga = s.getMassimoSuRiga();
        int totale = s.totaleSegnati();

        // Logica a cascata per i premi
        if (!ambo && maxSuRiga == 2)
        {
            ambo = true;
            System.out.println("!!! AMBO per " + g.getNome() + " !!!");
        }
        else if (!terna && maxSuRiga == 3)
        {
            terna = true;
            System.out.println("!!! TERNA per " + g.getNome() + " !!!");
        }
        else if (!quaterna && maxSuRiga == 4)
        {
            quaterna = true;
            System.out.println("!!! QUATERNA per " + g.getNome() + " !!!");
        }
        else if (!cinquina && maxSuRiga == 5)
        {
            cinquina = true;
            System.out.println("!!! CINQUINA per " + g.getNome() + " !!!");
        }

        if (totale == 15)
        {
            tombola = true;
            System.out.println("!!! TOMBOLA per " + g.getNome() + " !!!");
        }
    }
}
