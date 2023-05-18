package Additional;
import Additional.Constants;

public class Punkt {
    private int x;
    private int y;
    public Punkt(int y, int x) {

    this.x = x;
    this.y = y;

    }

    public int getX(){

        return x;

    }
    public int getY(){

        return y;

    }

    public boolean equal(Punkt pkt){

        return (y == pkt.y && x == pkt.x);

    }
    public void change(Punkt pkt){
        y += pkt.y;
        x += pkt.x;
    }
    public Punkt changeNew(Punkt pkt){
        return new Punkt(this.y + pkt.y, this.x + pkt.x);
    }
    public boolean pozaPolem(int wysokosc, int szerokosc){
        return (x < 0 || y < 0 || x >= szerokosc || y >= wysokosc);
    }
    @Override
    public String toString(){
        return ("x: "+(this.x+1)+" y: "+(this.y+1));
    }
}
