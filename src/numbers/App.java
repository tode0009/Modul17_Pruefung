package numbers;

public class App {

	public static void main(String[] args) {
			
		System.out.println("Einige Berechnungen mit der Klasse Rational");
		System.out.println("Testen Sie Ihre Kenntnisse im Bruchrechnen!");
		System.out.println("\nAddition");	
		
		Rational b = new Rational(3,7);	
		Rational c = new Rational(2,6);
		Rational ergebnis = new Rational(3,7);
		
		ergebnis.add(c);
		System.out.println(b + "+" + c + " = " + ergebnis);
			
		Rational z = new Rational(10,25);
		Rational x = new Rational(13,16);
		Rational y = z.add(z, x);
		
		System.out.println(z + "+" + x + " = " + y);
		
		System.out.println("\nSubtraktion");
		b = new Rational(2,5);
		c = new Rational(13,16);
		ergebnis = new Rational(2,5);
		
		ergebnis.sub(c);
		System.out.println(b + "-" + c + " = " + ergebnis);
		
		System.out.println("\nMultiplikation");
		b = new Rational(1,2);	
		c = new Rational(1,5);
                ergebnis = new Rational(b);
		
		ergebnis.mul(c);		
		System.out.println(b + "*" + c + " = " + ergebnis);
		
		System.out.println("\nDivision");
		ergebnis = new Rational(b);
		Rational a = new Rational(3,4);
		ergebnis.div(a);
		System.out.println(b + " / " + a + " = " + ergebnis);
		
		System.out.println("\nKehrwert bilden");
		System.out.println("Wir bilden den Kehrwert von " + ergebnis);
		ergebnis.kehrwert();
		System.out.println("Der Kehrwert ist " + ergebnis);

		System.out.println("\nDezimalbruch bilden");
		b = new Rational(1,3);
		System.out.println("Der Dezimalbruch als double-Zahl zu " + b + " ist " + b.getDoubleWert());
	}
}
