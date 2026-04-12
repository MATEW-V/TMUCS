package finalspractice;
import java.util.ArrayList;

public class ArtSmuggler extends ArtDealer{
    private ArrayList<String> stash;
    private ArrayList<String> ArtCol;

    public ArtSmuggler() {
        super();
        stash = new ArrayList<String>();

    }
    public boolean hidePainting(String paint) {
        if (ArtCol.contains(paint)) {
            stash.add(paint);
            ArtCol.remove(paint);
        }
        return (ArtCol.contains(paint));
    }
    public String ditchStash() {
        stash.clear();
        return stash.toString();
    }
    public int getTotalStash() {
        return stash.size() + ArtCol.size();
    }
}
