class Solution {

    public boolean halvesAreAlike(String s) {
        int n1 = vowelsCount(s, 0, s.length() / 2);
        int n2 = vowelsCount(s, s.length() / 2, s.length());

        return n1 == n2;
    }

    public int vowelsCount(String s, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') 
                count++;
        }

        return count;
    }
}
