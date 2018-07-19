package evg.codefights.core;

import java.util.*;
import java.util.stream.*;

public class CliffsOfPain {

    public static void main(String[] args) {
        System.out.println(new CliffsOfPain().pipesGame(new String[]{
                "a010",
                "C01A",
                "101b",
                "101B",
                "c250"
        }));
    }

    int pipesGame(String[] state) {
        Deque<Node> queue = new LinkedList<>();
        Map<Integer, Set<Character>> allowDirection = new HashMap<>();
        allowDirection.put(0, Stream.of('1', '3', '4', '7').collect(Collectors.toSet()));
        allowDirection.put(1, Stream.of('1', '5', '6', '7').collect(Collectors.toSet()));
        allowDirection.put(2, Stream.of('2', '3', '6', '7').collect(Collectors.toSet()));
        allowDirection.put(3, Stream.of('2', '4', '5', '7').collect(Collectors.toSet()));
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length(); j++) {
                char ch = state[i].charAt(j);
                if (ch >= 'a' && ch <= 'z') {
                    queue.add(new Node(i, j, 0, ch, -1));
                }
            }
        }
        Set<Node> water = new HashSet<>();
        int lastLevel = 0;
        boolean[] processed = new boolean[26];
        int currentLevel = 0;
        int total = 0;
        boolean isPoison = false;
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            isPoison = node.x == -1;
            if (lastLevel != node.level) {
                total += currentLevel;
                currentLevel = 0;
            }
            if (isPoison) {
                break;
            }
            lastLevel = node.level;

            char ch = state[node.x].charAt(node.y);
            if (ch >= '1' && ch <= '7') {
                boolean isAdded = water.add(node);
                if (isAdded) {
                    currentLevel++;
                }
            }
            if (ch >= 'A' && ch <= 'Z') {
                if (ch - 'A' == node.pipe - 'a') {
                    if (!processed[node.pipe - 'a']) {
                        processed[node.pipe - 'a'] = true;
                    }
                } else {
                    queue.addFirst(new Node(-1, -1, node.level, node.pipe, node.direction));
                }
            } else if (ch >= 'a' && ch <= 'z') {
                if (node.x - 1 >= 0 &&  allowDirection.get(0).contains(state[node.x - 1].charAt(node.y))) {
                    queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, 0));
                }
                if (node.x + 1 < state.length && allowDirection.get(1).contains(state[node.x + 1].charAt(node.y))) {
                    queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, 1));
                }
                if (node.y - 1 >= 0 && allowDirection.get(2).contains(state[node.x].charAt(node.y - 1))) {
                    queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, 2));
                }
                if (node.y + 1 < state[node.x].length() && allowDirection.get(3).contains(state[node.x].charAt(node.y + 1))) {
                    queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, 3));
                }
            } else if (ch == '0') {
                queue.addFirst(new Node(-1, -1, node.level, node.pipe, node.direction));
            } else if (ch == '1') {
                if (node.direction == 1) {
                    if (node.x + 1 < state.length) {
                        queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 0) {
                    if (node.x - 1 >= 0) {
                        queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }

            } else if (ch == '2') {
                if (node.direction == 3) {
                    if (node.y + 1 < state[node.x].length()) {
                        queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 2) {
                    if (node.y - 1 >= 0) {
                        queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '3') {
                if (node.direction == 0) {
                    if (node.y + 1 < state[node.x].length()) {
                        queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, 3));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 2) {
                    if (node.x + 1 < state.length) {
                        queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, 1));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '4') {
                if (node.direction == 3) {
                    if (node.x + 1 < state.length) {
                        queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, 1));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 0) {
                    if (node.y - 1 >= 0) {
                        queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, 2));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '5') {
                if (node.direction == 3) {
                    if (node.x - 1 >= 0) {
                        queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, 0));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 1) {
                    if (node.y - 1 >= 0) {
                        queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, 2));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '6') {
                if (node.direction == 2) {
                    if (node.x - 1 >= 0) {
                        queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, 0));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 1) {
                    if (node.y + 1 < state[node.x].length()) {
                        queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, 3));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '7') {
                if (node.direction == 1) {
                    if (node.x + 1 < state.length) {
                        queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 0) {
                    if (node.x - 1 >= 0) {
                        queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 3) {
                    if (node.y + 1 < state[node.x].length()) {
                        queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 2) {
                    if (node.y - 1 >= 0) {
                        queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            }
        }
        return isPoison ? -total : total;
    }


    static class Node {
        int x;
        int y;
        int level;
        int direction; //0 up, 1 down, 2 left, 3 right
        char pipe;

        Node(int x, int y, int level, char pipe, int direction) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.pipe = pipe;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


}
