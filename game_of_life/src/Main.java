
import java.util.Scanner;

public class Main {
    public static void initialize(Grid grid)
    {
        for(int i=0;i<20;i++)
        {
            for(int j=0; j<20; j++)
            {
                int value = (int) (Math.random() * 3);
                if(value == 0)
                {
                    grid.setValue(i,j,1);
                }
            }
        }
    }
    public static void showGrid(Grid grid)
    {
        for(int i=0; i< 20; i++)
        {
            for( int j=0; j<20; j++)
            {
                if(grid.getCell(i,j)==0)
                {
                    System.out.print("." + " ");
                }else
                {
                    System.out.print("1" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void nextStep(Grid grid, Grid nextGrid, int[] condDead, int[] condLive)
    {
        for(int i=0; i<20; i++)
        {
            for(int j=0; j<20; j++)
            {
                int neighbours = giveNeighbours(i,j,grid);
                if(grid.getCell(i,j) == 0)
                {
                    for(int n=0; n<8; n++)
                    {
                        if(condDead[n] == 1)
                        {
                            if(neighbours == n+1) {
                                nextGrid.setValue(i, j, 1);
                                break;
                            }
                            nextGrid.setValue(i, j, 0);

                        }
                    }
                }else if(grid.getCell(i,j) == 1)
                {
                    for(int n=0; n<8; n++)
                    {
                        if(condLive[n] == 1)
                        {
                            if(neighbours == n+1) {
                                nextGrid.setValue(i, j, 1);
                                break;
                            }

                            nextGrid.setValue(i, j, 0);
                        }
                    }
                }

            }
        }
    }
    public static void changeGrid(Grid grid, Grid nextGrid) {
        for (int i = 0; i < 20; i++)
        {
            for(int j=0; j<20;j++)
            {
                grid.setValue(i,j,nextGrid.getCell(i,j));
            }
        }
    }
    public static int giveNeighbours(int row, int column, Grid grid)
    {
        int neighbours =0;
        for(int i = row - 1 ; i<= row + 1 ; i++)
        {
            for(int j = column - 1; j <= column + 1; j++)
            {
                if( i >= 0 && i < 20 && j >= 0 && j < 20 && !(i == row && j == column)
                && grid.getCell(i,j) == 1){
                    neighbours ++;
                }

            }
        }
        return neighbours;
    }
    public static void clearScreen()
    {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {

    int[] conditionsLiveCell = new int[8];
    int[] conditionsDeadCell = new int[8];
    System.out.println("Provie conditions for living and dead cells. Type 8 numbers; 0 or 1, where first 0 means negative" +
            " value for living cells having one neighbour etc....");
        System.out.println("For example conditions: \n" +
                "00100000" + "\n10000000\n" + "Mean that all live cells with three live neighbours " +
                "and all dead cells with one live neighbour become alive in the next generation" );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Conditions for living cells: (8 numbers 0 or 1)");
    String condLiveCell = scanner.next();
        System.out.println("Conditions for dead cells: (8 numbers 0 or 1)");
    String condDeadCell = scanner.next();

    if(condDeadCell.length()!= 8 || condLiveCell.length()!=8)
    {
        System.out.println( "Conditions are not correct!!! ");
    }else
    {
    for(int i=0; i< 8; i++)
    {
        conditionsLiveCell[i] = Character.getNumericValue(condLiveCell.charAt(i));
        conditionsDeadCell[i] = Character.getNumericValue(condDeadCell.charAt(i));
    }

        Grid grid = new Grid(20,20);
    Grid gridNext = new Grid(20, 20);
    initialize(grid);
    for(int i=0 ;i<200; i++){
        clearScreen();
        showGrid(grid);
        sleep();
        nextStep(grid, gridNext,conditionsDeadCell, conditionsLiveCell);
        changeGrid(grid, gridNext);
    }
    }
    }
    public static void sleep()
    {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
