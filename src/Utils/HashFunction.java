package Utils;

public class HashFunction {
    public static String hash(String string) {
        int hash = 7;
        int mod = 100000;
        for (int i = 0; i < string.length(); i++) {
            hash = hash * 31 + string.charAt(i);
        }
        return String.valueOf(hash % mod);
    }
}
