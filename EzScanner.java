import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * <ul>
 * <li>A simple convenience class that allows you to read inputs without the awkward
 * <code>scanner.nextLine()</code>after reading a non-string</li>
 * <li>Maintains only a single<code>Scanner</code>if reading
 * from<code>System.in</code>class that can be called from anywhere. This
 * removes code smell of having multiple<code>new Scanner(System.in)</code> for
 * no reason
 * <ul>
 * <li>Call <code>getSystemInScanner()</code>to get this singleton</li>
 * <ul>
 * </li>
 * <ul>
 */
public class EzScanner {
    private static final Scanner defaultSysInScanner = new Scanner(System.in);
    private Scanner scanner;
    private boolean trimInputs;

    private EzScanner(InputStream source, boolean trimInputs) {
        if (source.getClass() == System.in.getClass()) {
            scanner = defaultSysInScanner;
        } else {
            scanner = new Scanner(source);
        }

        this.trimInputs = trimInputs;

    }

    private EzScanner(InputStream source) {
        this(source, false);
    }

    public static EzScanner of(InputStream source) {
        return new EzScanner(source);
    }

    public static EzScanner of(InputStream source, boolean trimInputs) {
        return new EzScanner(source, trimInputs);
    }

    /**
     * @return A scanner that by default reads from <code>System.in</code>class
     *         <ul>
     *         <li>This scanner is a singleton minimizing the unnecessary
     *         instantiation of<code>new Scanner(System.in)</code></li>
     *         <li>This is safe since we only 1 stream that reads from a
     *         the<code>System.in</code> source.</li>
     *         <ul>
     */
    public static EzScanner getSystemInScanner() {
        return EzScanner.of(System.in);
    }

    public Boolean hasNextByte() {
        return scanner.hasNextByte();
    }

    public Byte nextByte() {
        return Byte.valueOf(nextLine());
    }

    public Boolean hasNextByte(int radix) {
        return scanner.hasNextByte(radix);
    }

    public Byte nextByte(int radix) {
        return Byte.valueOf(nextLine(), radix);
    }

    public Boolean hasNextBoolean() {
        return scanner.hasNextBoolean();
    }

    public Boolean nextBoolean() {
        return Boolean.valueOf(nextLine());
    }

    public boolean hasNextInt() {
        return scanner.hasNextInt();
    }

    public Integer nextInt() {
        return Integer.valueOf(nextLine());

    }

    public boolean hasNextLong() {
        return scanner.hasNextLong();
    }

    public Long nextLong() {
        return Long.valueOf(nextLine());
    }

    public boolean hasNextFloat() {
        return scanner.hasNextFloat();
    }

    public Float nextFloat() {
        return Float.valueOf(nextLine());
    }

    public boolean hasNextDouble() {
        return scanner.hasNextDouble();
    }

    public Double nextDouble() {
        return Double.valueOf(nextLine());
    }

    public boolean hasNextBigInteger() {
        return scanner.hasNextBigInteger();
    }

    public BigInteger nextBigInteger() {
        return BigInteger.valueOf(nextInt());
    }

    public boolean hasNextBigDecimal() {
        return scanner.hasNextBigDecimal();
    }

    public BigDecimal nextBigDecimal() {
        return BigDecimal.valueOf(nextDouble());
    }

    public String next() {
        return trimInputs ? scanner.next().trim() : scanner.next();
    }

    public String nextLine() {
        return trimInputs ? scanner.nextLine().trim() : scanner.nextLine();

    }

    /**
     * 
     * @param message : Text you want to displayed as screen is buffered
     *                <p>
     *                To stop the screen buffering, simply enter an input from
     *                the<code>InputStream</code> that you passed during
     *                instantiation
     */
    public void bufferScreen(String message) {
        System.out.println(message);
        this.bufferScreen();
    }

    public void bufferScreen() {
        System.out.println("Press any key to continue...> ");
        scanner.nextLine();
    }

}
