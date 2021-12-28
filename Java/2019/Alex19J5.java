//Alex
//2019 J5
//https://cemc.uwaterloo.ca/contests/computing/2019/stage%201/juniorEF.pdf
//8/15 (DMOJ NullPointerException - CCC WA)?

package com.company;

import java.io.*;
import java.util.*;


public class Main {

    static class Step {
        String before, after;
        int rule_used, index;

        public Step(String before, String after, int rule_used, int index) {
            this.before = before;
            this.after = after;
            this.rule_used = rule_used;
            this.index = index;

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] rules = new String[3][3];


        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            rules[i][0] = st.nextToken();
            rules[i][1] = st.nextToken();

        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num_steps = Integer.parseInt(st.nextToken());
        String start = st.nextToken(), end = st.nextToken();

        Stack<Step> output = dfs_search(rules, start, end, num_steps);

        for (Step temp_step : output) {
            //ignore first one
            if (temp_step.before == null) continue;
            System.out.println(temp_step.rule_used + " " + temp_step.index + " " + temp_step.after);

        }
    }

    public static Stack<Step> dfs_search(String[][] rules, String start, String end, int num_steps) {
        Set<String> marked = new HashSet<>();
        marked.add(start);

        Stack<Step> stack = new Stack<>();
        stack.add(new Step(null, start, -1, -1));
        stack.add(get_first_next(start, rules, marked));

        while (!stack.isEmpty()) {
            String current = stack.peek().after;

            if (stack.size() - 1 == num_steps) {
                if (current.equals(end)) return stack;
                stack.pop();
                continue;
            }

            Step new_step = get_first_next(current, rules, marked);

            if (new_step == null) stack.pop();
            else stack.push(new_step);
        }

        return null;
    }

    public static Step get_first_next(String current, String[][] rules, Set<String> marked) {
        for (int i = 0; i < 3; i++) {
            String rule_start = rules[i][0];
            String rule_end = rules[i][1];
            int index = current.indexOf(rule_start);
            int previous_index = index;

            while (index != -1) {
                String new_string = current.substring(0, index) + rule_end + current.substring(index + rule_start.length());

                if (!marked.contains(new_string)) {
                    marked.add(new_string);
                    return new Step(current, new_string, i + 1, index + 1);
                }

                index = current.indexOf(rule_start, previous_index + 1);
                previous_index = index;
            }
        }

        return null;
    }
}
