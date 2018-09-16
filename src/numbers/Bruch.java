package numbers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eine Main Klasse zum kürzen von Brüchen.
 * 
 * <p> Nach Eingabe eines Bruches, indem der Zähler und der Nenner getrennt eingegeben werden,
 * wird anschließend der Bruch falls möglich gekürzt und in gekürzter Form ausgegeben.</p>
 *  
 * <P>Letzte Änderung: $Date: 2018/09/16 $</p> 
 * @author $Author: demirci $
 * @version $Revision: #2 $
 */

public class Bruch {

	static final Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		if(log.isTraceEnabled()) {
			log.trace(">> Bruch.Main"); 
		}
		
		System.out.println("Dieses Programm kürzt Ihren eingegebenen Bruch \n");
		
		Rational r = new Rational();
		if(log.isInfoEnabled()) log.info("Aufruf Eingabe Funktion");
		r.eingabe();
		
		if(log.isTraceEnabled()) {
			log.trace("<< Bruch.Main");
		}
		
	}
	
	/**
     * \mainpage
     * Rechnen mit Rationalen Zahlen
     * 
     * \image html rationaleZahlen66.jpg "Das Projekt-Logo"
     * 
     * Dies ist die Hauptseite der mit Doxygen erzeugten HTML-Dokumentation. In dieser
     * Version wurden Javadoc-Kommentare verwendet.
     * 
     * Dieser Text befindet sich in der Datei Bruch.java.
     */

}
