import javax.swing.*;
import java.awt.*;

public class setConstraints extends JPanel{
    protected GridBagConstraints gbc;
    public setConstraints(){
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
    }

    protected void setGbc(int gridx, int gridy, int width, int height, int weightx, int weighty){
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1,1,1,1);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = width;
        gbc.gridheight = height;
    }

    public JButton addButton(int gridx, int gridy, int width, int height, String name){
        JButton button = new JButton(name);


        setGbc(gridx, gridy, width, height, 1, 1);

        add(button, gbc);

        return button;
    }
    public JComboBox addCombo(int gridx, int gridy, int width, int height,  String[] name)
    {
        JComboBox cb = new JComboBox(name);
        setGbc(gridx, gridy, width, height, 1, 1);
        add(cb, gbc);

        return cb;
    }
}
