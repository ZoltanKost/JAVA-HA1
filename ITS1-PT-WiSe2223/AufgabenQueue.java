 
/**
 * Dieses Interface spezifiziert Queues von Aufgaben.
 * 
 * Die Queue verwaltet Aufgaben nach dem FIFO-Prinzip, 
 * die zuerst eingefügte Aufgabe wird auch als erstes zurück geliefert. 
 * 
 * @author Axel Schmolitzky 
 * @version WiSe 2022/23
 */

interface AufgabenQueue
{
    /**
     * Diese Operation fügt der Queue eine Aufgabe hinzu.
     * Ein Aufruf mit null führt zu einer IllegalArgumentException.
     * 
     * @param a die in die Queue einzufügende Aufgabe, darf nicht null sein.
     * @throws IllegalArgumentException
     */   
    public void enqueue(Aufgabe a);
    
    /**
     * Diese Operation liefert die nächste Aufgabe aus der Queue.
     * Die Aufgabe wird aus der Queue gelöscht. Darf nicht aufgerufen
     * werden, wenn die Queue leer ist.
     * Ein Aufruf bei leerer Queue führt zu einer IllegalStateException.
     * 
     * @return die nächste Aufgabe der Queue.
     * @throws IllegalStateException
     */
    public Aufgabe dequeue();

    /**
     * Diese Operation liefert true, wenn die Queue keine Aufgabe enthält,
     * sonst false.
     * 
     * @return ob die Queue leer ist.
     */
    public boolean isEmpty();
}
