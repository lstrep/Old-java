import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculationsHexa{
    List<String> postFixString;
    CalculationsHexa(String s)
    {
        this.postFixString = getPostFixString(s);


    }
    public String getResult()
    {
        return calculatePostFix(postFixString);
    }
    private int getPreference(char c){
        if(c=='+'|| c=='-') return 1;
        else if(c=='*' || c=='/') return 2;
        else return -1;
    }
    private String calculatePostFix(List<String> postFixList){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<postFixList.size();i++){
            String word = postFixList.get(i);
            if(word.length()==1 && (word.charAt(0)=='+'||word.charAt(0)=='-'||word.charAt(0)=='*'||word.charAt(0)=='/')){
                int  number2 = stack.pop();
                int  number1 = stack.pop();
                if(word.charAt(0)=='+'){
                    int  number = (getDecimal(String.valueOf(number1)))+(getDecimal(String.valueOf(number2)));
                    stack.push(number);
                }else if(word.charAt(0)=='-'){
                    int  number = (getDecimal(String.valueOf(number1)))-(getDecimal(String.valueOf(number2)));
                    stack.push(number);
                }else if(word.charAt(0)=='*'){
                    int number = (getDecimal(String.valueOf(number1)))*(getDecimal(String.valueOf(number2)));
                    stack.push(number);
                }else{
                    int  number = (getDecimal(String.valueOf(number1)))/(getDecimal(String.valueOf(number2)));
                    stack.push(number);
                }
            }else{

                int  number;
                try {
                    number = Integer.parseInt(word);
                }catch(NumberFormatException e)
                {
                    number = getDecimal(word);
                }

                stack.push(number);
            }
        }
        return getHexal(stack.peek());
    }
    public static int getDecimal(String hexnum) {
        String hstring = "0123456789ABCDEF";
        hexnum = hexnum.toUpperCase();
        int num = 0;
        for (int i = 0; i < hexnum.length(); i++)
        {
            char ch = hexnum.charAt(i);
            int n = hstring.indexOf(ch);
            num = 16*num + n;
        }
        return num;
    }
    public static String getHexal(int dec){
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        String hex = "";
        while (dec != 0) {
            int rem = dec % 16;
            hex = hexDigits[rem] + hex;
            dec = dec / 16;
        }
        return hex;
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