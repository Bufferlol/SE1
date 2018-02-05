import java.io.File;

/**
 * Exemplare dieser Klasse repraesentieren Dateien im Dateisystem.
 * Ihr Zweck liegt darin, das Auffinden von Duplikaten zu erleichtern.
 *  
 * @author Fredrik Winkler
 * @version 16. Dezember 2014
 */
class Datei
{
    private final File _file;
    private final long _groesse;
    private String _fingerabdruck;
    private final String _name;

    /**
     * Initialisiert eine neue Datei und merkt sich deren Groesse.
     * 
     * @param file das einzulesende File
     */
    public Datei(File file)
    {
        _file = file;
        _groesse = file.length();
        _name = file.getName();
    }

    /**
     * Wann gelten zwei Exemplare dieser Klasse als gleich?
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof Datei)
        {
            Datei zweite = (Datei) obj;
            return (_groesse == zweite._groesse)
                && (fingerabdruck().equals(zweite.fingerabdruck())
                && (_name.equals(zweite._name)));
        }
        return false;
    }

    /**
     * Wie wird der hashCode berechnet?
     */
    public int hashCode()
    {
        return (int) _groesse;
    }

    /**
     * Liefert den Dateinamen und den Fingerabdruck als String zurueck.
     * 
     * @return String im Format "DATEINAME (FINGERABDRUCK)"
     */
    public String toString()
    {
        return _file.toString() + " (" + fingerabdruck() + ")";
    }

    /**
     * Liefert den Fingerabdruck. Da der Fingerabdruck nur bei Bedarf generiert wird,
     * kann der erste Aufruf dieser Methode u.U. recht lange dauern.
     * 
     * @return der Fingerabdruck
     */
    public String fingerabdruck()
    {
        if (_fingerabdruck == null)
        {
            _fingerabdruck = Fingerabdruck.aus(_file);
        }
        return _fingerabdruck;
    }
}
