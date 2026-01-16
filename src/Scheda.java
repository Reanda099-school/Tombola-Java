import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Scheda
{
    private String codice;
    private static Integer cnt = 1;
    private ArrayList<ArrayList<Numero>> righe = new ArrayList<>(); // Matrice per le 3 righe

    public String getCodice()
    {
        return codice;
    }

    public Scheda()
    {
        this.codice = String.valueOf(cnt++);
        Random rng = new Random();
        
        // Generiamo 15 numeri unici totali
        ArrayList<Integer> tuttiINumeri = new ArrayList<>();
        while (tuttiINumeri.size() < 15)
        {
            int n = rng.nextInt(90) + 1;
            if (!tuttiINumeri.contains(n))
            {
                tuttiINumeri.add(n);
            }
        }
        Collections.sort(tuttiINumeri); // Opzionale: li ordiniamo

        // Distribuiamo i 15 numeri in 3 righe da 5
        int index = 0;
        for (int i = 0; i < 3; i++)
        {
            ArrayList<Numero> riga = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                riga.add(new Numero(tuttiINumeri.get(index++)));
            }
            righe.add(riga);
        }
    }

    // Controlla se il numero estratto è presente e lo segna
    public boolean controllaNumero(int n)
    {
        for (ArrayList<Numero> riga : righe)
        {
            for (Numero num : riga)
            {
                if (num.getNum() == n)
                {
                    num.segnaNumero();
                    return true;
                }
            }
        }
        return false;
    }

    // Restituisce il punteggio massimo fatto su una singola riga
    public int getMassimoSuRiga()
    {
        int max = 0;
        for (ArrayList<Numero> riga : righe)
        {
            int contatoreRiga = 0;
            for (Numero n : riga)
            {
                if (n.getUscito())
                    contatoreRiga++;
            }
            if (contatoreRiga > max)
                max = contatoreRiga;
        }
        return max;
    }

    // Conta quanti numeri totali sono usciti (per la Tombola)
    public int totaleSegnati()
    {
        int totale = 0;
        for (ArrayList<Numero> riga : righe)
        {
            for (Numero n : riga)
            {
                if (n.getUscito()) totale++;
            }
        }
        return totale;
    }
}