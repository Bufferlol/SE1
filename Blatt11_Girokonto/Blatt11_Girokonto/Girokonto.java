import java.util.*;

/**
 * Ein einfaches Girokonto fuer ganzzahlige Betraege.
 * Es kann abgehoben und eingezahlt werden. Ein Girokonto kann
 * nur bis zu einem Dispo-Limit ueberzogen werden.
 * Dieses Dispo-Limit kann veraendert werden. Als Dispo-Limit
 * sind nur positive Werte erlaubt.
 * 
 * @author Martti Jeenicke
 * @author Axel Schmolitzky
 * @author Petra Becker-Pechau
 * @version WiSe 2013
 */
class Girokonto
{
    // der ganzzahlige Saldo
    private int _saldo;

    // das Dispolimit
    private int _dispoLimit;
    
    //Liste zum speichern der Kontobewegungen
    private List<Kontobewegung> _umsaetze;

    /**
     * Ein neues Konto hat einen Anfangssaldo und ein Dispo-Limit von 0.
     */
    public Girokonto()
    {
        _saldo = 0;
        _dispoLimit = 0;
        _umsaetze = new LinkedList<Kontobewegung>();
    }

    /**
     * Liefert das Dispo-Limit dieses Kontos.
     * 
     * @return das Dispo-Limit
     */
    public int gibDispoLimit()
    {
        return _dispoLimit;
    }

    /**
     * Setze das Dispo-Limit auf den gegebenen Wert.
     * 
     * @param dispoLimit ein nicht-negativer Wert als neues Dispo-Limit
     */
    public void setzeDispoLimit(int dispoLimit)
    {
        if (dispoLimit < 0)
        {
            throw new IllegalArgumentException("Fehler: das Limit muss positiv sein.");
        }
        _dispoLimit = dispoLimit;
    }

    /**
     * Zahlt einen Betrag auf das Konto ein.
     * 
     * @param betrag
     *            der einzuzahlende Betrag
     */
    public void zahleEin(int betrag)
    {
        if (betrag <= 0)
        {
            throw new IllegalArgumentException("Fehler: der Betrag muss positiv sein.");
        }
        _saldo = _saldo + betrag;
        _umsaetze.add(new Kontobewegung(betrag));
    }

    /**
     * Hebt einen Betrag vom Konto ab.
     * 
     * @param betrag
     *            der abzuhebende Betrag
     */
    public void hebeAb(int betrag)
    {
        if (betrag <= 0)
        {
            throw new IllegalArgumentException("Fehler: der Betrag muss positiv sein.");
        }
        if ((_saldo - betrag) < -_dispoLimit)
        {
            throw new IllegalArgumentException("Fehler: Auszahlung nicht moeglich, Dispo-Limit wuerde ueberschritten.");
        }
        _saldo = _saldo - betrag;
        _umsaetze.add(new Kontobewegung(betrag*(-1)));
    }

    /**
     * Liefert den Saldo des Kontos.
     * 
     * @param das Saldo
     */
    public int gibSaldo()
    {
        return _saldo;
    }
    
    /**
     * Liefert die Umsaetze.
     * 
     */
    public void druckeKontobewegungen()
    {
        for (Kontobewegung i : _umsaetze)
        {
            System.out.println ( i.gibDruckbareForm());
        }
    }
}
