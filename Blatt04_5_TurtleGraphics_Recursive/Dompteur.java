 /**
 * Exemplare dieser Klasse veranlassen Turtles dazu,
 * Spuren auf einer Zeichenfläche zu hinterlassen.
 *
 * @author Axel Schmolitzky
 * @version 2025
 */
class Dompteur
{
    /**
     * 'PR1' auf die Zeichenfläche zeichnen.
     */
    public void start()
    {
        Turtle turtle = new Turtle(50, 100);

        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(180);
        
        // Ohne Spur zum nächsten Buchstaben bewegen:
        turtle.hinterlasseKeineSpur();
        turtle.geheZu(100, 100);

        // 'R' zeichnen:
        turtle.hinterlasseSpur();
        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(90);
        turtle.geheVor(30);
        turtle.drehe(180);
        turtle.hinterlasseKeineSpur();
        turtle.geheVor(15);
        turtle.hinterlasseSpur();
        turtle.drehe(60);
        turtle.geheVor(35);

        // Ohne Spur zum nächsten Buchstaben bewegen:
        turtle.hinterlasseKeineSpur();
        turtle.geheZu(170, 100);

        // '1' zeichnen:
        turtle.drehe(-60);
        turtle.hinterlasseSpur();
        turtle.setzeFarbe("rot");
        turtle.drehe(-90);
        turtle.geheVor(60);
        turtle.drehe(-120);
        turtle.geheVor(20);
    }
    public void StartDrawing(int detail, int L)
    {
        Turtle turtle = new Turtle(100,250);
        zeichneKochKurve(detail, L,turtle);
    }
    public void zeichneKochKurve(int detailGrad, int L, Turtle turtle)
    {
        if(detailGrad == 0)
        {
            turtle.geheVor(L);
            return;
        }
        zeichneKochKurve(detailGrad - 1, L/3,turtle);
        turtle.drehe(-60);
        zeichneKochKurve(detailGrad - 1, L/3,turtle);
        turtle.drehe(120);
        zeichneKochKurve(detailGrad - 1, L/3,turtle);
        turtle.drehe(-60);
        zeichneKochKurve(detailGrad - 1, L/3,turtle);
    }
    public void Draw5()
    {
        int d = 5;
        int l = 500;
        Turtle turtle = new Turtle(100,250);
        int X = 100;
        int Y = 50;
        int stepY = 100;
        while(d > 0)
        {
            turtle.hinterlasseKeineSpur();
            Y+= stepY;
            turtle.geheZu(X,Y);
            turtle.hinterlasseSpur();
            
            zeichneKochKurve(d, l,turtle);
            d--;
        }
        
    }
}
