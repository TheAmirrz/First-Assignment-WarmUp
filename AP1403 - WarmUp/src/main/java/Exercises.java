public class Exercises {

    public boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long fibonacciIndex(long n) {
        if (n == 0) {
            return 0;
        }

        // a holds the previous Fibonacci number, b holds the current.
        long a = 0;
        long b = 1;
        long index = 1;

        while (b <= n) {
            if (b == n) {
                return index;
            }
            long next = a + b;
            a = b;
            b = next;
            index++;
        }
        return -1;
    }


    public char[][] generateTriangle(int n) {
        char[][] triangle = new char[n][];

        for (int i = 0; i < n; i++) {
            // Create a new row with a length equal to the row number + 1.
            triangle[i] = new char[i + 1];

            // For the first two rows and the last row
            if (i < 2 || i == n - 1) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = '*';
                }
            }
            else {
                // For the middle rows:
                triangle[i][0] = '*';
                triangle[i][i] = '*';

                for (int j = 1; j < i; j++) {
                    triangle[i][j] = ' ';
                }
            }
        }

        return triangle;
    }

    public static void main(String[] args) {
        Exercises ex = new Exercises();

        // Testing triangle generation function
        int triangleSize = 5;
        char[][] triangle = ex.generateTriangle(triangleSize);
        System.out.println("Generated triangle:");
        for (char[] row : triangle) {
            System.out.println(new String(row));
        }

        // Testing fibo function
        long fibNumber = 987;
        long index = ex.fibonacciIndex(fibNumber);
        System.out.println("Fibonacci index of " + fibNumber + " is: " + index);

        // Testing isPrime function
        long candidate = 17;
        boolean isPrime = ex.isPrime(candidate);
        System.out.println(candidate + " is prime? " + isPrime);
    }
}
