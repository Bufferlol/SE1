/**
 * Erstellt ein Array für das Spielfeld.
 * 
 */
class ArraySpielfeld implements Spielfeld
{
    //Das Array _spieler vom Typ Integer
    private final int _feld[]; // a

    /**
     * Dem Array _feld wird ein neues Array mit der Länge 9 zugewiesen
     */
    public ArraySpielfeld()
    {
        _feld = new int[9]; //b
    }

    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * Hier wird der Spieler an der Position aus dem Array gelesen
     * 
     * @param position 0..8
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int position)
    {
        return _feld[position]; // c
    }

    /**
     * Besetzt die angegebene Position auf dem Spielfeld fuer einen Spieler.
     * 
     * Hier wird der Spieler an der angegebenen Position festgelegt
     * 
     * @param position 0..8
     * @param spieler 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetzePosition(int position, int spieler)
    {
        _feld[position] = spieler; // d
    }

    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     * 
     * Hier wird gelesen ob jedes Feld von einem Spieler belegt ist
     */
    public boolean istVoll()
    {
        for (int i : _feld) // c
        {
            if (i == 0)
            {
                return false;
            }
        }
        return true;
    }
}

