class Solution {
    //"" is kept for index simplicity. TENS: 1st 2nd never used, keep for index simplicity
    private final String[] LESS_THAN_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
"Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] TENS = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private final String[] THOUSANDS = {"","Thousand","Million","Billion"};
    
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        int i = 0;//ptr to thousands
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0) { //avoid special case 1,000,000 else return one million thousand
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        
        return words.trim();//remove extra space in the end.
    }
    
    private String helper(int num) {
        if(num == 0) {
            return "";
        } else if(num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if(num < 100) {
            return TENS[num/10] + " " + helper(num%10);//avid extra space by recur call
        } else {//100-999
            return LESS_THAN_20[num/100] + " Hundred " + helper(num%100);
        }
    }
}
