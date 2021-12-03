import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    public Boolean isChecked;
    public String polynomial;
    public Color color;

    private Polygon polygon;
    private List<giveDouble> powers;
    private String letter;


    public Polynomial(Boolean isChecked, String polynomial, Color color){
        this.isChecked = isChecked;
        this.polynomial = polynomial;
        this.powers = new ArrayList<>();
        this.polygon = new Polygon();
        this.color = color;
        generatePowerList();
    }

    public void generatePowerList(){
        letter = "";
        Pattern letterPattern = Pattern.compile("[a-z]");
        Matcher letterMatcher = letterPattern.matcher(polynomial);

        if(letterMatcher.find()) {
            letter = letterMatcher.group();
    }

        String number = "(-?\\d+(\\.\\d+)?)";
        String power = "([\\+-]?" + number + "?" + letter + "(\\^" + number + ")?)";
        String withoutPower = "([\\+-]?" + number + "?" + letter +")";
        String numbers = "([\\+-]?"+number+")";

        String finder = power + "|" + withoutPower + "|" + numbers;

        Pattern p = Pattern.compile(finder);
        Matcher m = p.matcher(polynomial);

        while(m.find()){
//            System.out.println(m.group());
            createPower(m.group());
        }
    }

    public void createPower(String str){
        if(str.equals(""))
            return;

        if(str.contains(letter + "^")){
            String[] tmp = str.split(letter+"\\^");
            if(tmp[0].equals("") || tmp[0].equals("+"))
                powers.add(new giveDouble("1", tmp[1]));
            else if(tmp[0].equals("-"))
                powers.add(new giveDouble("-1", tmp[1]));
            else
                powers.add(new giveDouble(tmp[0], tmp[1]));

        }else if(str.contains(letter) && !letter.equals("")){
            String[] tmp = str.split(letter);
            if(tmp.length == 0 || tmp[0].equals("+"))
                powers.add(new giveDouble("1", "1"));
            else if(tmp[0].equals("-"))
                powers.add(new giveDouble("-1", "1"));
            else
                powers.add(new giveDouble(tmp[0], "1"));

        }else{
            powers.add(new giveDouble(str, "0"));
        }
    }

    public void generatePolygon(int width, int height, double n){
        int[] xPoints = new int[(int)n];
        int[] yPoints = new int[(int)n];

        double tmp = width / n;
        double y, x = 0;

        for(int i = 0; i < n; i++){
            y = 0;

            for(giveDouble p : powers){
                y += p.firstArgument * Math.pow(i - n/2, p.secondArgument);
            }

            xPoints[i] = (int)x;
            yPoints[i] = (int)(height/2 - (y * tmp));

            x += tmp;
        }

        this.polygon = new Polygon(xPoints, yPoints, (int)n);
    }

    public void draw(Graphics g, JPanel panel, double n){
        generatePolygon(panel.getWidth(), panel.getHeight(), n);
        g.setColor(color);

        for(int i = 0; i < polygon.npoints - 1; i++){
            g.drawLine(polygon.xpoints[i], polygon.ypoints[i],polygon.xpoints[i+1], polygon.ypoints[i+1]);
        }
    }
    public static boolean verifyPoly(String test){
        if(test == null)
            return false;

        String letter = "";

        Pattern letterPattern = Pattern.compile("[a-z]");
        Matcher letterMatcher = letterPattern.matcher(test);

        if(letterMatcher.find()) {
            letter = letterMatcher.group();
        }

        String number = "(-?\\d+(\\.\\d+)?)";
        String powerBase = "(-?(\\d+(\\.\\d+)?)?)?" + letter + "(\\^" + number + ")?";
        String power = "([\\+-]" + number + "?" + letter + "(\\^" + number + ")?)";
        String numbers = "([\\+-]"+number+")";
        String polynomial = "";

        if(!letter.equals("")){
            polynomial = "(" + powerBase +"("+ power + "|" + numbers+")*" + ")|" + number;
        }else{
            polynomial = number + number + "*";
        }
        Pattern p = Pattern.compile(polynomial);
        Matcher m = p.matcher(test);

        return m.matches();
    }
}
