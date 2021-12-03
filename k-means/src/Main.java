import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static String path = "irisData.txt";
    private static Random random = new Random();

    public static void main(String[] args) throws IOException {

        String[] cases = Files.readAllLines(Paths.get(path)).toArray(new String[0]);
        Scanner scan = new Scanner(System.in);
        //System.out.println("Provide nr of clusters: ");
        int numberOfClusters = 3; //scan.nextInt();
        //System.out.println("Provide nr of attributes: ");
        int numberOfAttributes = (int)cases[0].chars().filter(ch -> ch == ',').count(); //scan.nextInt();
        scan.close();
        Cluster[] clusters = new Cluster[numberOfClusters];
        Point[] points = new Point[cases.length];

        for (int j = 0; j < numberOfClusters; j++) {
            clusters[j] = new Cluster(j + 1, numberOfAttributes);
            // clusters[j].setCentroid();
        }

            for (int i = 0; i < cases.length; i++) {
                int clusterNumber = random.nextInt(numberOfClusters);
                String[] single_case = cases[i].split(",");
                Point point = new Point(single_case, clusters[clusterNumber], numberOfAttributes);
                clusters[clusterNumber].addPoint(point);
                points[i] = point;
            }

            for(int p = 0 ; p<200; p++) {
                // System.out.println("Iteration nr: " + (p+1));
                for (int j = 0; j < numberOfClusters; j++) {
                    clusters[j].changeCentroid();
                    clusters[j].setSumPointDistances();
                }
                for (int i = 0; i < numberOfClusters; i++) {
                    clusters[i].calculatePurity();
                    double[] purity = clusters[i].getPurity();
                    if(p==199) {
                        System.out.println("Cluster number: " + clusters[i].getName());
                        System.out.println("Sum points distances: " + clusters[i].getSumPointsDistances());
                        System.out.println("Purity of values: ");
                        for (int j = 0; j < purity.length; j++) {
                            System.out.print((int) (purity[j] * 100) + " %");
                            System.out.println(" ");
                        }
                        System.out.println();
                        System.out.println();
                    }
                }

                for (int i = 0; i < points.length; i++) {
                    points[i].pickCluster(clusters);
                }
                for (int i = 0; i < clusters.length; i++) {
                    clusters[i].changeCentroid();
                }
            }


    }
}