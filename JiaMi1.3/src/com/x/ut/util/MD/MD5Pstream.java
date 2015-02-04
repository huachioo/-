package com.x.ut.util.MD;

import java.io.InputStream;

public class MD5Pstream extends MD5 {
	private static final int BUFFER_SIZE = 1024;
	private InputStream in = null;

	public MD5Pstream(InputStream input) {
		in = input;
	}

	public byte[] process() throws Exception {
		if (digest != null)
			return digest;
		byte buffer[] = new byte[BUFFER_SIZE];
		int got = -1;
		while ((got = in.read(buffer)) > 0) {
			update(buffer, got);
		}
		return end();
	}
}
