import java.util.ArrayList;

public class Giocatore
{
    private String nome;
    private String cognome;
    private Boolean ammonito;
    private Boolean espulso;
    private ArrayList<Scheda> schede = new ArrayList<>();
    private Tombola t; // Mi serve per collegare il giocatore alla tombola a cui partecipa e settare le schede

    public Giocatore(String nome, String cognome, Boolean ammonito, Boolean espulso, Integer numS, Tombola t)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.ammonito = ammonito;
        this.espulso = espulso;
        this.t = t;

        for(int i = 0; i<numS; i++)
        {
            Scheda scheda = new Scheda();
            schede.add(new Scheda());
            t.setSchede(scheda);
        }
    }

    public Tombola getT()
    {
        return t;
    }

    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public Boolean getAmmonito()
    {
        return ammonito;
    }

    public void setAmmonito()
    {
        chiedeScusa();
        ammonito = true;
    }

    public Boolean getEspulso()
    {
        chiedeScusa();
        return espulso;
    }

    public void setEspulso()
    {
        if (ammonito)
        {
            espulso = true;
        }
    }

    public ArrayList<Scheda> getSchede()
    {
        return schede;
    }

    public String esulta()
    {
        return "EVVIVA!";
    }

    public String chiedeScusa()
    {
        return "Scusate...";
    }

    public Scheda addCartella()
    {
        Scheda s = new Scheda();
        schede.add(new Scheda());
        return s;
    }
}
