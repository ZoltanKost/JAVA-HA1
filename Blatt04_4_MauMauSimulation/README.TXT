In diesem Projekt wird eine Runde von Mau-Mau-Spielern simuliert.

Die "Hauptklasse" ist MauMauRunde, die die anderen Klassen verwendet. Sie soll
im Quelltext untersucht werden. Alle anderen Klassen in diesem Projekt (außer
Spielkarte, Kartenfarbe und Kartenrang) sind bewusst in der Dokumentationssicht, 
weil sie nicht im Quelltext verstanden werden müssen.

Für einen einfachen Einstieg kann man sich interaktiv einen Kartenstapel und eine
Kartenansicht erzeugen, beide per parameterlosem Konstruktor. 

Der Kartenansicht kann dann der gesamte Kartenstapel übergeben werden, 
um alle Karten darin zu visualisieren. Die Größe des Fensters der Kartenansicht
kann flexibel angepasst werden, um die Karten anschaulich darzustellen.
ACHTUNG: Die Kartenansicht holt alle Karten vom Kartenstapel herunter, der 
Stapel ist also hinterher leer.

Alternativ kann auch nur die oberste Karte vom Kartenstapel gezogen werden und
von der Kartenansicht einzeln angezeigt werden.