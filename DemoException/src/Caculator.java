public class Caculator {
    public Caculator(){}

    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b) {
        return a - b;
    }
    public int multiply(int a,int b){
        return a * b;
    }
    public int divide(int a,int b) throws Exception{
        if(b==0){
            throw new Exception("Divide by zero");
        }
        return a / b;
    }
}
