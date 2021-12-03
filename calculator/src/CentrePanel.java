import javax.swing.*;
import java.awt.*;

public class CentrePanel extends setConstraints {

    private  Draw graph;
    private JTable table;
    private Equations EquationsTable;
    private Color color= Color.BLUE;
    public  CentrePanel() {
        generateTable();
        generateGraph();
        generateLayout();
    }

    public void generateGraph(){
        setGbc(0,0,4,2, 20, 10);
        graph = new Draw(EquationsTable);
        EquationsTable.setGraph(graph);

        add(graph, gbc);
    }

    public void generateTable(){
        EquationsTable = new Equations();
        table = new JTable(EquationsTable);

        table.setDefaultRenderer(Color.class, new PolynomialRenderer());

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(200, Integer.MAX_VALUE));

        setGbc(4, 0, 3, 1, 1, 5);
        add(scroll, gbc);
    }

    public void generateLayout(){
        String[] name ={
                "BLUE", "BLACK", "GREEN", "YELLOW", "RED"
        };
        JComboBox addCb = addCombo(4,1,1,1,name);
        addCb.addItemListener((e) -> {
            String x = (String)addCb.getSelectedItem();
            switch(x)
            {
                case "BLUE": color = Color.BLUE; repaint();break;
                case "RED": color = Color.RED; repaint();break;
                case "GREEN": color = Color.GREEN; repaint();break;
                case "YELLOW": color = Color. YELLOW;repaint(); break;
                case "BLACK": color = Color.BLACK; repaint(); break;
            }
        } );

        JButton addBtn = addButton(5,1,1,1,"Add");
        addBtn.addActionListener((e) -> {
            String equation = JOptionPane.showInputDialog("Type equation:");
            if(Polynomial.verifyPoly(equation)){
                EquationsTable.add(new Polynomial(true, equation, color));
                EquationsTable.fireTableDataChanged();
                repaint();
            }
        });

        JButton removeBtn = addButton(6,1,1,1,"Remove");
        removeBtn.addActionListener((e) -> {
            EquationsTable.remove(table.getSelectedRow());
            EquationsTable.fireTableDataChanged();
            repaint();
        } );




    }
}
