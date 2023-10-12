import javax.swing.*;

public class LayoutFrame extends JFrame
{
    private static int xPos = 450;
    private static int yPos = 100;
    private static final int OFFSET = 0;

    public LayoutFrame(String title, JPanel contents)
    {  super(title);
        this.setContentPane(contents);
        this.setSize(900, 700);
        this.setLocation(xPos, yPos);
        xPos += OFFSET;
        yPos += OFFSET;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}