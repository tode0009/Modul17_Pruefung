package numbers;

import java.util.Scanner;

public class Rational extends Zahl {

	private int p;
	private int q;

	public Rational() {
		this.p = 1;
		this.q = 1;

	}

	public Rational(int z) {
		this.p = z;
		this.q = 1;
	}

	public Rational(int z, int n) {
		this.p = z;
		this.q = n;
		assert (n != 0);
		kuerzen();
	}
	
	public Rational(Rational other) {
		this(other.zaehler(), other.nenner());
	}

	public void print() {
		System.out.println(p + "/" + q);
	}
	
	@Override
	public String toString() {
		String text = "";
		text = String.valueOf(p) + "/" + String.valueOf(q);
		return text;
	}
	
	public int zaehler() {
		return p;
	}
	
	public int nenner() {
		return q;
	}

	public void add(Zahl z) {
		Rational local = (Rational) z;
		p = p * local.q + local.p * q;
		q = q * local.q;
		kuerzen();

	}

	public void add(int i) {
		Rational local = new Rational(i);
		add(local);
		kuerzen();
	}

	public void sub(Zahl z) {
		Rational local = (Rational) z;
		p = p * local.q - local.p * q;
		q = q * local.q;
		kuerzen();
	}

	public void sub(int i) {
		Rational local = new Rational(i);
		sub(local);
		kuerzen();
	}
	
	public void mul(Zahl z) {
		Rational local = (Rational) z;
		p = p * local.p;
		q = q * local.q;
		kuerzen();
	}

	public void mul(int i) {
		Rational local = new Rational(i);
		mul(local);
		kuerzen();
	}

	public void div(Zahl z) {
		Rational local = (Rational) z;
		p = p * local.q;
		q = q * local.p;
		kuerzen();		
	}

	public void div(int i) {
		Rational local = new Rational(i);
		div(local);
		kuerzen();
	}

	public void kehrwert() {
		int temp = p;
		p = q;
		q = temp;
		assert (q != 0);
	}

	public void switchSign() {
		p = -p;
	}
	
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

	public double getDoubleWert() {
		return (double) p / (double) q;
	}

	public boolean isInteger() {
		if (p % q == 0) 
			return true;
		else
			return false;
	}
	
	private int ggt(int x, int y) {

		while (y > 0) {
			int rest = x % y;
			x = y;
			y = rest;
		}
		return x;
	}

	public Rational add(Rational a, Rational b) {

		a.add(b);
		return a;

	}

	public Rational sub(Rational a, Rational b) {

		a.sub(b);
		return a;

	}

	public Rational div(Rational a, Rational b) {

		a.div(b);
		return a;

	}

	public Rational mul(Rational a, Rational b) {

		a.mul(b);
		return a;

	}

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
