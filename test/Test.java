import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuchengyun on 8/8/18.
 */
public class Test{

    public String validIPAddress(String IP) {
        if (IP.contains(":")) {
            if (IP.charAt(IP.length() - 1) == ':') return "Neither";

            String[] parts = IP.split(":");
            if (parts.length != 8) return "Neither";
            for (String part : parts) {
                int len = part.length();
                if (len == 0 || len > 4) return "Neither";
                for (char c : part.toCharArray()) {
                    if (!checkHex(c)) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        } else if (IP.contains(".")) {
            System.out.println(IP);
            String[] parts = IP.split("\\.");

            System.out.println(parts.length);
            if (parts.length != 4) return "Neither";
            for (String part : parts) {
                char[] charArray = part.toCharArray();
                int len = charArray.length;
                if (len == 0 || len > 3) return "Neither";
                for (char c : charArray) {
                    if (c - '0' < 0  || c - '0' > 9) return "Neither";
                }
                if (Integer.parseInt(part) > 255) return "Neither";

                if (charArray[len - 1] != '0' && charArray[0] == '0') return "Neither";
            }
            return "IPv4";
        }

        return "Neither";
    }



    public boolean checkHex(char c) {
        char[] charArray = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','A','B','C','D','E'};
        for (char k : charArray) {
            if (k == c) return true;
        }
        return false;
    }


        public static void main(String[] args) {
            Test t = new Test();
            String s = "20EE:Fb8:85a3:0:0:8A2E:0370:7334";
            System.out.println(t.validIPAddress(s));

        }
}
