/**
 * Lab02
 * Instructions for Lab02 are in CS102_Lab02.pdf file located in the root directory of Lab02
 * Revisions can be seen on the following GitHub URL: https://github.com/thecrazybob/CS102-lab02
 * Style Guidelines: http://www.cs.bilkent.edu.tr/~adayanik/cs101/practicalwork/styleguidelines.htm
 *
 * @author Mohammed Sohail
 * @version 10/02/2021
 */

public class PolynomialTester {
    public static void main(String[] args) {

        Polynomial emptyConstructor = new Polynomial();
        Polynomial singleConstructor = new Polynomial(5,5);

        double[] coefficients = {3,4,5,2};
        Polynomial arrayConstructor = new Polynomial(coefficients);
        
        System.out.println("emptyConstructor toString(): " + emptyConstructor.toString());
        System.out.println("singleConstructor toString(): " + singleConstructor.toString());
        System.out.println("arrayConstructor toString(): " + arrayConstructor.toString());
        System.out.println("arrayConstructor eval(): " + arrayConstructor.getCoefficient(2));
        System.out.println("arrayConstructor eval(): " + arrayConstructor.getDegree());
        System.out.println("arrayConstructor eval(): " + arrayConstructor.eval(2));
        System.out.println("arrayConstructor eval2(): " + arrayConstructor.eval2(2));

        // Lab02 Unit Tests

        System.out.println();
        
        System.out.println("Lab02 Testing starts here:");
        // 1. Test the add() method
        Polynomial P = new Polynomial(coefficients);
        System.out.println("P(x) toString(): " + P.toString());
        
        double[] qCoefficients = {2,4,1};
        Polynomial Q = new Polynomial(qCoefficients);
        System.out.println("Q(x) toString(): " + Q.toString());

        System.out.println();

        Polynomial PQ = P.add(Q);
        System.out.println("add() toString(): " + PQ.toString());
    }

}
