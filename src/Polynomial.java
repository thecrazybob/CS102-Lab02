/**
 * Lab01
 * Instructions for Lab01 are in README.md file located in the root directory of Lab01
 * Revisions can be seen on the following GitHub URL: https://github.com/thecrazybob/CS102-lab01
 * Style Guidelines: http://www.cs.bilkent.edu.tr/~adayanik/cs101/practicalwork/styleguidelines.htm
 *
 * @author Mohammed Sohail
 * @version 10/02/2021
 */

public class Polynomial {
    
    // properties
    private double[] coefficients;
    private int[] powers;
    private String polynomial;

    // default constructor
    public Polynomial() {
        this.coefficients = new double[1]; 
        this.powers = new int[1];

        this.coefficients[0] = 0;
        this.powers[0] = 0;
    } 

    // first parametized constructor
    public Polynomial(int d, double c) {

        this.coefficients = new double[1]; 
        this.powers = new int[1];

        this.coefficients[0] = c;
        this.powers[0] = d;
    }

    // second parametized constructor
    public Polynomial(double[] coefficients) {

        this.coefficients = new double[coefficients.length]; 
        this.powers = new int[coefficients.length];

        this.coefficients = coefficients;

        for (int i = 0; i < this.coefficients.length; i++) {
            this.powers[i] = i;
        }
    }

    public double getCoefficient(int degree) {
        return this.coefficients[degree];
    }

    public int getDegree() {
        return this.powers[this.coefficients.length];
    }

    public String toString() {

        this.polynomial = "";
        
        for (int i = 0; i < this.coefficients.length; i++) {

            String polynomialString = "";
            String sign;

            if (this.coefficients[i] != 0) {
                polynomialString = polynomialString + coefficients[i];
            
                if (powers[i] != 0) {
                    polynomialString = polynomialString + "x^" + powers[i];
                }

                if (coefficients[i] < 0) {
                    sign = "";
                }
                else {
                    sign = "+";
                }

                if ((i != this.coefficients.length - 1) && (i != 0)) {
                    polynomialString = sign + " " + polynomialString + " ";
                }

            }
            this.polynomial = this.polynomial + polynomialString;
        }

        return this.polynomial;
    }

    public double eval(double x) {
        double sum = 0;
        int power = 1;

        for (int i = 0; i < this.coefficients.length; i++) {
            if (powers[i] == 0) { 
                power = 1;
            }
            else {
                power = powers[i];
            }
            sum += Math.pow(coefficients[i] * x, power);
        }

        return sum;
    }

    // public double eval2(double x) {

    // }

}
