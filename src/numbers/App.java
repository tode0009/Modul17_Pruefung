package numbers;

/**
 * Eine Main Klasse mit 4 Grundrechenarten.
 * 
 * <p> Durch die Klasse wird vorgegeben, dass die 4 Grundrechenarten und die Ausgabe der Zahl
 * implementiert werden müssen. </p>
 * 
 * <P>Letzte Änderung: $Date: 2018/09/13 $</p> 
 * @author $Author: demirci $
 * @version $Revision: #2 $
 */

public class App {

	public static void main(String[] args) {
			
		System.out.println("Einige Berechnungen mit der Klasse Rational");
		System.out.println("Testen Sie Ihre Kenntnisse im Bruchrechnen!");
		
		// Hier werden zwei Additionen durchgeführt
		System.out.println("\nAddition");	
		
		// Werte für die erste Addition
		Rational b = new Rational(3,7);	
		Rational c = new Rational(2,6);
		Rational ergebnis = new Rational(3,7);
		
		ergebnis.add(c);
		System.out.println(b + "+" + c + " = " + ergebnis);
			
		// Werte für die zweite Addition
		Rational z = new Rational(10,25);
		Rational x = new Rational(13,16);
		Rational y = z.add(z, x);
		
		System.out.println(z + "+" + x + " = " + y);
		
		// Hier wird eine Subtraktion durchgeführt 
		System.out.println("\nSubtraktion");
		b = new Rational(2,5);
		c = new Rational(13,16);
		ergebnis = new Rational(2,5);
		
		ergebnis.sub(c);
		System.out.println(b + "-" + c + " = " + ergebnis);
		
		// Hier wird eine Multiplikation durchgeführt 
		System.out.println("\nMultiplikation");
		b = new Rational(1,2);	
		c = new Rational(1,5);
                ergebnis = new Rational(b);
		
		ergebnis.mul(c);		
		System.out.println(b + "*" + c + " = " + ergebnis);
		
		// Hier wird eine Division durchgeführt 
		System.out.println("\nDivision");
		ergebnis = new Rational(b);
		Rational a = new Rational(3,4);
		ergebnis.div(a);
		System.out.println(b + " / " + a + " = " + ergebnis);
		
		// Hier wird der Kehrwert eines Bruches gebilter
		System.out.println("\nKehrwert bilden");
		System.out.println("Wir bilden den Kehrwert von " + ergebnis);
		ergebnis.kehrwert();
		System.out.println("Der Kehrwert ist " + ergebnis);

		// Hier wird ein Bruch als Dezimalzahl dargestellt
		System.out.println("\nDezimalbruch bilden");
		b = new Rational(1,3);
		System.out.println("Der Dezimalbruch als double-Zahl zu " + b + " ist " + b.getDoubleWert());
	}
}
