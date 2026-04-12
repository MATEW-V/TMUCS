package finalspractice;
import java.util.ArrayList;

public class ArtDealer {
    private ArrayList<String> ArtCol;

    public ArtDealer() {
        ArtCol = new ArrayList<String>();
    }
    public void buyPainting(String paint) {
        ArtCol.add(paint);
    }
    public boolean sellPainting(String paint) {
        if (ArtCol.contains(paint)) {
            ArtCol.remove(paint);
        }
       return (ArtCol.contains(paint));
    }
    public int getSize() {
        return ArtCol.size();
    }
    @Override
    public String toString() {
        return ("Dealer owns: "+ArtCol);
    }
    public static void main(String args[]) {
        ArtDealer w = new ArtDealer();
        w.buyPainting("w");
        w.buyPainting("a");
        w.buyPainting("s");
        w.buyPainting("d");
        System.out.println(w);
    }
}
