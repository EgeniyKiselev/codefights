package evg.codefights.intro;

public class DivingDeeper {

    int[] extractEachKth(int[] inputArray, int k) {
        int[] res = new int[inputArray.length - inputArray.length / k];
        int j = 0;
        for(int i = 0; i < inputArray.length; i++) {
            if ((i + 1) % k != 0) {
                res[j++] = inputArray[i];
            }
        }
        return res;
    }

    char firstDigit(String inputString) {
        return (char) inputString
                .chars()
                .filter(Character::isDigit)
                .findFirst()
                .orElse(-1);
    }

    int differentSymbolsNaive(String s) {
        return (int) s.chars().distinct().count();
    }

    int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        int res = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += inputArray[i];
        }
        res = sum;
        for(int i = k; i < inputArray.length; i++) {
            sum += inputArray[i];
            sum -= inputArray[i - k];
            res = Math.max(sum, res);
        }
        return res;
    }
}
