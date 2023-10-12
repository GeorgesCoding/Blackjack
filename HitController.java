//StandController
//Controller for the Hit button
//Last Modified: 6/19/22

import javax.swing.*;
import java.awt.event.*;

public class HitController implements ActionListener
{
    //Instance variables
    private BlackjackGame game;
    private JButton hit;

    //constructor
    public HitController(BlackjackGame aGame, JButton aHit)
    {
        this.game = aGame;
        this.hit = aHit;
    }

    //when stand hit is clicked
    public void actionPerformed(ActionEvent e)
    {
        if(game.getTurn() == "player") {
            game.hit();
            /*System.out.println(game.getPlayerQueue().size());
            System.out.println(game.getCompQueue().size());
            System.out.println();
            System.out.println();*/
            game.update();
        }
    }
}
