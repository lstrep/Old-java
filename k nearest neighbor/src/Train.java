import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Train {
    public List<Cases> cases;
    public static String vector;
    public Train(String vector)
    {
        this.vector=vector;
    }
    public void getTrainCases(String[] allLines)
    {
        cases = new ArrayList<>();
        for(int i=0; i<allLines.length; i++) {
            String[] line = allLines[i].split(",");
            Cases newCase = new Cases(Double.parseDouble(line[0]), Double.parseDouble(line[1]),
                    Double.parseDouble(line[2]), Double.parseDouble(line[3]), line[4]);
            newCase.calculateDistance(vector);
           cases.add(newCase);
        }
        sortArrayList();
    }
    public String chooseSet(int neighbours)
    {
        List<String> mostObject = new ArrayList<>();
        for(int i =0 ;i<neighbours; i++)
        {
            mostObject.add(cases.get(i).getClassification());
        }

        String value = Stream.of(mostObject.toArray())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .toString();

        String[] data = value.substring(9).substring(0,value.substring(9).length()-1).split("=");
        System.out.print("Classified as: " + data[0]);
        return data[0];
    }

    public void sortArrayList()
    {
        Collections.sort(cases);
    }

}
