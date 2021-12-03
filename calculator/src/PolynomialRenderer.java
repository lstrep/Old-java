import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class PolynomialRenderer extends JPanel implements TableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Color color = (Color)value;
        this.setOpaque(true);
        this.setBackground(color);
        return this;
    }
}
