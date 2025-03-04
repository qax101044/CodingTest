class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0; i < n; i++) {
            String str1 = intToBinaryString(arr1[i],n);
            String str2 = intToBinaryString(arr2[i],n);
            String resultStr = "";
            
            for (int j=0; j < n; j++) {
                if (str1.charAt(j) == '0' && str2.charAt(j) == '0') {
                    resultStr += " ";
                }
                
                else {
                    resultStr += "#";
                }
            }
            answer[i] = resultStr;
            
        }
        return answer;
    }
    
    public String intToBinaryString(int target, int n) {
        String str = Integer.toBinaryString(target);
        
        while(str.length() < n) {
            str = "0" + str;
        }
        
        return str;
    }
}