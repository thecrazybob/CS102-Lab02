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
    public int degree;

    // default constructor
    public Polynomial() {

        this.coefficients = new double[1]; 
        this.coefficients[0] = 0;
        this.degree = 0;
    
    } 

    /**
     * Constructor which takes an degree 'd' and a coefficient 'c'
     * @param int d The degree
     * @param double c The coefficient
     */
    public Polynomial(int degree, double coefficient) {
        
        this.coefficients      = new double[1]; 
        this.coefficients[0]   = coefficient;
        this.degree            = -1;

    }

    /**
     * Constructor which takes an array of coefficients of type double
     */
    public Polynomial(double[] coefficients) {

        this.coefficients = new double[coefficients.length]; 
        
        this.coefficients = coefficients;
        
        this.degree = this.getDegree();

    }

    
    /** 
     * This method is used to assist with add() and sub() method, it adds or subtracts the polynomial based on the input
     * @param operation (add/subtract)
     * @param p2 the polynomial to be added or subtracted
     * @return Polynomial
     */
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
    public Polynomial sub(Polynomial p2) {
        
        return this.operate("subtract", p2);

    }

    /** 
     * Multiplies the current polynomial with the input polynomial and returns a new polynomial consisting of the resulting polynomial
     * @param p2 the polynomial to be multiplied
     * @return Polynomial
     */
    public Polynomial mul(Polynomial p2) {

        // Longest coefficient array
        double[] longestCoefficients = p2.coefficients.length > this.coefficients.length ? p2.coefficients : this.coefficients;

        // Smallest coefficient array
        double[] smallestCoefficients = p2.coefficients.length > this.coefficients.length ? this.coefficients : p2.coefficients;

        // Initialize a new polynomial
        Polynomial newPolynomial = new Polynomial();

        // Loop through longest coefficients array
        for (int index = 0; index < longestCoefficients.length; index++) {
                        
            // Initialize newCoefficients array
            double[] newCoefficients = new double[smallestCoefficients.length + index];

            // Loop through smallestCoefficients array
            for (int i = 0; i < smallestCoefficients.length; i++ ) {

                // find exponent of the current item in the longestCoefficients array
                int exponent = index;

                // fill newCoefficients array with zeroes till the current exponent is reached
                for (int exponentI = 0; exponentI < exponent; exponentI++) {
                    newCoefficients[exponentI] = 0;
                }

                // multiply and add the result to the newCoefficients array
                newCoefficients[exponent + i] = longestCoefficients[index] * smallestCoefficients[i];

            }

            // Use the add method to add the newly formed coefficients array with an existing one
            // incase its the first time the loop ran, it will add it to an empty Polynomial object initialized above
            newPolynomial = newPolynomial.add(new Polynomial(newCoefficients));

        }

        // Return the newly formed polynomial
        return newPolynomial;

    }
    
    /** 
     * Composes the current polynomial with the input polynomial and returns a new polynomial consisting of the resulting polynomial
     * @param p2 - the polynomial to be composed
     * @return Polynomial
     */
    public Polynomial compose(Polynomial p2) {
        
        Polynomial newPolynomial = new Polynomial(0, 0);

        for (int i = this.getDegree(); i >= 0; i--) {

            Polynomial term = new Polynomial(0, this.coefficients[i]);
            newPolynomial = term.add(p2.mul(newPolynomial));
            
        }

        return newPolynomial;
    
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

        // Check for 0 coefficient
        for (int i = this.coefficients.length - 1; i > 0; i--) {
            if (this.coefficients[i] != 0) {
                this.degree = i;
                break;
            }
        }

        return this.degree;

    }

    
    /** 
     * Return a string representation of the polynomial
     * @return String
     */
    public String toString() {

        // initialize global property
        String polynomial = "";
        
        // loop through coefficients
        for (int i = 0; i < this.coefficients.length; i++) {

            // local variables for temporary storing/naming
            String polynomialString = "";
            String sign = "";

            // calculate a single term of the polynomial
            if (this.coefficients[i] != 0) {

                polynomialString = polynomialString + coefficients[i];
                
                // skip degree/x term if power is 0
                if (i != 0) {
                    polynomialString = polynomialString + "x^" + i;
                }

                // add a positive sign if coefficient is positive
                if (coefficients[i] > 0 && i != 0) {
                    sign = "+";
                }

                // form string for a single polynomial term
                polynomialString = sign + " " + polynomialString + " ";

            }

            // assign the formed string
            polynomial = polynomial + polynomialString;
        
        }

        // return the string representation
        return polynomial;
    }

    
    /** 
     * Evaluates the polynomial at a given x and returns the result
     * @param double x
     * @return double
     */
    public double eval(double x) {

        double sum = 0;

        for (int i = 0; i < this.coefficients.length; i++) {
            sum += this.coefficients[i] * Math.pow(x, i);
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
