/**
 * Lab02
 * Instructions for Lab02 are in CS102_Lab02.pdf file located in the root directory of Lab02
 * Revisions can be seen on the following GitHub URL: https://github.com/thecrazybob/CS102-lab02
 * Style Guidelines: http://www.cs.bilkent.edu.tr/~adayanik/cs101/practicalwork/styleguidelines.htm
 *
 * @author Mohammed Sohail
 * @version 15/02/2021
 */

public class Polynomial {
    
    // properties
    public double[] coefficients;
    public int[] powers;
    public String polynomial;

    // default constructor
    public Polynomial() {
        this.coefficients = new double[1]; 
        this.powers = new int[1];

        this.coefficients[0] = 0;
        this.powers[0] = 0;
    } 

    /**
     * Constructor which takes an degree 'd' and a coefficient 'c'
     * @param int d
     * @param double c
     */
    public Polynomial(int d, double c) {

        this.coefficients = new double[1]; 
        this.powers = new int[1];

        this.coefficients[0] = c;
        this.powers[0] = d;
    }

    /**
     * Constructor which takes an array of coefficients of type double
     */
    public Polynomial(double[] coefficients) {

        this.coefficients = new double[coefficients.length]; 
        this.powers = new int[coefficients.length];

        this.coefficients = coefficients;

        for (int i = 0; i < this.coefficients.length; i++) {
            this.powers[i] = i;
        }
    }

    private Polynomial operate(String operation, Polynomial p2) {
        
        // New array of coefficients for the sum of the two polynomials
        double[] newCoefficients = new double[this.coefficients.length + p2.coefficients.length];

        // Compare and get greatest length of coefficients
        int length = p2.coefficients.length > this.coefficients.length ? p2.coefficients.length : this.coefficients.length;

        // Loop till the greatest length and add each coefficients
        for (int i = 0; i < length; i++) {

            // Use 0 if index does not exist in either coefficients array
            double existingCoefficient = (this.coefficients.length > i) ? this.coefficients[i] : 0;
            double inputCoefficient = (p2.coefficients.length > i) ? p2.coefficients[i] : 0;

            // Form the new coeffficients array
            if (operation == "add") {
                newCoefficients[i] = existingCoefficient + inputCoefficient;
            }
            else {
                newCoefficients[i] = existingCoefficient - inputCoefficient;
            }
        }

        // Form the new polynomial using the newly created coefficients array
        Polynomial newPolynomial = new Polynomial(newCoefficients);

        // Return the newPolynomial object
        return newPolynomial;
    }

    /** 
     * Sums the current object's coefficients and the input object's coefficients and returns a new polynomial consisting of the resulting polynomial
     * @param p2
     * @return Polynomial
     */
    public Polynomial add(Polynomial p2) {
        
        return this.operate("add", p2);

    }

    /** 
     * Subtracts the input object's coefficients from the current object's coefficients and returns a new polynomial consisting of the resulting polynomial
     * @param p2
     * @return Polynomial
     */
    public Polynomial subtract(Polynomial p2) {
        
        return this.operate("subtract", p2);

    }
    
    /** 
     * Return coefficient of a given degree
     * @param int degree
     * @return double
     */
    public double getCoefficient(int degree) {
        return this.coefficients[degree];
    }

    
    /** 
     * Return degree of the polynomial
     * @return int
     */
    public int getDegree() {
        return this.powers[this.coefficients.length - 1];
    }

    
    /** 
     * Return a string representation of the polynomial
     * @return String
     */
    public String toString() {

        // initialize global property
        this.polynomial = "";
        
        // loop through coefficients
        for (int i = 0; i < this.coefficients.length; i++) {

            // local variables for temporary storing/naming
            String polynomialString = "";
            String sign = "";

            // calculate a single term of the polynomial
            if (this.coefficients[i] != 0) {

                polynomialString = polynomialString + coefficients[i];
                
                // skip degree/x term if power is 0
                if (powers[i] != 0) {
                    polynomialString = polynomialString + "x^" + powers[i];
                }

                // add a positive sign if coefficient is positive
                if (coefficients[i] > 0 && i != 0) {
                    sign = "+";
                }

                // form string for a single polynomial term
                polynomialString = sign + " " + polynomialString + " ";

            }

            // assign the formed string to global property
            this.polynomial = this.polynomial + polynomialString;
        
        }

        // return the string representation
        return this.polynomial;
    }

    
    /** 
     * Evaluates the polynomial at a given x and returns the result
     * @param double x
     * @return double
     */
    public double eval(double x) {

        double sum = 0;

        for (int i = 0; i < this.coefficients.length; i++) {
            sum += this.coefficients[i] * Math.pow(x, powers[i]);
        }

        return sum;
    }

    /** 
     * Returns the evaluation of the polynomial by using Horner's method
     * @param double x
     * @return double
     */
    public double eval2(double x) {

        double sum = 0;

        for (int i = this.coefficients.length - 1; i >= 0; i--) {
            sum = (x * sum) + coefficients[i];
        }

        return sum;

    }

}
