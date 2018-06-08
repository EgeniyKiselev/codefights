package evg.codefights.intro;

public class ThroughTheFog {

    int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }

    int depositProfit(int deposit, int rate, int threshold) {
        double sum = deposit;
        int period = 0;
        double r = rate / 100.0 + 1;
        while (sum < threshold) {
            sum *= r;
            period++;
        }
        return period;
    }

    int absoluteValuesSumMinimization(int[] a) {
        int n = a.length;
        if (n % 2 == 0) {
            return Math.min(a[n / 2], a[n / 2 - 1]);
        } else {
            return a[a.length / 2];
        }
    }

    boolean stringsRearrangement(String[] inputArray) {
        return permute(inputArray, 0);
    }
    static boolean permute(String[] arr, int k) {
        for (int i = k; i < arr.length; i++) {
            if (k > 0) {
                if (!checkString(arr[i], arr[k - 1])) {
                    continue;
                }
            }
            swap(arr, i, k);
            boolean isFound = permute(arr, k + 1);
            if (isFound) {
                return true;
            }
            swap(arr, k, i);
        }
        if (k == arr.length - 1) {
            for(int i = 1; i < arr.length; i++) {
                if (!checkString(arr[i - 1], arr[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    static void swap(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static boolean checkString(String s1, String s2) {
        boolean isFlag = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (isFlag) {
                    return false;
                }
                isFlag = true;
            }
        }
        return isFlag;
    }
}
