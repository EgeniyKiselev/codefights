package evg.codefights.intro;

public class DarkWilderness {

    int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int res = 1;
        int sum = 0;
        while(true) {
            sum += upSpeed;
            if (sum >= desiredHeight) {
                return res;
            }
            res++;
            sum -= downSpeed;
        }
    }

    int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (maxW >= weight1 + weight2) {
            return value1 + value2;
        }
        if (Math.max(weight1, weight2) <= maxW) {
            return Math.max(value1, value2);
        }
        if (weight1 <= maxW) {
            return value1;
        }
        if (weight2 <= maxW) {
            return value2;
        }
        return 0;
    }

    String longestDigitsPrefix(String inputString) {
        int cur = 0;
        for(int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                cur++;
            } else {
                break;
            }
        }
        return inputString.substring(0, cur);
    }

    int digitDegree(int n) {
        if (n < 10) {
            return 0;
        }
        int r = 0;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
            if (n == 0 && sum < 10) {
                r++;
                break;
            } else if (n == 0 && sum > 9) {
                n = sum;
                sum = 0;
                r++;
            }
        }
        return r;
    }

    boolean bishopAndPawn(String bishop, String pawn) {
        int x1 = bishop.charAt(0) -'a';
        int y1 = bishop.charAt(1) -'1';
        int x2 = pawn.charAt(0) -'a';
        int y2 = pawn.charAt(1) -'1';


        return Math.abs(x1 - x2) == Math.abs(y2 - y1);
    }

}
