package removeInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {

    public static void main(String [] args) {
        Solution s = new Solution();
        List<String> list = s.removeInvalidParentheses("()())()");
        list.forEach(e -> System.out.println(e));

    }


    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList();
        }


        recurse(s, new StringBuilder(), 0, 0, 0, 0);

        return new ArrayList(set);
    }
    private int minNumRemoved = Integer.MAX_VALUE;

    Set<String> set = new HashSet();

    private void recurse(String s, StringBuilder expression, int left, int right, int index, int numRemoved) {


        if(index == s.length()) {

            if(left == right) {
                if(numRemoved <= minNumRemoved) {
                    if(numRemoved < minNumRemoved) {
                        set.clear();
                        minNumRemoved = numRemoved;
                    }
                    set.add(expression.toString());
                }
            }


        } else {
            int length = expression.length();
            char c = s.charAt(index);
            if(c != '(' && c != ')') {
                expression.append(c);
                recurse(s, expression, left, right, index+1, numRemoved);
                expression.deleteCharAt(length);
            } else {
                recurse(s, expression, left, right, index+1, numRemoved+1);

                expression.append(c);
                if(c == '(') {

                    recurse(s, expression, left+1, right, index+1, numRemoved);
                } else if(left > right) {
                    recurse(s, expression, left, right+1, index+1, numRemoved);
                }
                expression.deleteCharAt(length);
            }

        }
    }

    /* private Set<String> validExpressions = new HashSet<String>();
  private int minimumRemoved;

  private void reset() {
    this.validExpressions.clear();
    this.minimumRemoved = Integer.MAX_VALUE;
  }

  private void recurse(
      String s,
      int index,
      int leftCount,
      int rightCount,
      StringBuilder expression,
      int removedCount) {

    // If we have reached the end of string.
    if (index == s.length()) {

      // If the current expression is valid.
      if (leftCount == rightCount) {

        // If the current count of removed parentheses is <= the current minimum count
        if (removedCount <= this.minimumRemoved) {

          // Convert StringBuilder to a String. This is an expensive operation.
          // So we only perform this when needed.
          String possibleAnswer = expression.toString();

          // If the current count beats the overall minimum we have till now
          if (removedCount < this.minimumRemoved) {
            this.validExpressions.clear();
            this.minimumRemoved = removedCount;
          }
          this.validExpressions.add(possibleAnswer);
        }
      }
    } else {

      char currentCharacter = s.charAt(index);
      int length = expression.length();

      // If the current character is neither an opening bracket nor a closing one,
      // simply recurse further by adding it to the expression StringBuilder
      if (currentCharacter != '(' && currentCharacter != ')') {
        expression.append(currentCharacter);
        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
        expression.deleteCharAt(length);
      } else {

        // Recursion where we delete the current character and move forward
        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
        expression.append(currentCharacter);

        // If it's an opening parenthesis, consider it and recurse
        if (currentCharacter == '(') {
          this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
        } else if (rightCount < leftCount) {
          // For a closing parenthesis, only recurse if right < left
          this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
        }

        // Undoing the append operation for other recursions.
        expression.deleteCharAt(length);
      }
    }
  }

  public List<String> removeInvalidParentheses(String s) {

    this.reset();
    this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
    return new ArrayList(this.validExpressions);
  }


    /*public List<String> removeInvalidParentheses(String s) {
        List<String> validCombinations = new ArrayList();
        if(s.isEmpty()) {
            validCombinations.add("");
            return validCombinations;
        }

        if(s.length() == 1 && (s.charAt(0) != '(' || s.charAt(0) != ')')) {
            validCombinations.add(s);
            return validCombinations;
        }
        Set<String> validCombSet = new HashSet();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) != '(' && s.charAt(i) != ')') {continue;}
            String subStr = "";
            if(i != 0) {subStr = s.substring(0, i);}
            subStr = subStr + s.substring(i+1, s.length());
            if(isValid(subStr) && !validCombSet.contains(subStr)) {
                validCombinations.add(subStr);
                validCombSet.add(subStr);
            }
        }
        if(validCombinations.isEmpty()) {validCombinations.add("");}
        return validCombinations;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else if(c == ')'){
                if(stack.isEmpty()) {return false;}
                stack.pop();
            }
        }
        return stack.isEmpty();
    }*/
}
