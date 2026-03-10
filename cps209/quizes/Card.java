package quizes;

public class Card implements Comparable<Card> {
    // public static void main(String args[]) {
    //     Card c = new Card(12, 'C');
    //     Card wasd = new Card(2, 'S');
    //     Card wwww = new Card(12, 'H');
    //     System.out.println(c.equals(wasd));
    //     System.out.println(c.equals(c));
    //     System.out.println(c.compareTo(wwww));
    //     System.out.println(wasd);
    //     System.out.println(c);
    // }
    final int rank;
    final char suit;

    public Card(int r, char s) {
    rank = r;
    suit = s;
    }

    @Override
    public String toString() {
        // 7 of hearts
        // ace of spades for example
        String suitStr = "";
        String faceStr = "";
        switch (suit) { 
            case 'C'-> suitStr = "Clubs";
            case 'D'-> suitStr = "Diamonds";
            case 'S'-> suitStr = "Spades";
            case 'H'-> suitStr = "Hearts";
        }
        switch (rank) {
            case 14-> faceStr = "Ace"; 
            case 11-> faceStr = "Jack";
            case 12-> faceStr = "Queen";
            case 13-> faceStr = "King";
            default-> faceStr = ""+rank;
        }
        return faceStr+" of "+suitStr;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Card)) return false;
    
        Card other = (Card) obj;

        return (this.rank == other.rank && this.suit == other.suit);
    }
    @Override 
    public int compareTo(Card other) {
        int suitOrd = -1;
        int suitOrd2 = -1;
        switch (this.suit) { //ask if lower case or not
            case 'C'-> suitOrd = 0;
            case 'D'-> suitOrd = 2;
            case 'S'-> suitOrd = 1;
            case 'H'-> suitOrd = 3;
        }
        switch (other.suit) { //ask if lower case or not
            case 'C'-> suitOrd2 = 0;
            case 'D'-> suitOrd2 = 2;
            case 'S'-> suitOrd2 = 1;
            case 'H'-> suitOrd2 = 3;
        }
        if (other.rank > this.rank) return -1;
        if (other.rank < this.rank) return 1;
        return Integer.compare(suitOrd, suitOrd2);
    }
}