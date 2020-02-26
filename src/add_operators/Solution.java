package add_operators;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = s.addOperators1("1203",6);
        list.forEach(e -> System.out.println(e));
    }


    public List<String> addOperators(String num, int target) {
        if(num.equals("") || num == null) {return new ArrayList();}

        List<String> result = new ArrayList();

        dfs(num, target, 0, result, new StringBuilder(), 0, 0);
        return result;
    }

    private void dfs(String num, int target, int index, List<String> result, StringBuilder expression, int eval, int sub) {

        if(index == num.length()) {
            if(eval == target) {
                result.add(expression.toString());
            }
            return;
        }


        for(int i = index; i<num.length(); i++) {
            char c = num.charAt(i);
            if(c == '0' && i!= index) {
                break;
            }

            int len = expression.length();
            String substr = num.substring(index, i+1);
           // System.out.println(expression);
            int curr = Integer.parseInt(substr);
            if(index == 0) {
                dfs(num, target, i+1, result, expression.append(curr), curr, curr);
                expression.setLength(len);
            } else {
                dfs(num, target, i+1, result, expression.append("+").append(curr), eval + curr, curr);
                expression.setLength(len);

                dfs(num, target, i+1, result, expression.append("-").append(curr), eval - curr, -curr);
                expression.setLength(len);

                dfs(num, target, i+1, result, expression.append("*").append(curr), eval -sub + (sub* curr), curr);
                expression.setLength(len);
            }




        }

    }

    public List<String> addOperators1(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;

    }
    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {
        if(pos == num.length()) {
            if(target == prev) res.add(sb.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            System.out.println(sb );
            if(num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if(pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }

   /* public ArrayList<String> answer;
    public String digits;
    public long target;

    public void recurse(
            int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
        String nums = this.digits;

        // Done processing all the digits in num
        if (index == nums.length()) {

            // If the final value == target expected AND
            // no operand is left unprocessed
            if (value == this.target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                this.answer.add(sb.toString());
            }
            return;
        }

        // Extending the current operand by one digit
        currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
        String current_val_rep = Long.toString(currentOperand);
        int length = nums.length();

        // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
        // valid operand. Hence this check
        if (currentOperand > 0) {

            // NO OP recursion
            recurse(index + 1, previousOperand, currentOperand, value, ops);
        }

        // ADDITION
        ops.add("+");
        ops.add(current_val_rep);
        recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {

            // SUBTRACTION
            ops.add("-");
            ops.add(current_val_rep);
            recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            // MULTIPLICATION
            ops.add("*");
            ops.add(current_val_rep);
            recurse(
                    index + 1,
                    currentOperand * previousOperand,
                    0,
                    value - previousOperand + (currentOperand * previousOperand),
                    ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }

    public List<String> addOperators(String num, int target) {

        if (num.length() == 0) {
            return new ArrayList<String>();
        }

        this.target = target;
        this.digits = num;
        this.answer = new ArrayList<String>();
        this.recurse(0, 0, 0, 0, new ArrayList<String>());
        return this.answer;
    }*/
}
