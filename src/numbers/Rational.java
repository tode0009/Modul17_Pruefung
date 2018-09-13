package numbers;

/**
 * Eine Klasse für rationale Zahlen.
 * 
 * <p> Eine Klasse für rationale Zahlen, realisiert als Bruch aus ganzen Zahlen. 
 * Abgeleitet von Zahl.java. </p>
 * 
 * <P>Letzte Änderung: $Date: 2018/09/13 $</p> 
 * @author $Author: demirci $
 * @version $Revision: #2 $
 */

import java.util.Scanner;

public class Rational extends Zahl {
	
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
		this.p = 1;
		this.q = 1;

	}

	/**
	 * Ein Bruch mit übergebenem Zähler und einem Nenner = 1.
	 * 
	 * @param z Zähler
	 */
	public Rational(int z) {
		this.p = z;
		this.q = 1;
	}

	/**
	 * Ein Bruch mit übergebenem Zähler und Nenner.
	 * Nenner darf nicht 0 sein. Der Bruch wird gekürzt.
	 * 
	 * @param z Zähler
	 * @param n Nenner
	 */
	public Rational(int z, int n) {
		this.p = z;
		this.q = n;
		assert (n != 0);
		kuerzen();
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
	}

	/**
	 * Ausgabe des Bruches.
	 */
	public void print() {
		System.out.println(p + "/" + q);
	}
	
	/**
	 * Überschreiben der Funktion toString für Konsolenausgaben.
	 * 
	 *  @return Ein String, der den Bruch beschreibt.
	 */
	@Override
	public String toString() {
		String text = "";
		text = String.valueOf(p) + "/" + String.valueOf(q);
		return text;
	}
	
	/**
	 * Abfrage des aktuell hinerlegten Wertes für den Zähler.	
	 * 
	 * @return Der Zähler wird als Integerwert mitgeteilt
	 */
	public int zaehler() {
		return p;
	}
	
	/**
	 * Abfrage des aktuell hinerlegten Wertes für den Nenner.	
	 * 
	 * @return Der Nenner wird als Integerwert mitgeteilt
	 */
	public int nenner() {
		return q;
	}

	/**
	 * Addition zweier Brüche.
	 * Zwei Brüche werden miteinander addiert.
	 * 
	 * @param z Objekt mit den Werten aus Zähler und Nenner
	 */
	public void add(Zahl z) {
		Rational local = (Rational) z;
		p = p * local.q + local.p * q;
		q = q * local.q;
		kuerzen();

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
		Rational local = new Rational(i);
		add(local);
		kuerzen();
	}

	/**
	 * Subtraktion zweier Brüche.
	 * 
	 * <p>Zwei Brüche werden miteinander subrahiert.</p>
	 * 
	 * @param z Objekt mit den Werten aus Zähler und Nenner
	 */
	public void sub(Zahl z) {
		Rational local = (Rational) z;
		p = p * local.q - local.p * q;
		q = q * local.q;
		kuerzen();
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
		Rational local = new Rational(i);
		sub(local);
		kuerzen();
	}
	
	/**
	 * Multiplikation zweier Brüche.
	 * 
	 * <p>Zwei Brüche werden miteinander multipliziert.</p>
	 * 
	 * @param z Objekt mit den Werten aus Zähler und Nenner
	 */
	public void mul(Zahl z) {
		Rational local = (Rational) z;
		p = p * local.p;
		q = q * local.q;
		kuerzen();
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
		Rational local = new Rational(i);
		mul(local);
		kuerzen();
	}

	/**
	 * Division zweier Brüche.
	 * 
	 * <p>Zwei Brüche werden miteinander dividiert.</p>
	 * 
	 * @param z Objekt mit den Werten aus Zähler und Nenner
	 */
	public void div(Zahl z) {
		Rational local = (Rational) z;
		p = p * local.q;
		q = q * local.p;
		kuerzen();		
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
		Rational local = new Rational(i);
		div(local);
		kuerzen();
	}

	/**
	 * Kehrwert eines Bruchs.
	 * 
	 * <p>Der Bruch wird in seinen Kehrwert umgestellt, und sichergestellt das der Nenner keine 0 ist.
	 * Den Kehrwert eines Bruchs erhält man durch Vertauschen von Zähler und Nenner.</p>
	 */
	public void kehrwert() {
		int temp = p;
		p = q;
		q = temp;
		assert (q != 0);
	}

	/**
	 * Der Zähler wird negiert.
	 */
	public void switchSign() {
		p = -p;
	}
	
	/**
	 * Bruch kürzen.
	 * 
	 * <p>Der vorhandene Bruch wird gekürzt. In einer eigenen Methode wird der Größte gemeinsame Teiler
	 * ermittelt. Auch negative Brüche sind berücksichtigt.</p>
	 */
	public void kuerzen() {
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

		// Vorzeichen restaurieren
		p = sign * p / teiler;
		q = q / teiler;

	}

	/**
	 * Der Bruch wird geteilt und in Dezimalzahl gewandelt.
	 * 
	 * @return Bruch als Dezimalzahl
	 */
	public double getDoubleWert() {
		return (double) p / (double) q;
	}

	/**
	 * Es wird geprüft, ob der Bruch einer ganzen Zahl entspricht.
	 * 
	 * @return Ergebnis der Prüfung boolischer Wert
	 */
	public boolean isInteger() {
		if (p % q == 0) 
			return true;
		else
			return false;
	}
	
	/**
	 * Der größte gemeinsame Teiler wird ermittelt.
	 * 
	 * @param x erste Zahl
	 * @param y zweite Zahl
	 * @return größte Zahl, durch die beide Zahlen teilbar sind.
	 */
	private int ggt(int x, int y) {

		while (y > 0) {
			int rest = x % y;
			x = y;
			y = rest;
		}
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

		a.add(b);
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

		a.sub(b);
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

		a.div(b);
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

		a.mul(b);
		return a;

	}

	/**
	 * Eingabe zweier Zahlen und Ausgabe als gekürzten Bruch.
	 * 
	 * <p>Die eingegebenen Zahlen sollen einen Bruch ergeben, die erste Zahl ist der Zähler, die zweite 
	 * Zahl der Nenner. Der eingegebene Bruch wird in gekürzter Form wieder ausgegeben.</p>
	 */
	public void eingabe() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Geben Sie den Zaehler ein:");
		int i = sc.nextInt();
		p = i;

		System.out.println("Geben Sie den Nenner ein:");
		i = sc.nextInt();
		q = i;

		sc.close();

		System.out.println("Ihre Eingabe:");
		kuerzen();
		print();

	}

}
