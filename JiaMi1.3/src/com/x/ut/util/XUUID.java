package com.x.ut.util;

import java.io.Serializable;
import com.x.ut.common.Converter;
import com.x.ut.common.runtime;
import com.x.ut.util.MD.MD5Pstring;

public class XUUID implements Serializable, Comparable<XUUID> {
	private static final long serialVersionUID = -775244657369049001L;

	public static final XUUID EmptyUUID = new XUUID(0L, 0L);

	private final long mostSigBits;
	private final long leastSigBits;

	private static final XRandom random;
	private static final long clipMbits;
	private static final long clipLbits;

	private XUUID(long mostBits, long leastBits) {
		this.mostSigBits = mostBits;
		this.leastSigBits = leastBits;
	}

	public static XUUID getNewXUUID() {
		long hostU = (new Object()).hashCode() & 0xFFFFFFFFL;
		hostU = (hostU << 32) | (hostU);
		long mbs = System.nanoTime() ^ hostU ^ clipMbits;
		long lbs = System.currentTimeMillis() ^ random.nextLong() ^ clipLbits;
		return new XUUID(mbs, lbs);
	}

	public static XUUID getNewXUUID(long mostBits, long leastBits) {
		return new XUUID(mostBits, leastBits);
	}

	public static XUUID getNewXUUID(String xUUIDString) {
		long mbs = Converter.longFromHexString(xUUIDString, 0, 16);
		long lbs = Converter.longFromHexString(xUUIDString, 16, 16);
		return new XUUID(mbs, lbs);
	}

	@Override
	public int hashCode() {
		long hilo = mostSigBits ^ leastSigBits;
		return ((int) (hilo >> 32)) ^ (int) hilo;
	}

	@Override
	public boolean equals(Object obj) {
		if ((null == obj) || (obj.getClass() != XUUID.class))
			return false;
		XUUID id = (XUUID) obj;
		return (mostSigBits == id.mostSigBits && leastSigBits == id.leastSigBits);
	}

	@Override
	public String toString() {
		return Converter.ToHexString(mostSigBits)
				+ Converter.ToHexString(leastSigBits);
	}

	public int compareTo(XUUID val) {
		return (this.mostSigBits < val.mostSigBits ? -1
				: (this.mostSigBits > val.mostSigBits ? 1
						: (this.leastSigBits < val.leastSigBits ? -1
								: (this.leastSigBits > val.leastSigBits ? 1 : 0))));
	}

	public long getLeastSignificantBits() {
		return leastSigBits;
	}

	public long getMostSignificantBits() {
		return mostSigBits;
	}

	public byte[] getBytes() {
		byte[] bin = new byte[16];

		return bin;
	}

	static {
		String hwinf = runtime.getLocalNetworkInterfacesHardwareDressList();
		if (hwinf == null)
			hwinf = generateNoNetworkID();
		MD5Pstring hwMd5 = new MD5Pstring(hwinf);
		byte[] hwbin = hwMd5.getDigest();
		clipMbits = Converter.longFromBytes(hwbin, 0);
		clipLbits = Converter.longFromBytes(hwbin, 8);
		random = new XRandom();
	}

	private static String generateNoNetworkID() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(Thread.currentThread().getId());
		sBuilder.append(runtime.getSysLineseparator());
		sBuilder.append(Thread.activeCount());
		sBuilder.append(runtime.getSysLineseparator());
		sBuilder.append(runtime.getSystemInfList());
		return sBuilder.toString();
	}

}
