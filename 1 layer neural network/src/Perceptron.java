import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;


public class Perceptron {
    public String className;
    int allLetters;
    double[] letters;
    public double[] weights;
    private Random ra = new Random();
    public double threshold;
    public double alpha = 0.2;
    public Perceptron(Path name) throws FileNotFoundException {
        className = name.getFileName().toString();
        System.out.println("Preceptron " + className + " created");
        weights = ra.doubles(26,0,1).toArray();
        threshold = Math.random();
        assignLetters(name);
    }

    public void assignLetters(Path path) throws FileNotFoundException {
        File directoryPath = new File(path.toString());
        File filesList[] = directoryPath.listFiles();
        Scanner sc = null;
        for(File txtFile : filesList) {
            allLetters = 0;
            letters = new double[26];
            sc= new Scanner(txtFile);
            String input;
            StringBuffer sb = new StringBuffer();
            while (sc.hasNextLine()) {
                input = sc.nextLine();
                input = input.toLowerCase();
                sb.append(input+" ");
            }
            for(int i=0 ; i<sb.length(); i++){
                int asciLetter = sb.charAt(i);
                if(asciLetter >= 97 && asciLetter <= 122)
                {
                    allLetters++;
                    letters[asciLetter-97]++;
                }
            }
            for(int i=0;i<letters.length; i++)
            {
                letters[i]/=allLetters;
            }

            while(calculateNetValue(letters,weights) <= threshold)
            {
                changeWeights();
            }
        }
        normalize(weights);
        sc.close();
    }
    public void changeWeights()
    {
        for(int i=0; i<weights.length; i++) {
            weights[i] += (1 - 0) * letters[i] * alpha;
        }
    }

    public static void normalize(double[] x){
        double result;
        double sum = 0;

        for (int i = 0; i < x.length; i++) {
            sum += x[i]*x[i];
        }
        result = Math.sqrt(sum);

        for (int i = 0; i < x.length; i++) {
            if(x[i] != 0)
                x[i] = x[i]/result;
        }
    }

    public static double calculateNetValue(double[] letters, double[] weights){
        double net_value=0;
        for(int i=0; i<letters.length; i++) {
            net_value += (letters[i]*weights[i]);
        }
        return net_value;
    }



}
