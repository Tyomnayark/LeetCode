package tasks.occurancestring;

public class FindOccuranceString {
    public int strStr(String haystack, String needle) {
        byte[] arrayHaystack = haystack.getBytes();
        byte[] arrayNeedle = needle.getBytes();
        if (arrayHaystack.length < arrayNeedle.length){
            return -1;
        }
        for (int i = 0; i < arrayHaystack.length; i++ ){
            if (arrayHaystack[i] == arrayNeedle[0]){
                if (checkWord(i, arrayHaystack,arrayNeedle)){
                    return i;
                }
            }
        }
        return -1;
    }
    public static boolean checkWord(int u, byte[] haystack, byte[] needle){
        int res = 0;
        for (int i = 0; i <  needle.length; i++){
            if (u < haystack.length && needle[i] == haystack[u] ){
                res++;
            }
            u++;
        }
        return   res == needle.length  ? true: false;
    }
}
