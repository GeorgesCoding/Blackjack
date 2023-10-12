//StandController
//Controller for the stand button
//Last Modified: 6/19/22

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandController implements ActionListener
{
    //Instance variables
    private BlackjackGame game;
    private JButton stand;

    //constructor
    public StandController(BlackjackGame aGame, JButton aStand)
    {
        this.game = aGame;
        this.stand = aStand;
    }

    //when stand button is clicked
    public void actionPerformed(ActionEvent e)
    {
        if(game.getTurn() == "player") {
            game.stand();
            game.update();
        }
        //System.out.println(game.getTurn());
        //System.out.println(game.getTurn());
    }
}
