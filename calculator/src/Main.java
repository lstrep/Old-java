import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    JPanel panel = new JPanel();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                ()->{new Main();}
        );

    }

    public Main()
    {
    super("Calculator");
    setSize(880,360);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    LeftPanel lp = new LeftPanel();
    CentrePanel cp = new CentrePanel();

    panel.setLayout(new BorderLayout());
    panel.add(cp,BorderLayout.CENTER);
    panel.add(lp,BorderLayout.WEST);

    this.add(panel);
    setVisible(true);
    }
}
