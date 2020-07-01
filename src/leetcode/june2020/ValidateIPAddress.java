package leetcode.june2020;

public class ValidateIPAddress {
	public static void main(String[] args) {
		System.out.println(new ValidateIPAddress().validIPAddress("2001:0db8::85a3:0:0:8A2E:0370:7334:"));
	}

	public String validIPAddress(String IP) {
		if (IP.contains(".")) {
			String[] ip = IP.split("\\.");
			if (count(IP, '.') != 3 || ip.length != 4) return "Neither";
			for (String s : ip) {
				if (s.isEmpty() || s.length() > 3 || (s.startsWith("0") && s.length() != 1)) return "Neither";
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) < '0' || s.charAt(i) > '9') return "Neither";
				}
				int value = Integer.parseInt(s);
				if (value < 0 || value > 255) return "Neither";
			}
			return "IPv4";
		} else {
			String[] ip = IP.split(":");
			if (count(IP, ':') != 7 || ip.length != 8) return "Neither";
			for (String s : ip) {
				if (s.isEmpty() || s.length() > 4) return "Neither";
				for (int i = 0; i < s.length(); i++) {
					char ch = s.charAt(i);
					if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')))
						return "Neither";
				}
			}
			return "IPv6";
		}
	}

	private int count(String IP, char ch) {
		int count = 0;
		for (int i = 0; i < IP.length(); i++) {
			if (IP.charAt(i) == ch) count++;
		}
		return count;
	}
}
