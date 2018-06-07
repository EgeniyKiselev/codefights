package evg.codefights.core;

public class IntroGates {


    //for tests
    public static void main(String[] args) {
        System.out.println(new IntroGates().candies(3, 5));
    }

    int addTwoDigits(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    int largestNumber(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }

        return res - 1;
    }

    int candies(int n, int m) {
        return (m / n) * n;
    }

    int seatsInTheater(int nCols, int nRows, int col, int row) {
        return (nCols - col + 1) * (nRows - row);
    }

    int maxMultiple(int divisor, int bound) {
        for (int i = bound; i >= 0; i--) {
            if (i % divisor == 0) {
                return i;
            }
        }
        return 0;
    }

    int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }

    int lateRide(int n) {
        int hours = n / 60;
        int minutes = n - hours * 60;

        int total = hours * 100 + minutes;

        int res = 0;
        while (total != 0) {
            res += total % 10;
            total /= 10;
        }

        return res;
    }

    int phoneCall(int min1, int min2_10, int min11, int S) {
        int mins = 0;

        if (min1 <= S) {
            mins++;
            S -= min1;
        } else {
            return 0;
        }
        if (min2_10 * 9 <= S) {
            mins += 9;
            S -= min2_10 * 9;
        } else {
            int m = S / min2_10;
            mins += m;
            S -= min2_10 * m;
            return mins;
        }

        int m = S / min11;
        mins += m;
        return mins;
    }
}
