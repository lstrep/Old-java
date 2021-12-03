public class giveDouble{
    public double firstArgument;
    public double secondArgument;

    public giveDouble(String firstArgument, String secondArgument) {
        this.firstArgument = Double.parseDouble(firstArgument);
        this.secondArgument = Double.parseDouble(secondArgument);
    }
}
