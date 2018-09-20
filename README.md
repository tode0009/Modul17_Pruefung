# Zahlen
Ein Beispiel für ein Java-Projekt für die Lehrveranstaltung 
Software-Management Grundlagen im Studiengang IT-Analyst. 
Dieses Repository ist der Ausgangspunkt für die Prüfungsleistung und 
wird von den Studierenden in einem eigenen repo weiter bearbeitet.

## Files
Das Repository enthält aktuell die folgenden Klassen:
- Zahl.java: eine Basisklasse für die Grundschularithmetik mit Zahlen
- Rational.java: eine Klasse für rationale Zahlen, realisiert als Bruch aus ganzen Zahlen. Abgeleitet von  Zahl.java.
- App.java: kleines Beispiel mit den Grundrechenarten und Ausgaben zum Verifizieren.
- RationalTest.java: JUnit-Test. Sie können diese Datei ignorieren, wenn Sie keine Unit-Tests durchführen möchten.
- Bruch.java: kleines Programm, hier werden Eingaben für einen Bruch getätigt, dieser Bruch wird wenn möglich gekürzt und ausgegeben.

## Build-Werkzeug
- Projekt wurde in ein Maven Projekt umstrukturiert.
- pom.xml: sind alle eingebundenen Plugins und Dependencies ersichtlich.

## Dokumentation
- Eine Dokumentation mit Doxygen wird erstellt.
- wird mit Doxyfile Konfiguration zusammengestellt

## Logging
- Log4J wurde als Werkzeug für das Logging in das Projekt eingebunden.

## Release
- Release1: Klasse Bruch.java wurde erzeugt.
- Release2: Dokumentation wurde erstellt.
- Release3: Logging wurde integriert.
- Release4: Projekt wurde in ein Maven-Projekt umstrukturiert.


