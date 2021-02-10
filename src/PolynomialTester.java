public class PolynomialTester {
    public static void main(String[] args) {

        Polynomial emptyConstructor = new Polynomial();
        Polynomial singleConstructor = new Polynomial(5,5);

        // double[] coefficients = {2,3,4,-5,6};
        double[] coefficients = {2};
        Polynomial arrayConstructor = new Polynomial(coefficients);
        
        System.out.println(emptyConstructor.toString());
        System.out.println(singleConstructor.toString());
        System.out.println(arrayConstructor.toString());
        System.out.println(arrayConstructor.eval(1));

    }

}
