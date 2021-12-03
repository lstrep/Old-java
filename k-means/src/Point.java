public class Point{
    private double distanceToCentroid;
    private String classification;
    private Cluster cluster;
    private double[] values;
    private String[] parameters;
    private int numberOfAttributes;
    public Point( String[] parameters, Cluster cluster, int numberOfAttributes)
    {
        values = new double[numberOfAttributes];
        this.parameters = parameters;
        this.numberOfAttributes = numberOfAttributes;
        this.cluster = cluster;
        assignValues();
        calculateDistanceToCentroid();
    }
    public String getClassification()
    {
        return classification;
    }
    public void calculateDistanceToCentroid()
    {
        distanceToCentroid = calcuteEuclideanSqr(this,cluster.getCentroid());
    }
    public void pickCluster(Cluster[] clusters)
    {
        double distance = distanceToCentroid;
        Cluster pickedCluster = cluster;
        for(int i=0;i<clusters.length;i++)
        {
            double calculatedDistance = calcuteEuclideanSqr(this,clusters[i].getCentroid());
            if(calculatedDistance<distance)
            {
                pickedCluster = clusters[i];
                distance = calculatedDistance;
                cluster.getPointList().remove(this);
                pickedCluster.getPointList().add(this);
            }
        }
        cluster = pickedCluster;
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

    public double[] getValues()
    {
        return values;
    }

    public void assignValues()
    {
        for(int i = 0; i< numberOfAttributes; i++)
        {
            values[i] = Double.parseDouble(parameters[i]);
        }
        classification = parameters[numberOfAttributes];
    }
    public int compareTo(Point o) {
        return this.getClassification().compareTo(o.getClassification());
    }
}
