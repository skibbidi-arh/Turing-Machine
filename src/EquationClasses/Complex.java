package src.EquationClasses;
public class Complex {

    double real;
    double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex other) {

        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    public Complex subtract(Complex other) {

        return new Complex(this.real - other.real, this.imag - other.imag);

    }

    public Complex multiply(Complex other) {

        return new Complex(this.real * other.real - this.imag * other.imag,

                this.real * other.imag + this.imag * other.real);
    }

    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imag * other.imag;

        return new Complex((this.real * other.real + this.imag * other.imag) / denominator,
                (this.imag * other.real - this.real * other.imag) / denominator);
    }


    public double magnitude() {

        return Math.sqrt(real * real + imag * imag);
    }


    @Override
    public String toString() {

        return String.format("%.6f + %.6fi", real, imag);

    }

}
