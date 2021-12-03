public class Cases implements Comparable<Cases>{
    private double value1;
    private double value2;
    private double value3;
    private double value4;
    private double distance;
    private String classification;
    public Cases( double IL, double IW, double pL, double pw, String classification)
    {
        value1=IL;
        value2=IW;
        value3=pL;
        value4=pw;
        this.classification = classification;
    }
    
    public void calculateDistance(String vector)
    {
        String[] vectors = vector.split(",");
        double val1 = Double.parseDouble(vectors[0]);
        double val2 = Double.parseDouble(vectors[1]);
        double val3 = Double.parseDouble(vectors[2]);
        double val4 = Double.parseDouble(vectors[3]);
        distance = Math.sqrt(Math.pow(val1 - value1,2) + Math.pow(val2 - value2,2) +
                Math.pow(val3 - value3,2) + Math.pow(val4 - value4,2));
    }

    public String toString() {
        return value1 + " " + value2 + " " + value3 + " " + value4 + " " + classification + " distance: " + distance;
    }

    public String getClassification()
    {
        return classification;
    }
    @Override
    public int compareTo(Cases o) {
            int compare = Double.compare(distance, o.distance);
            return compare;
    }
}
