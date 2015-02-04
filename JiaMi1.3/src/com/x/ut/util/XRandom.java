package com.x.ut.util;

import java.util.concurrent.atomic.*;

public class XRandom {
	private final AtomicLong seed = new AtomicLong();
	private static final long multiplier = 0x5DEECE66DL;
	private static final long addend = 0xBL;
	private static final long mask = 0xFFFFFFFFFFFFL;
	private static final AtomicLong seedUniquifier = new AtomicLong(
			0x1ED8B55FAC9DECL);

	public XRandom() {
		setSeed(seedUniquifier() ^ System.nanoTime());
	}

	public XRandom(long seed) {
		this.setSeed(seed);
	}

	synchronized public void setSeed(long seed) {
		this.seed.set(seedScramble(seed));
	}

	public int nextInt() {
		return next(32);
	}

	public int nextInt(int bound) {
		if (bound <= 0)
			return -1;
		int n = next(31);
		int m = bound - 1;
		if ((bound & m) == 0) {
			n = (int) ((bound * (long) n) >> 31);
		} else {
			int u = n;
			n = u % bound;
			while (u - n + m < 0) {
				u = next(31);
				n = u % bound;
			}
		}
		return n;
	}

	public int nextInt(int lowBound, int topBound) {
		if ((topBound <= lowBound) || (lowBound <= 0))
			return -1;
		int bound = topBound - lowBound;
		return nextInt(bound) + lowBound;
	}

	public long nextLong() {
		return (((long) next(32)) << 32) + next(32);
	}

	public void nextBytes(byte[] bytes) {
		int i = 0, len = bytes.length, nint = 0, k = 0;
		while (i < len) {
			if (k <= 0) {
				k = 4;
				nint = nextInt();
			}
			bytes[i++] = (byte) nint;
			nint >>= 8;
			k--;
		}
	}

	public long getSeed() {
		return seed.get();
	}

	private int next(int bits) {
		long old, next;
		AtomicLong sd = this.seed;
		do {
			old = sd.get();
			next = (old * multiplier + addend) & mask;
		} while (!sd.compareAndSet(old, next));
		return (int) (next >>> (48 - bits));
	}

	private long seedUniquifier() {
		for (;;) {
			long curr = seedUniquifier.get();
			long update = curr * 0x285D320AD33FDB5L;
			if (seedUniquifier.compareAndSet(curr, update))
				return update;
		}
	}

	private long seedScramble(long seed) {
		long salt = super.hashCode() & 0xFFFFFFFFL;
		salt = (salt << 32) | salt;
		return (seed ^ multiplier ^ salt) & mask;
	}

}
