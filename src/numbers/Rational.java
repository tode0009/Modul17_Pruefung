package numbers;

/**
 * Eine Klasse für rationale Zahlen.
 * 
 * <p> Eine Klasse für rationale Zahlen, realisiert als Bruch aus ganzen Zahlen. 
 * Abgeleitet von Zahl.java. </p>
 * 
 * <P>Letzte Änderung: $Date: 2018/09/16 $</p> 
 * @author $Author: demirci $
 * @version $Revision: #3 $
 */

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rational extends Zahl {
	
	/**
	 * Logger
	 */
	static final Logger log = LogManager.getLogger("LoggerFuerRest");
	
	/**
	 * Zähler
	 */
	private int p;
	
	/**
	 * Nenner
	 */	
	private int q;

	/**
	 * Ein Bruch.
	 * 
	 * <p> Zähler und Nenner werden mit dem Wert 1 initialisiert und wir erhalten einen 
	 * Anfangsbruch von 1/1. </p>
	 */
	public Rational() {
		if(log.isTraceEnabled()) log.trace("** >> Rational()");
		
		this.p = 1;
		this.q = 1;
		if(log.isDebugEnabled()) log.debug("-- Rational() -> p = " + p + "; q = " + q );

		if(log.isTraceEnabled()) log.trace("** << Rational()");
	}

	/**
	 * Ein Bruch mit übergebenem Zähler und einem Nenner = 1.
	 * 
	 * @param z Zähler
	 */
	public Rational(int z) {
		if(log.isTraceEnabled()) log.trace(">> Rational(int)");
		
		this.p = z;
		this.q = 1;
		if(log.isDebugEnabled()) log.debug("-- Rational(int) -> p = " + p + "; q = " + q );
		
		if(log.isTraceEnabled()) log.trace("<< Rational(int)");
	}

	/**
	 * Ein Bruch mit übergebenem Zähler und Nenner.
	 * Nenner darf nicht 0 sein. Der Bruch wird gekürzt.
	 * 
	 * @param z Zähler
	 * @param n Nenner
	 */
	public Rational(int z, int n) {
		if(log.isTraceEnabled()) log.trace(">> Rational(int, int)");
		
		this.p = z;
		this.q = n;
		if(log.isDebugEnabled()) log.debug("-- Rational(int, int) ->p = " + p + "; q = " + q );
		assert (n != 0);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet");
		kuerzen();
		
		if(log.isTraceEnabled()) log.trace("<< Rational(int, int)");
	}
	
	/**
	 * Kopierkonstruktor.
	 * 
	 * <p>Aus dem übergebenen Objekt werden Zaehler und Nenner ermittelt und zur 
	 * Weiterverarbeitung weitergereicht.</p>
	 * 
	 * @param other Rationale Zahl, der kopiert wird
	 */
	public Rational(Rational other) {
		this(other.zaehler(), other.nenner());
		
		if(log.isTraceEnabled()) log.trace(">> Rational(Rational)");		
		
		if(log.isDebugEnabled()) log.debug("-- Rational(Rational) -> p = " + other.zaehler() + "; q = " + other.nenner() );
		
		if(log.isTraceEnabled()) log.trace("<< Rational(Rational)");
	}

	/**
	 * Ausgabe des Bruches.
	 */
	public void print() {
		if(log.isTraceEnabled()) log.trace(">> Rational.print");
		
		System.out.println(p + "/" + q);
		if(log.isDebugEnabled()) log.debug("-- print() -> p = " + p + "; q = " + q );
		
		if(log.isTraceEnabled()) log.trace("<< Rational.print");
	}
	
	/**
	 * Überschreiben der Funktion toString für Konsolenausgaben.
	 * 
	 *  @return Ein String, der den Bruch beschreibt.
	 */
	@Override
	public String toString() {
		if(log.isTraceEnabled()) log.trace(">> Rational.toString");
		
		String text = "";
		text = String.valueOf(p) + "/" + String.valueOf(q);
		if(log.isDebugEnabled()) log.debug("-- toString() -> String ist: " + text);
		
		if(log.isTraceEnabled()) log.trace("<< Rational.toString");
		return text;
	}
	
	/**
	 * Abfrage des aktuell hinerlegten Wertes für den Zähler.	
	 * 
	 * @return Der Zähler wird als Integerwert mitgeteilt
	 */
	public int zaehler() {
		if(log.isTraceEnabled()) log.trace(">> Rational.zaehler");
		if(log.isDebugEnabled()) log.debug("-- zaehler() -> Zaehler ist: " + p);
		if(log.isTraceEnabled()) log.trace("<< Rational.zaehler");
		return p;
	}
	
	/**
	 * Abfrage des aktuell hinerlegten Wertes für den Nenner.	
	 * 
	 * @return Der Nenner wird als Integerwert mitgeteilt
	 */
	public int nenner() {
		if(log.isTraceEnabled()) log.trace(">> Rational.nenner");
		if(log.isDebugEnabled()) log.debug("-- nenner() -> Nenner ist: " + p);
		if(log.isTraceEnabled()) log.trace("<< Rational.nenner");
		return q;
	}

	/**
	 * Addition zweier Brüche.
	 * Zwei Brüche werden miteinander addiert.
	 * 
	 * @param z Objekt mit den Werten aus Zähler und Nenner
	 */
	public void add(Zahl z) {
		if(log.isTraceEnabled()) log.trace(">> Rational.add(Zahl)");
		
		Rational local = (Rational) z;
		if(log.isDebugEnabled()) log.debug("-- add(Zahl) -> local ist: " + local);
		
		p = p * local.q + local.p * q;
		q = q * local.q;
		
		if(log.isDebugEnabled()) log.debug("-- add(Zahl) -> p ist: " + p);
		if(log.isDebugEnabled()) log.debug("-- add(Zahl) -> q ist: " + q);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet.");
		kuerzen();
		
		if(log.isTraceEnabled()) log.trace("<< Rational.add(Zahl)");
	}

	/** 
	 * Konstruktion einer Rationalen Zahl.
	 * 
	 * <p>Eine Rationale Zahl wird zusammengestellt, auch die Membervariablen p und q werden durch
	 * den entsprechenden Konstrukor initialisiert.</p>
	 * 
	 * <p>Die rationale Zahl wird an die nächste Methode weitergereicht.
	 * Der Bruch wird anschließend gekürzt.</p>
	 * 
	 * @param i Zähler wird festgelegt mit dem Parameter
	 */
	public void add(int i) {
		if(log.isTraceEnabled()) log.trace(">> Rational.add(int)");
		
		Rational local = new Rational(i);		
		if(log.isDebugEnabled()) log.debug("-- add(int) -> local ist: " + local);
		
		if(log.isInfoEnabled()) log.info("Methode add(zahl) wird aufgerufen.");
		add(local);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet.");
		kuerzen();
		
		if(log.isTraceEnabled()) log.trace("<< Rational.add(int)");
	}

	/**
	 * Subtraktion zweier Brüche.
	 * 
	 * <p>Zwei Brüche werden miteinander subrahiert.</p>
	 * 
	 * @param z Objekt mit den Werten aus Zähler und Nenner
	 */
	public void sub(Zahl z) {
		if(log.isTraceEnabled()) log.trace(">> Rational.sub(Zahl)");
		
		Rational local = (Rational) z;
		if(log.isDebugEnabled()) log.debug("-- sub(Zahl) -> local ist: " + local);
		
		p = p * local.q - local.p * q;
		q = q * local.q;
		
		if(log.isDebugEnabled()) log.debug("-- sub(Zahl) -> p ist: " + p);
		if(log.isDebugEnabled()) log.debug("-- sub(Zahl) -> q ist: " + q);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet.");
		kuerzen();
		
		if(log.isTraceEnabled()) log.trace("<< Rational.sub(Zahl)");
	}

	/** 
	 * Konstruktion einer Rationalen Zahl.
	 * 
	 * <p>Eine Rationale Zahl wird zusammengestellt, auch die Membervariablen p und q werden durch
	 * den entsprechenden Konstrukor initialisiert.</p>
	 * 	 * 
	 * <p>Das Objekt wird an die nächste Methode weitergereicht.
	 * Der Bruch wird anschließend gekürzt.</p>
	 * 
	 * @param i Zähler wird festgelegt mit dem Parameter
	 */
	public void sub(int i) {
		if(log.isTraceEnabled()) log.trace(">> Rational.sub(int)");
		
		Rational local = new Rational(i);
		if(log.isDebugEnabled()) log.debug("-- sub(int) -> local ist: " + local);
		
		if(log.isInfoEnabled()) log.info("Methode sub(Zahl) wird aufgerufen.");
		sub(local);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet.");
		kuerzen();
		
		if(log.isTraceEnabled()) log.trace("<< Rational.sub(int)");
	}
	
	/**
	 * Multiplikation zweier Brüche.
	 * 
	 * <p>Zwei Brüche werden miteinander multipliziert.</p>
	 * 
	 * @param z Objekt mit den Werten aus Zähler und Nenner
	 */
	public void mul(Zahl z) {
		if(log.isTraceEnabled()) log.trace(">> Rational.mul(Zahl)");
		
		Rational local = (Rational) z;
		if(log.isDebugEnabled()) log.debug("-- mul(Zahl) -> local ist: " + local);
		
		p = p * local.p;
		q = q * local.q;
		
		if(log.isDebugEnabled()) log.debug("-- mul(Zahl) -> p ist: " + p);
		if(log.isDebugEnabled()) log.debug("-- mul(Zahl) -> q ist: " + q);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet.");
		kuerzen();
		
		if(log.isTraceEnabled()) log.trace("<< Rational.mul(Zahl)");
	}

	/** 
	 * Konstruktion einer Rationalen Zahl.
	 * 
	 * <p>Eine Rationale Zahl wird zusammengestellt, auch die Membervariablen p und q werden durch
	 * den entsprechenden Konstrukor initialisiert.</p>
	 * 
	 * <p>Das Objekt wird an die nächste Methode weitergereicht.
	 * Der Bruch wird anschließend gekürzt.</p>
	 * 
	 * @param i Zähler wird festgelegt mit dem Parameter
	 */
	public void mul(int i) {
		if(log.isTraceEnabled()) log.trace(">> Rational.mul(int)");
		
		Rational local = new Rational(i);
		if(log.isDebugEnabled()) log.debug("-- mul(int) -> local ist: " + local);
		
		if(log.isInfoEnabled()) log.info("Methode mul(Zahl) wird aufgerufen.");
		mul(local);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet.");
		kuerzen();
		
		if(log.isTraceEnabled()) log.trace("<< Rational.mul(int)");
	}

	/**
	 * Division zweier Brüche.
	 * 
	 * <p>Zwei Brüche werden miteinander dividiert.</p>
	 * 
	 * @param z Objekt mit den Werten aus Zähler und Nenner
	 */
	public void div(Zahl z) {
		if(log.isTraceEnabled()) log.trace(">> Rational.div(Zahl)");
		
		Rational local = (Rational) z;
		if(log.isDebugEnabled()) log.debug("-- div(Zahl) -> local ist: " + local);
		
		p = p * local.q;
		q = q * local.p;
		
		if(log.isDebugEnabled()) log.debug("-- div(Zahl) -> p ist: " + p);
		if(log.isDebugEnabled()) log.debug("-- div(Zahl) -> q ist: " + q);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet.");
		kuerzen();		
		
		if(log.isTraceEnabled()) log.trace("<< Rational.div(Zahl)");
	}

	/** 
	 * Konstruktion einer Rationalen Zahl.
	 * 
	 * <p>Eine Rationale Zahl wird zusammengestellt, auch die Membervariablen p und q werden durch
	 * den entsprechenden Konstrukor initialisiert.</p>
	 * 
	 * <p>Das Objekt wird an die nächste Methode weitergereicht.
	 * Der Bruch wird anschließend gekürzt.</p>
	 * 
	 * @param i Zähler wird festgelegt mit dem Parameter
	 */
	public void div(int i) {
		if(log.isTraceEnabled()) log.trace(">> Rational.div(int)");
		
		Rational local = new Rational(i);
		if(log.isDebugEnabled()) log.debug("-- div(int) -> local ist: " + local);
		
		if(log.isInfoEnabled()) log.info("Methode div(Zahl) wird aufgerufen.");
		div(local);
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet.");
		kuerzen();
		
		if(log.isTraceEnabled()) log.trace("<< Rational.div(int)");
	}

	/**
	 * Kehrwert eines Bruchs.
	 * 
	 * <p>Der Bruch wird in seinen Kehrwert umgestellt, und sichergestellt das der Nenner keine 0 ist.
	 * Den Kehrwert eines Bruchs erhält man durch Vertauschen von Zähler und Nenner.</p>
	 */
	public void kehrwert() {
		if(log.isTraceEnabled()) log.trace(">> Rational.kehrwert");
		
		int temp = p;
		p = q;
		q = temp;
		
		if(log.isDebugEnabled()) log.debug("-- kehrwert() -> p ist: " + p);
		if(log.isDebugEnabled()) log.debug("-- kehrwert() -> q ist: " + q);
		assert (q != 0);
		
		if(log.isTraceEnabled()) log.trace("<< Rational.kehrwert");
	}

	/**
	 * Der Zähler wird negiert.
	 */
	public void switchSign() {
		if(log.isTraceEnabled()) log.trace(">> Rational.switchSign");
		if(log.isDebugEnabled()) log.debug("-- switchSign() -> p ist: " + p);
		
		p = -p;
		
		if(log.isDebugEnabled()) log.debug("-- switchSign() -> p ist: " + p);
		if(log.isTraceEnabled()) log.trace("<< Rational.switchSign");
	}
	
	/**
	 * Bruch kürzen.
	 * 
	 * <p>Der vorhandene Bruch wird gekürzt. In einer eigenen Methode wird der Größte gemeinsame Teiler
	 * ermittelt. Auch negative Brüche sind berücksichtigt.</p>
	 */
	public void kuerzen() {
		if(log.isTraceEnabled()) log.trace(">> Rational.kuerzen");
		
		// Vorzeichen merken und Betrag bilden
		int sign = 1;
		if (p < 0) {
			sign = -sign;
			p = -p;
		}
		if (q < 0) {
			sign = -sign;
			q = -q;
		}

		int teiler = ggt(p, q);
		if(log.isDebugEnabled()) log.debug("-- kuerzen() -> Teiler ist: " + teiler);

		// Vorzeichen restaurieren
		p = sign * p / teiler;
		q = q / teiler;

		if(log.isTraceEnabled()) log.trace("<< Rational.kuerzen");
	}

	/**
	 * Der Bruch wird geteilt und in Dezimalzahl gewandelt.
	 * 
	 * @return Bruch als Dezimalzahl
	 */
	public double getDoubleWert() {
		if(log.isTraceEnabled()) log.trace(">> Rational.getDoubleWert");
		if(log.isDebugEnabled()) log.debug("-- getDoubleWert() -> Zaehler ist: " + (double) p + "; Nenner ist: " + (double) q);
		if(log.isTraceEnabled()) log.trace("<< Rational.getDoubleWert");
		return (double) p / (double) q;
	}

	/**
	 * Es wird geprüft, ob der Bruch einer ganzen Zahl entspricht.
	 * 
	 * @return Ergebnis der Prüfung boolischer Wert
	 */
	public boolean isInteger() {
		if(log.isTraceEnabled()) log.trace(">> Rational.isInteger");
		
		if (p % q == 0) {
			if(log.isTraceEnabled()) log.trace("<< Rational.isInteger");
			return true;			
		}else {
			if(log.isTraceEnabled()) log.trace("<< Rational.isInteger");
			return false;
		}
	}
	
	/**
	 * Der größte gemeinsame Teiler wird ermittelt.
	 * 
	 * @param x erste Zahl
	 * @param y zweite Zahl
	 * @return größte Zahl, durch die beide Zahlen teilbar sind.
	 */
	private int ggt(int x, int y) {
		if(log.isTraceEnabled()) log.trace(">> Rational.ggt");
		if(log.isDebugEnabled()) log.debug("-- ggt() -> X ist: " + x );
		if(log.isDebugEnabled()) log.debug("-- ggt() -> Y ist: " + y );
		
		while (y > 0) {
			int rest = x % y;
			x = y;
			y = rest;
		}
		
		if(log.isTraceEnabled()) log.trace("<< Rational.ggt");
		return x;
	}

	/**
	 * Zwei Rationale Zahlen (Brüche) werden miteinander addiert.
	 * 
	 * @param a Rationale Zahl
	 * @param b Rationale Zahl
	 * @return Eine rationale Zahl (Ergebnis der Berechnung)
	 */
	public Rational add(Rational a, Rational b) {
		if(log.isTraceEnabled()) log.trace(">> Rational.add(Rational, Rational)");
		
		if(log.isInfoEnabled()) log.info("Addition wird gestartet.");
		a.add(b);
		
		if(log.isTraceEnabled()) log.trace("<< Rational.add(Rational, Rational)");
		return a;

	}

	/**
	 * Subraktion zweier rationalen Zahlen.
	 * 
	 * <p>Erste rationale Zahl subtrahiert durch die zweite rationale Zahl.</p>
	 * 
	 * @param a Rationale Zahl
	 * @param b Rationale Zahl
	 * @return Eine rationale Zahl (Ergebnis der Berechnung)
	 */
	public Rational sub(Rational a, Rational b) {
		if(log.isTraceEnabled()) log.trace(">> Rational.sub(Rational, Rational)");
		
		if(log.isInfoEnabled()) log.info("Subtraktion wird gestartet.");
		a.sub(b);
		
		if(log.isTraceEnabled()) log.trace("<< Rational.sub(Rational, Rational)");
		return a;

	}

	/**
	 * Division zweier rationalen Zahlen.
	 * 
	 * <p>Erste rationale Zahl dividiert durch die zweite rationale Zahl.</p>
	 * 
	 * @param a Rationale Zahl
	 * @param b Rationale Zahl
	 * @return Eine rationale Zahl (Ergebnis der Berechnung)
	 */
	public Rational div(Rational a, Rational b) {
		if(log.isTraceEnabled()) log.trace(">> Rational.div(Rational, Rational)");
		
		if(log.isInfoEnabled()) log.info("Division wird gestartet.");
		a.div(b);
		
		if(log.isTraceEnabled()) log.trace("<< Rational.div(Rational, Rational)");
		return a;

	}

	/**
	 * Multiplikation zweier rationalen Zahlen.
	 *   
	 * @param a Rationale Zahl
	 * @param b Rationale Zahl
	 * @return Eine rationale Zahl (Ergebnis der Berechnung)
	 */
	public Rational mul(Rational a, Rational b) {
		if(log.isTraceEnabled()) log.trace(">> Rational.mul(Rational, Rational)");
		
		if(log.isInfoEnabled()) log.info("Multiplikation wird gestartet.");
		a.mul(b);
		
		if(log.isTraceEnabled()) log.trace("<< Rational.mul(Rational, Rational)");
		return a;

	}

	/**
	 * Eingabe zweier Zahlen und Ausgabe als gekürzten Bruch.
	 * 
	 * <p>Die eingegebenen Zahlen sollen einen Bruch ergeben, die erste Zahl ist der Zähler, die zweite 
	 * Zahl der Nenner. Der eingegebene Bruch wird in gekürzter Form wieder ausgegeben.</p>
	 */
	public void eingabe() {
		if(log.isTraceEnabled()) log.trace(">> Rational.eingabe");
		
		Scanner sc = new Scanner(System.in);

		if(log.isInfoEnabled()) log.info("Geben Sie den Zaehler ein:");
		System.out.println("Geben Sie den Zaehler ein:");
		int i = sc.nextInt();
		p = i;
		if(log.isDebugEnabled()) log.debug("-- eingabe() -> P ist: " + p);
		
		if(log.isInfoEnabled()) log.info("Geben Sie den Nenner ein:");
		System.out.println("Geben Sie den Nenner ein:");
		i = sc.nextInt();
		q = i;
		if(log.isDebugEnabled()) log.debug("-- eingabe() -> Q ist: " + q);

		sc.close();

		if(log.isInfoEnabled()) log.info("Ihre Eingabe:");
		System.out.println("Ihre Eingabe:");
		
		if(log.isInfoEnabled()) log.info("Kürzen wird gestartet");
		kuerzen();
		
		if(log.isInfoEnabled()) log.info("Ausgabe auf Console wird gestartet");
		print();
		
		if(log.isTraceEnabled()) log.trace("<< Rational.eingabe");
	}

}
