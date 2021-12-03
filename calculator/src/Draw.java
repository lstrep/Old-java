import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    private Equations equations;

    public Draw(Equations polynomialModel){
        this.equations = polynomialModel;
        setOpaque(true);
    }

    @Override
    public void paintComponent(Graphics g){
        g.clearRect(0,0, getWidth(), getHeight());
        g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        g.drawString("[0,0]",getWidth()/2 - 25,getHeight()/2 +17);
        for(Polynomial polynomial : equations.getList()){
            if(polynomial.isChecked)
                polynomial.draw(g, this, 40);
        }
    }

}
