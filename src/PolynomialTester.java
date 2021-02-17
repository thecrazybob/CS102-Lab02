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
        
        System.out.println("emptyConstructor toString(): " + emptyConstructor);
        System.out.println("singleConstructor toString(): " + singleConstructor);
        System.out.println("arrayConstructor toString(): " + arrayConstructor);
        System.out.println("arrayConstructor getCoefficient(): " + arrayConstructor.getCoefficient(2));
        System.out.println("arrayConstructor getDegree(): " + arrayConstructor.getDegree());
        System.out.println("arrayConstructor eval(): " + arrayConstructor.eval(2));
        System.out.println("arrayConstructor eval2(): " + arrayConstructor.eval2(2));

        // Lab02 Unit Tests

        System.out.println();

        System.out.println("Lab02 Testing starts here:");

        // P and Q
        Polynomial P = new Polynomial(coefficients);
        System.out.println("P(x) toString(): " + P.toString());
        
        double[] qCoefficients = {2,4,1};
        Polynomial Q = new Polynomial(qCoefficients);
        System.out.println("Q(x) toString(): " + Q.toString());

        System.out.println();

        // add() Test
        Polynomial pqAdd = P.add(Q);
        System.out.println("add() toString(): " + pqAdd);

        // sub() Test
        Polynomial pqSub = P.sub(Q);
        System.out.println("sub() toString(): " + pqSub);

        // mul() Test
        Polynomial pqMul = P.mul(Q);
        System.out.println("mul() toString(): " + pqMul);

        // compose() Test
        double[] pForComposeCoefficients = {3,4,1}; // 2       
        double[] qForComposeCoefficients = {2,1}; // 1
        Polynomial pForCompose = new Polynomial(pForComposeCoefficients);
        Polynomial qForCompose = new Polynomial(qForComposeCoefficients);

        System.out.println("getDegree P toString(): " + pForCompose.getDegree());
        System.out.println("getDegree Q toString(): " + qForCompose.getDegree());

        Polynomial pqCom = pForCompose.compose(qForCompose);
        System.out.println("compose() toString(): " + pqCom);
        
        double[] pForDivCoefficients = {3,4,1,3,0,2};        
        double[] qForDivCoefficients = {2,1};
        Polynomial pForDiv = new Polynomial(pForDivCoefficients);
        Polynomial qForDiv = new Polynomial(qForDivCoefficients);

        Polynomial pqDiv = pForDiv.div(qForDiv);
        System.out.println("div() toString(): " + pqDiv);

    }

}
