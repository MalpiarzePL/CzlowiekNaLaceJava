package Additional;

import java.util.Vector;

public class Komentator {
    public Vector<String> komentarze;
    public Komentator(){
        komentarze = new Vector<String>();
    }
    public void czysc(){
        komentarze.clear();
    }
    public void dodajKom(String kom){
        komentarze.add(kom);
    }
}
