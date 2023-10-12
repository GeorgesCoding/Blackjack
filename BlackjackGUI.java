//layout for Blackjack game
//last modified: 06/14
//layout

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class BlackjackGUI extends JPanel {
  // variable declaration

  private BlackjackGame game;
  private JButton hit = new JButton("Hit");
  private JButton stand = new JButton("Stand");
  private JButton newGame = new JButton("New Game");
  private JLabel score = new JLabel("Score:");
  private JLabel compScore = new JLabel("Computer - " + BlackjackGame.getCompScore());
  private JLabel playerScore = new JLabel("Player - " + BlackjackGame.getPlayerScore());
  private JLabel computer = new JLabel("Computer");
  private JLabel player = new JLabel("Player");
  private JLabel compSuit = new JLabel();
  private JLabel compNum = new JLabel();
  private JLabel compSuit2 = new JLabel();
  private JLabel compNum2 = new JLabel();
  private JLabel playerSuit = new JLabel();
  private JLabel playerNum = new JLabel();
  private JLabel playerSuit2 = new JLabel();
  private JLabel playerNum2 = new JLabel();
  private JLabel deck = new JLabel();
  private JLabel playerSum = new JLabel("Sum:");
  private JLabel compSum = new JLabel("Sum:");
  private JLabel display = new JLabel();
  private JLabel white = new JLabel();
  private JLabel white2 = new JLabel();
  private JLabel white3 = new JLabel();
  private JLabel white4 = new JLabel();
  private LayoutFrame layoutFrame;

  private Card[] dealt;
  // private LinkedList<Card> playerQueue;
  // private LinkedList<Card> compQueue;

  public BlackjackGUI() {
    super();
    this.setUp();
    this.layoutFrame = new LayoutFrame("Blackjack", this);

    // this.update();
  }

  // main testing method
  public static void main(String[] args) throws InterruptedException {
    new BlackjackGUI();

    // BlackjackGame game = new BlackjackGame();
  }

  public void startNew() {
    this.layoutFrame.dispose();
    new BlackjackGUI();
  }

  public void layoutView() {
    // set up buttons and labels
    SpringLayout layout = new SpringLayout();
    this.setLayout(layout);
    this.add(this.hit);
    this.add(this.stand);
    this.add(this.newGame);
    this.add(this.score);
    this.add(this.compScore);
    this.add(this.playerScore);
    //
    this.add(this.playerNum2);
    this.add(this.playerSuit2);
    this.add(this.white4);

    this.add(this.compNum);
    this.add(this.compSuit);
    this.add(this.white3);

    this.add(this.compSuit2);
    this.add(this.compNum2);

    this.add(this.playerNum);
    this.add(this.playerSuit);

    this.add(this.computer);
    this.add(this.player);
    this.add(this.deck);
    this.add(this.playerSum);
    this.add(this.compSum);
    this.add(this.display);
    this.add(this.white);
    this.add(this.white2);

    // add constraints
    hit.setPreferredSize(new Dimension(100, 60));
    hit.setFont(new Font("Arial", Font.BOLD, 22));
    layout.putConstraint(SpringLayout.NORTH, hit, 470, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST, hit, 680, SpringLayout.WEST, this);

    stand.setPreferredSize(new Dimension(100, 60));
    stand.setFont(new Font("Arial", Font.BOLD, 22));
    layout.putConstraint(SpringLayout.NORTH, stand, 380, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST, stand, 680, SpringLayout.WEST, this);

    newGame.setPreferredSize(new Dimension(200, 60));
    newGame.setFont(new Font("Arial", Font.BOLD, 22));
    layout.putConstraint(SpringLayout.NORTH, newGame, 550, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST, newGame, 640, SpringLayout.WEST, this);

    computer.setFont(new Font("Arial", Font.BOLD, 22));
    layout.putConstraint(SpringLayout.WEST, computer, 75, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, computer, 10, SpringLayout.NORTH, this);

    player.setFont(new Font("Arial", Font.BOLD, 22));
    layout.putConstraint(SpringLayout.WEST, player, 375, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, player, 10, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, deck, 600, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, deck, 40, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, playerSuit, 320, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, playerSuit, 80, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, playerNum, 320, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, playerNum, 40, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, playerSuit2, 320, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, playerSuit2, 180, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, playerNum2, 320, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, playerNum2, 140, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, white, 320, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, white, 40, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, white2, 40, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, white2, 40, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, white3, 40, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, white3, 150, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, white4, 320, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, white4, 150, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, compSuit2, 40, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, compSuit2, 80, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, compSuit, 40, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, compSuit, 180, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, compNum2, 40, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, compNum2, 40, SpringLayout.NORTH, this);

    layout.putConstraint(SpringLayout.WEST, compNum, 40, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, compNum, 140, SpringLayout.NORTH, this);

    playerSum.setFont(new Font("Arial", Font.BOLD, 22));
    layout.putConstraint(SpringLayout.WEST, playerSum, 330, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, playerSum, 470, SpringLayout.NORTH, this);

    compSum.setFont(new Font("Arial", Font.BOLD, 22));
    layout.putConstraint(SpringLayout.WEST, compSum, 50, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, compSum, 470, SpringLayout.NORTH, this);

    display.setFont(new Font("Arial", Font.BOLD, 30));
    layout.putConstraint(SpringLayout.WEST, display, 40, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, display, 590, SpringLayout.NORTH, this);

    score.setFont(new Font("Arial", Font.BOLD, 25));
    layout.putConstraint(SpringLayout.WEST, score, 40, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, score, 532, SpringLayout.NORTH, this);

    compScore.setFont(new Font("Arial", Font.BOLD, 25));// hi there
    layout.putConstraint(SpringLayout.WEST, compScore, 170, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, compScore, 532, SpringLayout.NORTH, this);

    playerScore.setFont(new Font("Arial", Font.BOLD, 25)); // hi there
    layout.putConstraint(SpringLayout.WEST, playerScore, 380, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, playerScore, 532, SpringLayout.NORTH, this);

    deck.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("back.jpg"))
        .getImage().getScaledInstance(250, 330, Image.SCALE_SMOOTH)));

    white.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("white.png"))
        .getImage().getScaledInstance(250, 42, Image.SCALE_SMOOTH)));

    white2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("white.png"))
        .getImage().getScaledInstance(250, 42, Image.SCALE_SMOOTH)));

    white3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("white.png"))
        .getImage().getScaledInstance(250, 42, Image.SCALE_SMOOTH)));

    white4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("white.png"))
        .getImage().getScaledInstance(250, 42, Image.SCALE_SMOOTH)));
  }

  public void displayCardComp(Card card1, Card card2) {

    int num1 = card1.getNum();
    String suit1 = card1.getSuit();
    int num2 = card2.getNum();
    String suit2 = card2.getSuit();

    compSuit.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(suit1 + ".png"))
        .getImage().getScaledInstance(250, 280, Image.SCALE_SMOOTH)));

    compNum.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(num1 + ".png"))
        .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

    compSuit2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(suit2 + ".png"))
        .getImage().getScaledInstance(250, 280, Image.SCALE_SMOOTH)));

    compNum2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(num2 + ".png"))
        .getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
  }

  public void displayCardPlayer(Card card1, Card card2) {
    int num1 = card1.getNum();
    String suit1 = card1.getSuit();
    int num2 = card2.getNum();
    String suit2 = card2.getSuit();

    playerSuit.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(suit1 + ".png"))
        .getImage().getScaledInstance(250, 280, Image.SCALE_SMOOTH)));

    playerNum.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(num1 + ".png"))
        .getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH)));

    playerSuit2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(suit2 + ".png"))
        .getImage().getScaledInstance(250, 280, Image.SCALE_SMOOTH)));

    playerNum2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(num2 + ".png"))
        .getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH)));
  }

  public void updateText(int num) {
    switch (num) {
      /*
       * case 1:
       * display.setText("It is now the player's turn");
       * break;
       */

      case 2:
        display.setText("It is now the computer's turn");
        break;

      case 3:
        display.setText("Choose to hit or stand");
        break;

      case 4:
        display.setText("You won!");
        break;

      case 5:
        display.setText("You lost...");
        break;

      /*
       * case 6:
       * display.setText("Play again?");
       * break;
       */
    }
  }

  private void registerControllers() {
    HitController hitController = new HitController(this.game, this.hit);
    this.hit.addActionListener(hitController);

    StandController standController = new StandController(this.game, this.stand);
    this.stand.addActionListener(standController);

    NewGameController newGameController = new NewGameController(this, this.newGame);
    this.newGame.addActionListener(newGameController);
  }

  public void updateScore() {
    playerScore.setText("Player - " + game.getPlayerScore());
    compScore.setText("Computer - " + game.getCompScore());
  }

  public void update() {
    playerSum.setText("Sum:" + String.valueOf((game.getPlayerSum())));
    compSum.setText("Sum:" + String.valueOf((game.getCompSum())));

    if (game.getTurn() == "player") {
      displayCardPlayer(game.getPlayerQueue().poll(), game.getPlayerQueue().peek());
      game.endTurn();
    } else if (game.getTurn() == "comp") {
      this.updateText(2);
      game.compTurn();
      // System.out.println(game.getTurn());
      this.update();
    } else if (game.getTurn() == "end") {
      game.endTurn();
    }
  }

  public void setUp() {
    game = new BlackjackGame();
    game.setGUI(this);
    this.layoutView();
    this.registerControllers();
    this.updateText(3);
    dealt = game.getDealt();
    // playerQueue = game.getPlayerQueue();
    // compQueue = game.getCompQueue();

    playerSum.setText("Sum:" + String.valueOf((game.getPlayerSum())));
    compSum.setText("Sum:" + String.valueOf((game.getCompSum())));

    displayCardPlayer(game.getPlayerQueue().poll(), game.getPlayerQueue().peek());
    displayCardComp(game.getCompQueue().poll(), game.getCompQueue().peek());
    game.endTurn();
  }
}