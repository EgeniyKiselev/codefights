package evg.codefights.core;

import java.util.*;

public class SpringOfIntegration {

    int arrayConversion(int[] inputArray) {
        int size = inputArray.length;
        boolean isSum = true;
        while (size != 1) {
            for(int i = 0, j= 0; i < size; i+= 2, j++) {
                if (isSum) {
                    inputArray[j] = inputArray[i] + inputArray[i + 1];
                } else {
                    inputArray[j] = inputArray[i] * inputArray[i + 1];
                }

            }
            isSum = !isSum;
            size /= 2;
        }
        return inputArray[0];
    }

    String[] fileNaming(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String s : names) {
            int add = map.compute(s, (x, y) -> y == null ? 0 : y + 1);
            if (add == 0) {
                res.add(s);
            } else {
                String str;
                do {
                    str = s + '(' + add + ')';
                    if (map.containsKey(str)) {
                        add++;
                    }
                } while (map.containsKey(str));
                map.put(s, add);
                map.put(str, 0);
                res.add(str);
            }
        }
        return res.toArray(new String[0]);
    }

    int[] arrayPreviousLess(int[] items) {
        int[] res = new int[items.length];
        for(int i = 0; i < items.length; i++) {
            int less = -1;
            for(int j = i -1; j >= 0; j--) {
                if (items[i] > items[j]) {
                    less = items[j];
                    break;
                }
            }
            res[i] = less;
        }
        return res;
    }

    boolean pairOfShoes(int[][] shoes) {
        int[] left = new int[101];
        int[] right = new int[101];
        for(int i = 0; i < shoes.length; i++) {
            int[] shoe = shoes[i];
            if (shoe[0] == 0) {
                left[shoe[1]]++;
            } else {
                right[shoe[1]]++;
            }
        }
        for(int i = 0; i < left.length; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }
        return true;
    }

    int combs(String comb1, String comb2) {
        int num1 = getNumber(comb1);
        int num2 = getNumber(comb2);

        int len1 = comb1.length();
        int len2 = comb2.length();

        int res = len1 + len2;
        for (int i = 0; i <= len1; i++) {
            int tmp = (num2 << i) & num1;
            if (tmp == 0) {
                res = Math.min(res, Math.max(len2 + i, len1));
            }
        }
        for (int i = 0; i <= len2; i++) {
            int tmp = (num1 << i) & num2;
            if (tmp == 0) {
                res = Math.min(res, Math.max(len1 + i, len2));
            }
        }

        return res;

    }


    int getNumber(String s) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            int add = s.charAt(i) == '*' ? 1 : 0;
            r = (r << 1) + add;
        }
        return r;
    }

    int stringsCrossover(String[] inputArray, String result) {
        int res = 0;
        for(int i = 0; i < inputArray.length; i++) {
            for(int j = i + 1; j < inputArray.length; j++) {
                boolean isFound = true;
                for(int k = 0; k < result.length(); k++) {
                    if (result.charAt(k) != inputArray[i].charAt(k)
                            && result.charAt(k) != inputArray[j].charAt(k)) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) {
                    res++;
                }
            }
        }
        return res;
    }

    int cyclicString(String s) {
        for(int res = 1; res < s.length(); res++) {
            boolean isFound = true;
            for(int p = 0; p + res < s.length(); p++) {
                if (s.charAt(p) !=s.charAt(p + res)) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                return res;
            }

        }
        return s.length();
    }

    boolean beautifulText(String inputString, int l, int r) {
        int len = inputString.length();
        if (len >= l && len <= r) {
            return true;
        }
        for (int dif = 1; ; dif++) {
            int d = len / dif;
            if (d < l) {
                break;
            }
            if (d > r) {
                continue;
            }
            int rem = len % dif;
            boolean isFound = true;
            int e = 0;
            for(int i = d; i < len - rem; i += d) {
                int pos = i + e;
                e++;
                if (inputString.charAt(pos) != ' ') {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                return true;
            }
        }
        return false;
    }

    int runnersMeetings(int[] startPosition, int[] speed) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < startPosition.length; i++) {
            for (int j = i + 1; j < startPosition.length; j++) {
                int up = startPosition[i] * speed[j] - startPosition[j] * speed[i];
                int down = speed[j] - speed[i];
                if (down == 0 /*|| up > 0 && down < 0 || up < 0 && down > 0*/) {
                    continue;
                }
                if (up % down == 0) {
                    int meetDistance = up / down;
                    map.putIfAbsent(meetDistance, new HashSet<>());
                    map.get(meetDistance).add(i);
                    map.get(meetDistance).add(j);
                }
            }
        }
        return map.values().stream().map(Set::size).max(Integer::compare).orElse(-1);
    }


    String[] christmasTree(int levelNum, int levelHeight) {
        int footerHeight = levelNum;
        int footerWidth = levelHeight % 2 == 0 ? levelHeight + 1 : levelHeight;
        int totalWidth = 3 + 2 * levelHeight + 2 * (levelNum - 1);
        List<String> list = new ArrayList<>();
        //crown
        list.add(String.format("%" + getWidth(totalWidth, 1) + "s", "*"));
        list.add(String.format("%" + getWidth(totalWidth, 1) + "s", "*"));
        list.add(String.format("%" + getWidth(totalWidth, 3) + "s", getAsterisks(3)));

        int startNumAsterisks = 5;
        for(int i = 0; i < levelNum; i++) {
            int asteriks = startNumAsterisks;
            for(int j = 0; j < levelHeight; j++) {
                list.add(String.format("%" + getWidth(totalWidth, asteriks) + "s", getAsterisks(asteriks)));
                asteriks += 2;
            }
            startNumAsterisks += 2;
        }


        //footer
        for(int i = 0; i < footerHeight; i ++) {
            list.add(String.format("%" + getWidth(totalWidth, footerWidth) + "s", getAsterisks(footerWidth)));
        }

        return list.toArray(new String[0]);
    }

    int getWidth(int totalWidth, int numAsterix) {
        return totalWidth / 2 + 1 + numAsterix / 2;
    }

    String getAsterisks (int num) {
        return new String(new char[num]).replace('\0', '*');
    }

}
