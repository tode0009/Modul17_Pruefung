package numbers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eine Main Klasse mit 4 Grundrechenarten.
 * 
 * <p> Durch die Klasse wird vorgegeben, dass die 4 Grundrechenarten und die Ausgabe der Zahl
 * implementiert werden müssen. </p>
 * 
 * <P>Letzte Änderung: $Date: 2018/09/16 $</p> 
 * @author $Author: demirci $
 * @version $Revision: #3 $
 */

public class App {

	/**
	 * Logger
	 */
	static final Logger log = LogManager.getLogger("LoggerFuerRest");
	
	public static void main(String[] args) {
		
		if(log.isTraceEnabled()) {
			log.trace(">> App.Main"); 
		}
		
		System.out.println("Einige Berechnungen mit der Klasse Rational");
		System.out.println("Testen Sie Ihre Kenntnisse im Bruchrechnen!");
		
		// Hier werden zwei Additionen durchgeführt
		if(log.isInfoEnabled()) log.info("Berechnung 1. Addition wird gestartet.");
		System.out.println("\nAddition");	
		
		// Werte für die erste Addition
		Rational b = new Rational(3,7);	
		Rational c = new Rational(2,6);
		Rational ergebnis = new Rational(3,7);
		
		ergebnis.add(c);
		System.out.println(b + "+" + c + " = " + ergebnis);
		if(log.isInfoEnabled()) log.info("Berechnung 1. Addition beendet.");
			
		// Werte für die zweite Addition
		if(log.isInfoEnabled()) log.info("Berechnung 2. Addition wird gestartet.");
		Rational z = new Rational(10,25);
		Rational x = new Rational(13,16);
		Rational y = z.add(z, x);
		
		System.out.println(z + "+" + x + " = " + y);
		if(log.isInfoEnabled()) log.info("Berechnung 2. Addition beendet.");
		
		// Hier wird eine Subtraktion durchgeführt 
		if(log.isInfoEnabled()) log.info("Berechnung Subtrakton wird gestartet.");
		System.out.println("\nSubtraktion");
		b = new Rational(2,5);
		c = new Rational(13,16);
		ergebnis = new Rational(2,5);
		
		ergebnis.sub(c);
		System.out.println(b + "-" + c + " = " + ergebnis);
		if(log.isInfoEnabled()) log.info("Berechnung Subtraktion beendet.");
		
		// Hier wird eine Multiplikation durchgeführt 
		if(log.isInfoEnabled()) log.info("Berechnung Multiplikation wird gestartet.");
		System.out.println("\nMultiplikation");
		b = new Rational(1,2);	
		c = new Rational(1,5);
                ergebnis = new Rational(b);
		
		ergebnis.mul(c);		
		System.out.println(b + "*" + c + " = " + ergebnis);
		if(log.isInfoEnabled()) log.info("Berechnung Multiplikation beendet.");
		
		// Hier wird eine Division durchgeführt 
		if(log.isInfoEnabled()) log.info("Berechnung Division wird gestartet.");
		System.out.println("\nDivision");
		ergebnis = new Rational(b);
		Rational a = new Rational(3,4);
		ergebnis.div(a);
		System.out.println(b + " / " + a + " = " + ergebnis);
		if(log.isInfoEnabled()) log.info("Berechnung Division beendet.");
		
		
		// Hier wird der Kehrwert eines Bruches gebilter
		if(log.isInfoEnabled()) log.info("Bildung Kehrwert wird gestartet.");
		System.out.println("\nKehrwert bilden");
		System.out.println("Wir bilden den Kehrwert von " + ergebnis);
		ergebnis.kehrwert();
		System.out.println("Der Kehrwert ist " + ergebnis);
		if(log.isInfoEnabled()) log.info("Bildung Kehrwert beendet.");

		// Hier wird ein Bruch als Dezimalzahl dargestellt
		if(log.isInfoEnabled()) log.info("Bruch als Dezimalzahl darstellen wird gestartet.");
		System.out.println("\nDezimalbruch bilden");
		b = new Rational(1,3);
		System.out.println("Der Dezimalbruch als double-Zahl zu " + b + " ist " + b.getDoubleWert());
		if(log.isInfoEnabled()) log.info("Bruch als Dezimalzahl darstellen beendet.");
		
		if(log.isTraceEnabled()) {
			log.trace("<< App.Main");
		}
	}
}
