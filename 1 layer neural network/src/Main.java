import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String pathTrain ="C:\\Users\\ŁukaszStrep\\Desktop\\PJATK\\NAI\\Task03 -neural\\LanguagesTrain";
    private static final String pathTest ="C:\\Users\\ŁukaszStrep\\Desktop\\PJATK\\NAI\\Task03 -neural\\LanguagesTest";
    public static void main(String[] args) throws FileNotFoundException {

        List<Path> directoriesPathsTrain = getDircetoriesPaths(pathTrain);
        List<Path> directoriesPathsTest = getDircetoriesPaths(pathTest);

        List<Perceptron> perceptrons = new ArrayList<>();
        for (Path path : directoriesPathsTrain) {
            perceptrons.add(new Perceptron(path));
        }

        for(Path path : directoriesPathsTest)
        {

            File directoryPath = new File(path.toString());
            File filesList[] = directoryPath.listFiles();
            Scanner sc = null;
            for(File txtFile : filesList) {
                int allLetters = 0;
                double[] letters = new double[26];
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
                System.out.println("Result should be: " + path.getFileName().toString());
                for(Perceptron perceptron : perceptrons) {
                    System.out.println("Perceptron: " + perceptron.className + " " + calculateNetValue(letters,perceptron.weights));
                }
            }

            sc.close();
        }


    }
    public static double calculateNetValue(double[] letters, double[] weights){
        double net_value=0;
        for(int i=0; i<letters.length; i++) {
            net_value += (letters[i]*weights[i]);
        }
        return net_value;
    }
        public static List<Path> getDircetoriesPaths(String path)
        {
            List<Path> paths = new ArrayList<>();
            Path dir = Paths.get(path);
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path file : stream) {
                    paths.add(file);
                }
            } catch (IOException | DirectoryIteratorException x) {
            }
            return paths;
        }
    }

