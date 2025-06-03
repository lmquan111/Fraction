package hus.oop.fraction;

public class MyFraction implements MyFractionComparable {
    private int numerator;
    private int denominator;

    public MyFraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public MyFraction(int numerator, int denominator) {
        if (denominator == 0){
            throw new ArithmeticException("Không thể chia 0");
        }

        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public MyFraction(MyFraction copyMyFraction) {
        this.numerator = copyMyFraction.numerator;
        this.denominator = copyMyFraction.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0){
            throw new ArithmeticException("Không thể chia cho 0");
        }

        this.denominator = denominator;
        simplify();
    }

    public byte byteValue() {
        return (byte) (numerator / (double) denominator);
    }

    public int intValue() {
        return numerator / denominator;
    }

    public long longValue() {
        return numerator / denominator;
    }

    public short shortValue() {
        return (short) (numerator / denominator);
    }

    public double doubleValue() {
        return (double) numerator / denominator;
    }

    public float floatValue() {
        return (float) numerator / denominator;
    }

    private int gcd() {
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);

        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }

    public void simplify() {
        int gcd = gcd();
        numerator /= gcd;
        denominator /= gcd;
        
        if (denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    @Override
    public int compareTo(MyFraction another) {

        return Integer.compare(this.numerator * another.denominator, another.numerator * this.denominator);

    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}