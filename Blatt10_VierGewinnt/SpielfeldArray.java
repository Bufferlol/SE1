
/**
 * Erstellt ein Array für das Spielfeld
 * 
 */
class SpielfeldArray implements Spielfeld
{
    private final int[][] _spielfeld;

    public SpielfeldArray()
    {
        _spielfeld = new int[7][6];
    }

    /**
     * Gibt an, ob das Spielfeld voll ist.
     */
    public boolean istSpielfeldVoll()
    {
        for (int i = 0; i < 7; i++)
        {
            if (!istSpalteVoll(i)) {return false;}
        }
        return true;
    }

    /**
     * Gibt an, ob die Spalte voll ist.
     */
    public boolean istSpalteVoll(int spalte)
    {
        return !(_spielfeld[spalte][5] == 0);
    }

    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position
     * @param spalte
     *            horizontale Position
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        return _spielfeld[spalte][zeile];
    }

    /**
     * Legt einen Spielstein in einer Spalte ab.
     * 
     * @param spalte
     *            die Spalte
     * @param spieler
     *            1 (Spieler 1), 2 (Spieler 2)
     */
    public void legeSpielsteinAb(int spalte, int spieler)
    {
        if (!istSpalteVoll(spalte))
        {
            boolean istFrei = false;
            int i = 0;
            while (!istFrei)
            {
                if (_spielfeld[spalte][i] == 0){istFrei = true;}
                else {i++;}
            }
            _spielfeld[spalte][i] = spieler;
        }
    }
}

