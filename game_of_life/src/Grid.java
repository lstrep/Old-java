public class Grid {

    private int rows;
    private int columns;
    private int[][] grid;

    public Grid(int rows, int columns)
    {
    this.rows = rows;
    this.columns = columns;
    grid = new int[rows][columns];
    }


    public int getCell(int row, int column)
    {
        return grid[row][column];
    }

    public void setValue(int row, int column, int value)
    {
        grid[row][column] = value;
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public String toString()
    {
        String grid = "";
        for(int i=0;i<rows;i++)
        {
            for(int j=0; j<columns; j++)
            {
                grid += String.valueOf(this.grid[i][j]);
            }
            grid += "\n";
        }
        return "";
    }
}
