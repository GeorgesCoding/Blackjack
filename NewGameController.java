//NewGameController
//Controller for the New Game button
//Last Modified: 6/19/22

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController implements ActionListener
{
    //Instance variables
    private BlackjackGUI gui;
    private JButton newGame;

    //constructor
    public NewGameController(BlackjackGUI aGui, JButton aNewGame)
    {
        this.gui = aGui;
        this.newGame = aNewGame;
    }

    //when stand new game button is clicked
    public void actionPerformed(ActionEvent e)
    {
        this.gui.startNew();
    }
}