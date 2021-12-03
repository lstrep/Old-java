import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cluster {
private final int clusterNumber;
private List<Point> pointList = new ArrayList<>();
private double[] centroid;
private double sumPointsDistances = 0;
private int numberOfAttributes;
private double[] purity;
public Cluster(int clusterNumber, int numberOfAttributes)
{
    this.centroid = new double[numberOfAttributes];
    this.clusterNumber = clusterNumber;
    this.numberOfAttributes = numberOfAttributes;
}

    public String getName()
    {
        List<String> namesOfClusters = new ArrayList<>();
        for(int i=0; i<pointList.size(); i++)
        {
            namesOfClusters.add(pointList.get(i).getClassification());
        }
        Collections.sort(namesOfClusters);

        String value = Stream.of(namesOfClusters.toArray())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .toString();
        String[] data = value.substring(9).substring(0,value.substring(9).length()-1).split("=");
//        for(int i=0 ;i<namesOfClusters.size();i++)
//        {
//            System.out.println(namesOfClusters.get(i));
//        }
        return data[0];
    }
    public void calculatePurity()
    {

        Collection<String> clusterNamesList = new ArrayList<>();
        for(int i=0; i<pointList.size(); i++)
        {
            clusterNamesList.add(pointList.get(i).getClassification());
        }
        List<String> clusterNames = clusterNamesList.stream()
                .distinct()
                .collect(Collectors.toList());
        purity = new double[clusterNames.size()];
        for(int i=0; i<pointList.size(); i++)
        {
            for(int j=0; j<clusterNames.size() ; j++) {
                if (pointList.get(i).getClassification().equals(clusterNames.get(j)))
                {
                    purity[j] ++;
                }
            }
        }
        for(int i=0 ;i<clusterNames.size();i++)
        {
            purity[i]/=pointList.size();
        }
    }
public double[] getPurity()
{
    return purity;
}

public void addPoint(Point point)
{
    pointList.add(point);
}
public List<Point> getPointList()
{
    return pointList;
}

public void setSumPointDistances()
{
    sumPointsDistances = 0;
    for(int i=0;i<pointList.size();i++) {
     sumPointsDistances += calcuteEuclideanSqr(pointList.get(i), centroid);
    }
}
public double getSumPointsDistances()
{
    return sumPointsDistances;
}
public double calcuteEuclideanSqr(Point point1, double[] centroid)
{
    double[] values1 = point1.getValues();
    double sum =0;

    for(int i=0;i<values1.length; i++)
    {
        sum+= Math.pow(values1[i] - centroid[i], 2);
    }

    return sum;
}
public void changeCentroid()
{
    double[] averageValues = new double[numberOfAttributes];
    for(int j=0;j<numberOfAttributes;j++)
    {
    for(int i=0 ;i<pointList.size(); i++)
        {
            averageValues[j] += pointList.get(i).getValues()[j];
        }
        averageValues[j]/=pointList.size();
    }
    centroid = averageValues;
}
public double[] getCentroid()
{
    return centroid;
}

public int getCluster_nr()
{
    return clusterNumber;
}

}
