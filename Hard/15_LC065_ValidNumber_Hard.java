class Solution {
    public boolean isNumber(String s) {
        boolean num = false;
        boolean exp = false;
        boolean decimal = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = true;
            }

            else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            else if (ch == '.') {
                if (decimal || exp) {
                    return false;
                }
                decimal = true;
            }

            else if (ch == 'e' || ch == 'E') {
                if (exp || !num) {
                    return false;
                }
                exp = true;
                num = false;
            }

            else {
                return false;
            }
        }

        return num;
    }
}