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
    
    public void zeichne_N_Eck(int n, int seitenLange, Turtle turtle)
    {
        if(n < 3) return;
        if(turtle == null) turtle = new Turtle();
        float angle = 360 / n;
        while(n > 0)
        {
            turtle.drehe(angle);
            turtle.geheVor(seitenLange);
            n--;
        }
    }
    public void zeichne_N_Eck(int n, int seitenLange, String farbe, int posX, int posY)
    {
        if(n < 3) return;
        Turtle turtle = new Turtle(posX, posY);
        turtle.setzeFarbe(farbe);
        zeichne_N_Eck(n,seitenLange,turtle);
    }
    public void zeichneRosette(int n, int size, int angle)
    {
        Turtle turtle = new Turtle();
        double posX = turtle.gibX();
        double posY = turtle.gibY();
        int count = 360 / angle;
        while(count > 0)
        {
            float drawAngle = count * angle;
            turtle.hinterlasseKeineSpur();
            turtle.geheZu(posX,posY);
            turtle.setzeRichtung(drawAngle);
            turtle.geheVor(size / 2);
            turtle.hinterlasseSpur();
            zeichne_N_Eck(n,size,turtle);
            count--;
        }
    }
    
    public void DrawStuff()
    {
        Turtle turtle = new Turtle();
        boolean spur = true;
        while(true)
        {
            spur = !spur;
            if(!spur) turtle.hinterlasseKeineSpur();
            else turtle.hinterlasseSpur();
            turtle.setzeFarbe((int)(Math.random() * 13));
            double targetX = 0;
            double targetY = 0;
            targetX = Math.random() * 500;
            targetY = Math.random() * 500;
            turtle.geheZu(targetX,targetY);
        }
    }
}
