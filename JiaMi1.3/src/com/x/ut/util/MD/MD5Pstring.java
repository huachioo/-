package com.x.ut.util.MD;

public class MD5Pstring extends MD5 {

	String inputString = null;

	public MD5Pstring(String input) {
		inputString = input;

	}

	public byte[] process() {
		if (inputString == null)
			return null;
		if (digest != null)
			return digest;
		byte[] bin = null;
		try {
			bin = inputString.getBytes("UTF8");
		} catch (Exception e) {

		}
		update(bin, bin.length);
		return end();
	}

	@Override
	public byte[] getDigest() {
		process();
		return super.getDigest();
	}

	@Override
	public String getStringDigest() {
		process();
		return super.getStringDigest();
	}
}
