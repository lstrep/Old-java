import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Knn {
    private static String pathTrain = "train.txt";
    private static String pathTest = "test.txt";
    private static int neighbours;
    private static Train trainSet;
    private static double accuracy;
    public static void main(String[] args) throws IOException {
        String[] cases = Files.readAllLines(Paths.get(pathTrain)).toArray(new String[0]);
        Scanner scan = new Scanner(System.in);

        System.out.println("Provide nr of neighbours: ");
        neighbours = scan.nextInt();
        System.out.println("Option (type 1 to add your own vector or 2 to use test data): ");
        int option = scan.nextInt();
        Scanner scan2 = new Scanner(System.in);
        if(option == 1) {
            System.out.println("vector (example format: 4.7,3.2,1.6,0.2) :");
            String vector = scan2.nextLine();
            trainSet = new Train(vector);
            trainSet.getTrainCases(cases);
            trainSet.chooseSet(neighbours);
        }else if(option != 1){
        String[] test = Files.readAllLines(Paths.get(pathTest)).toArray(new String[0]);
        for(int i=0; i<test.length;i++) {
            String[] segments = test[i].split(",");
            trainSet = new Train(segments[0]+","+segments[1]+","+segments[2]+","+segments[3]);
            trainSet.getTrainCases(cases);
            if(trainSet.chooseSet(neighbours).equals(segments[4])){
                accuracy++;
            }
            System.out.println(" Should be classified as: " + segments[4]);
        }
            accuracy/=test.length;
            System.out.println("Accuracy: " + (int)(accuracy*100) + "%");
        }


        scan.close();
    }

}
