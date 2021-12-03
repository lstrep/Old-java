import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Equations extends AbstractTableModel {
    private static int COLUMNS = 3;
    private static String[] names = {"Draw", "Equation", "Color"};

    private List<Polynomial> list;
    private Draw g;

    public Equations(){
        list = new ArrayList<>();
    }

    public void setGraph(Draw g){
        this.g = g;
    }

    public void add(Polynomial p){
        list.add(p);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Polynomial p = list.get(rowIndex);
        switch (columnIndex){
            case 0:
                return p.isChecked;
            case 1:
                return p.polynomial;
            case 2:
                return p.color;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 2){

            return Color.class;
        }

        if(columnIndex == 0){

            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0)
            return true;
        return super.isCellEditable(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Polynomial p = list.get(rowIndex);

        switch (columnIndex){
            case 0:
                p.isChecked = (Boolean)aValue;
                break;
            case 1:
                p.polynomial = (String)aValue;
                break;
            case 2:
                p.color = (Color)aValue;
                break;
        }

        g.repaint();
    }

    public List<Polynomial> getList(){
        return list;
    }

    public void remove(int row){

            list.remove(row);
    }

}
