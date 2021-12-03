import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculationsBinary{
    List<String> postFixString;
    CalculationsBinary(String s)
    {
        this.postFixString = getPostFixString(s);


    }
    public int getResult()
    {
        return calculatePostFix(postFixString);
    }
    private int getPreference(char c){
        if(c=='+'|| c=='-') return 1;
        else if(c=='*' || c=='/') return 2;
        else return -1;
    }
    private int calculatePostFix(List<String> postFixList){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<postFixList.size();i++){
            String word = postFixList.get(i);
            if(word.length()==1 && (word.charAt(0)=='+'||word.charAt(0)=='-'||word.charAt(0)=='*'||word.charAt(0)=='/')){
                int  number2 = stack.pop();
                int  number1 = stack.pop();
                if(word.charAt(0)=='+'){
                    int  number = (getDecimal(number1))+(getDecimal(number2));
                    stack.push(number);
                }else if(word.charAt(0)=='-'){
                    int  number = getDecimal(number1)-getDecimal(number2);
                    stack.push(number);
                }else if(word.charAt(0)=='*'){
                    int number = getDecimal(number1)*getDecimal(number2);
                    stack.push(number);
                }else{
                    int  number = getDecimal(number1)/getDecimal(number2);
                    stack.push(number);
                }
            }else{
                int  number = Integer.parseInt(word);
                stack.push(number);
            }
        }
        return getBinary(stack.peek());
    }
    public static int getBinary(int decimal)
    {
        String x ="";
        int a;
        while(decimal > 0)
        {
            a = decimal % 2;
            x = a + "" + x;
            decimal = decimal / 2;
        }
        return Integer.parseInt(x);
    }
    public static int getDecimal(int binary){
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int  temp = binary%10;
                decimal += temp*Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }
    private List<String> getPostFixString(String s){
        Stack<Character> stack = new Stack<>();
        List<String> postFixList = new ArrayList<>();
        boolean flag = false;

        for(int i=0;i<s.length();i++){
            char word = s.charAt(i);
            if(word==' '){
                continue;
            }
            if(word=='('){
                stack.push(word);
                flag = false;
            }else if(word==')'){
                flag = false;
                while(!stack.isEmpty()){
                    if(stack.peek()=='('){
                        stack.pop();
                        break;
                    }else{
                        postFixList.add(stack.pop()+"");
                    }
                }
            }else if(word=='+' || word=='-' || word=='*' || word=='/'){
                flag = false;
                if(stack.isEmpty()){
                    stack.push(word);
                }
                else{
                    while(!stack.isEmpty() && getPreference(stack.peek())>=getPreference(word)){
                        postFixList.add(stack.pop()+"");
                    }
                    stack.push(word);
                }
            }else{
                if(flag){
                    String lastNumber = postFixList.get(postFixList.size()-1);
                    lastNumber+=word;
                    postFixList.set(postFixList.size()-1, lastNumber);
                }else
                    postFixList.add(word+"");
                flag = true;
            }
        }
        while(!stack.isEmpty()){
            postFixList.add(stack.pop()+"");
        }
        return postFixList;
    }
}