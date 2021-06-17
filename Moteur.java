public class Moteur {
    protected int speed;
    protected boolean etat = false;
    protected Voiture chassis;

    public void start() {
        this.etat = true;
    }
    public void stop() {
        this.etat = false;
    }
}
