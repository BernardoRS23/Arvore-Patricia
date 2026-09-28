public class Main {
    public static void main(String[] args) {
        String ch;
        ch = "bola";
        String bit = "";

        for(int i = 0; i < 16; i++) {
            if(i >= ch.length()) {
                bit += "00000000";
            } else {
                bit += "0" + Integer.toBinaryString(ch.charAt(i));
            }
        }

    }
}