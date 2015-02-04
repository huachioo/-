package com.x.ut.common;

public final class Converter {

	private Converter() {

	}

	public static String ToHexString(byte[] buf) {

		StringBuilder sb = new StringBuilder(2 * buf.length);
		for (byte aBuf : buf) {
			int h = (aBuf & 0xf0) >> 4;
			int l = (aBuf & 0x0f);
			sb.append(new Character((char) ((h > 9) ? 'a' + h - 10 : '0' + h)));
			sb.append(new Character((char) ((l > 9) ? 'a' + l - 10 : '0' + l)));
		}
		return sb.toString();
	}

	public static String ToHexString(long v) {
		StringBuilder sb = new StringBuilder(16);
		int b;
		for (int i = 15; i >= 0; i--) {
			b = ((int) (v >>> (4 * i))) & 0xF;
			sb.append((char) ((b > 9) ? 'a' + b - 10 : '0' + b));
		}
		return sb.toString();
	}

	public static long longFromHexString(String h, int offset, int len)
			throws NumberFormatException {
		if (h == null)
			throw new NumberFormatException("空引用。");
		if (h.length() == 0)
			throw new NumberFormatException("空值。");
		long v = 0;
		for (int i = offset; i < offset + len; i++) {
			v = (v << 4);
			char c = h.charAt(i);
			if (c >= '0' && c <= '9')
				v = v | (c - '0');
			else if (c >= 'a' && c <= 'f')
				v = v | ((c - 'a') + 10);
			else if (c >= 'A' && c <= 'F')
				v = v | ((c - 'A') + 10);
			else
				throw new NumberFormatException("格式错误。");
		}
		return v;
	}

	public static void ToTytes(byte[] bin, int offset, long value) {
		byte b;
		for (int i = 1; i <= 8; i++) {
			b = (byte) ((value >>> ((8 - i) * 8)) & 0xFF);
			bin[offset + i - 1] = b;
		}
	}

	public static long longFromBytes(byte[] bin, int start) {
		long v = 0L;
		for (int i = start; i < start + 8; i++)
			v = (v << 8) | (bin[i] & 0xFF);
		return v;
	}

}
