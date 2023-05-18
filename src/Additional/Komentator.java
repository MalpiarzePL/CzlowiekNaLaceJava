package Additional;

import java.util.Vector;

public class Komentator {
    private Vector<String> komentarze;
    public Komentator(){
        komentarze = new Vector<>();
    }
    public void czysc(){
        komentarze.clear();
    }
    public void dodajKom(String kom){
        komentarze.add(kom);
    }

    public Vector<String> getKomentarze(){
        return komentarze;
    }
}
