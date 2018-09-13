package numbers;

/**
 * Eine Abstrakte Klasse.
 * 
 * <p> Durch die Klasse wird vorgegeben, dass die 4 Grundrechenarten und die Ausgabe der Zahl
 * implementiert werden müssen. </p>
 * 
 * <P>Letzte Änderung: $Date: 2018/09/10 $</p> 
 * @author $Author: brill $
 * @version $Revision: #1 $
 */

public abstract class Zahl {
	
	 //Jede Zahl sollte mit den 4 Grundrechenarten bearbeitet werden können.	
	 public abstract void add(Zahl a);
	 
	 public abstract void sub(Zahl z);
	 
	 public abstract void mul(Zahl z);
	 
	 public abstract void div(Zahl z);	 
	 
	 //Anzeigen der Zahl sollte auch möglich sein.
	 public abstract void print();
}
