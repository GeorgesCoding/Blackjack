//BlackjackGame
//The Model for blackjack
//Last Modified: 6/20/22

import java.util.*;

public class BlackjackGame {
    // Variable Definition
    private BlackjackGUI view; // The GUI
    private ArrayList<Card> deck; // The remaining deck
    private Card[] dealt; // the cards that are dealt at the beginning of the game
    private int playerSum; // the players card sum
    private int compSum; // the computers comp sum
    private String turn; // whos turn it is
    private String winner; // who the winner is
    private static int playerScore = 0; // the player score
    private static int compScore = 0; // the computer score
    private LinkedList<Card> playerQueue = new LinkedList<>(); // the current 2 cards that should be displayed for the
                                                               // player
    private LinkedList<Card> compQueue = new LinkedList<>(); // the current 2 cards that should be displayed for the
                                                             // comp

    // Constructor
    public BlackjackGame() {
        this.deck = makeDeck(); // makes the deck
        // resets variables
        playerSum = 0;
        compSum = 0;
        playerQueue.clear();
        compQueue.clear();

        dealt = this.deal(); // deals the cards
        this.turn = "player"; // sets turn to player
    }

    // returns an array list consisting of 6 shuffled decks of cards
    private static ArrayList<Card> makeDeck() {
        ArrayList<Card> deck = new ArrayList<>();

        for (int i = 0; i < 6; i++) // 6 decks
        {
            for (int j = 0; j < 4; j++) // 4 suits
            {
                for (int k = 1; k < 14; k++) // 13 cards
                {
                    deck.add(new Card(k, j));
                }
            }
        }
        Collections.shuffle(deck); // shuffles deck
        return deck;
    }

    // sets gui
    public void setGUI(BlackjackGUI GUI) {
        view = GUI;
    }

    // adds the given card point value to the overall player sum
    private void addSumPlayer(Card card) {
        if (card.getPointValue() == 1 && this.getPlayerSum() <= 10) // for when card is an ace
            this.playerSum += 11;
        else
            this.playerSum += card.getPointValue();
    }

    // adds the given card point value to the overall player sum
    private void addSumComp(Card card) {
        if (card.getPointValue() == 1 && this.getCompSum() <= 10) // for when card is an ace
            this.compSum += 11;
        else
            this.compSum += card.getPointValue();
    }

    // returns player sum
    public int getPlayerSum() {
        return playerSum;
    }

    // returns comp sum
    public int getCompSum() {
        return compSum;
    }

    /*
     * public String getWinner()
     * {
     * this.findWinner();
     * return this.winner;
     * }
     */

    // finds the winner and sets winner to the winner
    private void findWinner() {
        if (this.getTurn() == "player") {
            if (this.playerSum == 21 && this.compSum != 21) // when player sum is 21 they win more////////
                this.winner = "player";
            // else if(this.playerSum < 21)
            // {}
            else if (this.playerSum > 21 || this.compSum == 21) // when player sum is greater than 21 or the comp sum is
                                                                // 21 the comp wins
                this.winner = "comp";
        }
        /*
         * else if(this.getTurn() == "comp")
         * {
         * if(this.compSum == 21)
         * this.winner = "comp"; //would only come here if the player got less than 21
         * // else if(this.compSum < 21)
         * // this.winner = "none"; //will find winner next turn ("end" turn)
         * else if(this.compSum > 21)
         * this.winner = "player";
         * }
         */
        else if (this.getTurn() == "end") {
            /*
             * if(this.playerSum <= this.compSum && this.compSum <= 21)
             * this.winner = "comp";
             * else if(this.playerSum <= this.compSum && this.compSum > 21)
             * this.winner = "player";
             * else if(this.playerSum > this.compSum && this.playerSum <= 21)
             * this.winner = "player";
             * else if(this.playerSum > this.compSum && this.playerSum > 21)
             * this.winner = "comp";
             * //this one does basically the same thing as the one bellow but is a bit
             * redundant
             */

            // checks for the winner with all possible states reachable during the end turn
            if (this.compSum > 21 || this.playerSum > this.compSum)
                this.winner = "player";
            else if (this.compSum == 21 || this.compSum >= this.playerSum)
                this.winner = "comp";
        }
    }

