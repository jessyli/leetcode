The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

between every two is 2 * nRow – 2, and for the middle say i-th rows, the difference between every two is either 2 * nRow – 2 – 2 * i
or 2 * i in turn

time complexity O(n)

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        if(numRows==0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int step = 2*numRows-2;
        for(int i=0; i<numRows; i++){
            if(i==0||i==numRows-1){
                int j=i;
                while(j<s.length()){
                    sb.append(s.charAt(j));
                    j=j+step;
                }
            }
            else{
                int j=i;
                int step1 = 2*(numRows-i-1);
                int step2 = step-step1;
                boolean flag = true;
                while(j<s.length()){
                    sb.append(s.charAt(j));
                    if(flag==true){
                        j = j+step1;
                    }
                    else{
                        j = j+step2;
                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }
}
