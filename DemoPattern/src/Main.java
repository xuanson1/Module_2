import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String pattern = "(08|09)[0-9]{8}";
        String input = "0814312341";
        boolean x = Pattern.matches(pattern,input);
        System.out.println(x);
    }
}