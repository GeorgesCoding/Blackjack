//Card
//Creates a card object
//Created By: Umar Tahir
//Last Modified: 6/18/22

public class Card {
    // Variable Definition
    private int number; // the card number
    private int suitd; // the card suit

    // Constructor
    public Card(int num, int suit) {
        number = num;
        suitd = suit;
    }

    // sets the suit
    public void setSuit(int suit) {
        suitd = suit;
    }

    // sets the number
    public void setNum(int num) {
        number = num;
    }

    // returns the sting value of the suit
    public String getSuit() {
        String suit;

        if (suitd == 0)
            suit = "Spades";
        else if (suitd == 1)
            suit = "Diamonds";
        else if (suitd == 2)
            suit = "Clubs";
        else
            suit = "Hearts";

        return suit;
    }

    // returns the number
    public int getNum() {
        return number;
    }

    // returns the point value
    public int getPointValue() {
        int val;
        if (this.getNum() < 10)
            val = this.getNum();
        else
            val = 10;

        return val;
    }
} // end of Client class