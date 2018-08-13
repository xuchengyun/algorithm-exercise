class Solution {
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
            if (IP.charAt(IP.length() - 1) == '.') return "Neither";
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
                if (len >= 2) {
                    if (charArray[0] == '0' && charArray[1] == '0') return "Neither";
                }
            }
            return "IPv4";
        }

        return "Neither";
    }

    public boolean checkHex(char c) {
        char[] charArray = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','A','B','C','D','E','F'};
        for (char k : charArray) {
            if (k == c) return true;
        }
        return false;
    }
}