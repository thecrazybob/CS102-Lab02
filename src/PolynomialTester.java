/**
 * Lab01
 * Instructions for Lab01 are in README.md file located in the root directory of Lab01
 * Revisions can be seen on the following GitHub URL: https://github.com/thecrazybob/CS102-lab01
 * Style Guidelines: http://www.cs.bilkent.edu.tr/~adayanik/cs101/practicalwork/styleguidelines.htm
 *
 * @author Mohammed Sohail
 * @version 10/02/2021
 */

public class PolynomialTester {
    public static void main(String[] args) {

        Polynomial emptyConstructor = new Polynomial();
        Polynomial singleConstructor = new Polynomial(5,5);

        double[] coefficients = {2,3,4,-5,6};
        Polynomial arrayConstructor = new Polynomial(coefficients);
        
        System.out.println("emptyConstructor toString(): " + emptyConstructor.toString());
        System.out.println("singleConstructor toString(): " + singleConstructor.toString());
        System.out.println("arrayConstructor toString(): " + arrayConstructor.toString());
        System.out.println("arrayConstructor eval(): " + arrayConstructor.eval(2));
        System.out.println("arrayConstructor eval2(): " + arrayConstructor.eval2(2));

    }

}