    // returns whos turn it is
    public String getTurn() {
        return this.turn;
    }

    // moves to the next turn
    public void nextTurn() {
        if (this.turn == "player")
            this.turn = "comp";
        else if (this.turn == "comp")
            this.turn = "end";
        // else
        // if turn = "end"
    }

    // deals 2 cards from the deck to the player and the computer and retuns the
    // result
    public Card[] deal() {
        Card p1 = deck.get(0); // sets p1 to the first card in the deck
        deck.remove(0); // removes that card from the deck
        playerQueue.add(p1); // adds p1 to the display queue
        addSumPlayer(p1); // adds the point value of p1 to the player sum
        Card p2 = deck.get(0);
        deck.remove(0);
        playerQueue.add(p2);
        addSumPlayer(p2);

        Card d1 = deck.get(0);
        deck.remove(0);
        compQueue.add(d1);
        addSumComp(d1);
        Card d2 = deck.get(0);
        deck.remove(0);
        compQueue.add(d2);
        addSumComp(d2);

        return new Card[] { p1, p2, d1, d2 };
    }

    // returns the dealt cards
    public Card[] getDealt() {
        return dealt;
    }

    // removes a card from the deck and places it in the player or dealers hand
    // (returns the card for testing purposes)
    public Card hit() {
        Card card = deck.get(0);
        deck.remove(0);
        if (this.getTurn() == "player") {
            addSumPlayer(card);
            playerQueue.add(card);
            //
        } else if (this.getTurn() == "comp") {
            addSumComp(card);
            compQueue.add(card);
        }
        return card;
    }

    // when the stand button is clicked (redundant but helps me keep track of
    // everything)
    public void stand() {
        this.nextTurn();
    }

    // returns the current deck
    public ArrayList<Card> getDeck() {
        return deck;
    }

    // returns the players queue of cards to be displayed
    public LinkedList<Card> getPlayerQueue() {
        return playerQueue;
    }

    // returns the comps queue of cards to be displayed
    public LinkedList<Card> getCompQueue() {
        return compQueue;
    }

    // when it is the computers turn
    public void compTurn() {
        while (this.getCompSum() < 17) {
            this.hit();
            view.displayCardComp(this.getCompQueue().poll(), this.getCompQueue().peek());
            // System.out.println(this.hit().getPointValue());
        } // while the comp sum is less than 17 hits and displays the next cards to be
          // shown
        this.nextTurn();
    }

    // if theres a winner ends the turn, displays who and then updates the score
    public void endTurn()// change name to something with winner
    {
        this.findWinner();

        if (this.winner == "player") {
            this.turn = "end";
            view.updateText(4);
            playerScore++; // fix
            // System.out.println(1);
        } else if (this.winner == "comp") {
            this.turn = "end";
            view.updateText(5);
            compScore++; // fix
            // System.out.println(2);
        }
        view.updateScore();
    }

    // returns player score
    public static int getPlayerScore() {
        return playerScore;
    }

    // returns comp score
    public static int getCompScore() {
        return compScore;
    }

    // returns the view
    public BlackjackGUI getView() {
        return view;
    }

    // updates
    public void update() {
        view.update();
    }

    /*
     * //used to test the deck array
     * public static void main(String[] args)
     * {
     * ArrayList<Card> deckl = makeDeck();
     * 
     * for(int i = 0; i < deckl.size(); i++)
     * {
     * System.out.println(deckl.get(i).getSuit() + " " + deckl.get(i).getNum());
     * System.out.println(deckl.get(i).getPointValue());
     * }
     * System.out.println(deckl.size());
     * }//
     */
    /*
     * public static void main(String[] args)
     * {
     * BlackjackGame game = new BlackjackGame();
     * ArrayList<Card> deckl = game.getDeck();
     * 
     * 
     * for(int i = 0; i < deckl.size(); i++)
     * {
     * System.out.println(deckl.get(i).getSuit() + " " + deckl.get(i).getNum());
     * }
     * 
     * System.out.println();
     * System.out.println();
     * 
     * Card[] c = game.getDealt();
     * System.out.println(c[0].getSuit());
     * System.out.println(c[1].getSuit());
     * System.out.println(c[2].getSuit());
     * System.out.println(c[3].getSuit());
     * }//
     */
} // end of BlackjackGame