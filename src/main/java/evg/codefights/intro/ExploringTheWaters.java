package evg.codefights.intro;

public class ExploringTheWaters {

    int[] alternatingSums(int[] a) {
        int team1 = 0;
        int team2 = 0;
        for(int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                team1 += a[i];
            } else {
                team2 += a[i];
            }
        }
        return new int[] {team1, team2};
    }

    String[] addBorder(String[] picture) {
        int rows = picture.length;
        String[] res = new String[rows + 2];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < picture[0].length() + 2; i++) {
            sb.append('*');
        }
        String top = sb.toString();
        res[0] = top;
        res[res.length - 1] = top;

        for(int i = 0; i < rows; i++) {
            res[i + 1] = '*' + picture[i] + '*';
        }
        return res;
    }

    boolean areSimilar(int[] a, int[] b) {
        int left = -1;
        int right = -1;

        for(int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (left != -1 && right != -1) {
                    return false;
                }
                if (left == -1) {
                    left = i;
                    continue;
                }
                if (right == -1) {
                    if (a[left] == b[i] && a[i] == b[left]) {
                        right = i;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    int arrayChange(int[] inputArray) {
        int res = 0;
        int last = inputArray[0];
        int dif;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < last) {
                dif = last - inputArray[i] + 1;
                last = inputArray[i] + dif;
                res += dif;
            } else if (inputArray[i] == last) {
                last++;
                res++;
            } else {
                last = inputArray[i];
            }
        }
        return res;
    }

    boolean palindromeRearranging(String inputString) {
        int[] n = new int[256];
        for(int i = 0; i < inputString.length(); i++) {
            n[inputString.charAt(i)]++;
        }
        int odd = 0;
        for(int i = 0; i < n.length; i++) {
            if (n[i] % 2 != 0) {
                odd++;
            }
        }
        return odd <= 1;
    }
}
