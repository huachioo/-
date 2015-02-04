package com.x.ut.common;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public final class runtime {
	static final String Java_Version;
	static final String Java_Vendor;
	static final String Java_VendorUrl;
	static final String Java_Home;
	static final String Java_ClassVersion;
	static final String Java_ClassPath;
	static final String OS_Name;
	static final String OS_Arch;
	static final String OS_Version;
	static final String Sys_FileSeparator;
	static final String Sys_PathSeparator;
	static final String Sys_LineSeparator;
	static final String Sys_UserName;
	static final String Sys_UserHome;
	static final String Sys_UserDir;
	static final String Sys_LocalHostName;

	private runtime() {

	}

	static {

		Java_Version = System.getProperty("java.version");
		Java_Vendor = System.getProperty("java.vendor");
		Java_VendorUrl = System.getProperty("java.vendor.url");
		Java_Home = System.getProperty("java.home");
		Java_ClassVersion = System.getProperty("java.class.version");
		Java_ClassPath = System.getProperty("java.class.path");
		OS_Name = System.getProperty("os.name");
		OS_Arch = System.getProperty("os.arch");
		OS_Version = System.getProperty("os.version");
		Sys_FileSeparator = System.getProperty("file.separator");
		Sys_PathSeparator = System.getProperty("path.separator");
		Sys_LineSeparator = System.getProperty("line.separator");
		Sys_UserName = System.getProperty("user.name");
		Sys_UserHome = System.getProperty("user.home");
		Sys_UserDir = System.getProperty("user.dir");
		String hsname = null;
		try {
			InetAddress nAddress = InetAddress.getLocalHost();
			hsname = nAddress.getHostName();
		} catch (UnknownHostException e) {
			hsname = null;
			// e.printStackTrace();
		}
		Sys_LocalHostName = hsname;
	}

	public static String getSystemInfList() {
		StringBuilder sBuilder = new StringBuilder();
		appendKeyValueLine(sBuilder, "java.version", Java_Version);
		appendKeyValueLine(sBuilder, "java.vendor", Java_Vendor);
		appendKeyValueLine(sBuilder, "java.vendor.url", Java_VendorUrl);
		appendKeyValueLine(sBuilder, "java.home", Java_Home);
		appendKeyValueLine(sBuilder, "java.class.version", Java_ClassVersion);
		appendKeyValueLine(sBuilder, "java.class.path", Java_ClassPath);
		appendKeyValueLine(sBuilder, "os.name", OS_Name);
		appendKeyValueLine(sBuilder, "os.arch", OS_Arch);
		appendKeyValueLine(sBuilder, "os.version", OS_Version);
		appendKeyValueLine(sBuilder, "file.separator", Sys_FileSeparator);
		appendKeyValueLine(sBuilder, "path.separator", Sys_PathSeparator);
		sBuilder.append("line.separator:\t");
		for (int i = 0; i < Sys_LineSeparator.length(); i++) {
			char endl = Sys_LineSeparator.charAt(i);
			switch (endl) {
			case '\r':
				sBuilder.append("\\r");
				break;
			case '\n':
				sBuilder.append("\\n");
				break;
			default:
				sBuilder.append(((int) endl));
				break;
			}
			if (i < Sys_LineSeparator.length() - 1)
				sBuilder.append("  ");
		}
		sBuilder.append(Sys_LineSeparator);
		appendKeyValueLine(sBuilder, "user.name", Sys_UserName);
		appendKeyValueLine(sBuilder, "user.home", Sys_UserHome);
		appendKeyValueLine(sBuilder, "user.dir", Sys_UserDir);
		appendKeyValueLine(sBuilder, "LocalHostName",
				Sys_LocalHostName == null ? "" : Sys_LocalHostName);
		return sBuilder.toString();
	}

	public static String getSystemInfListDetail() {
		Properties props = System.getProperties();
		Enumeration<?> names = props.propertyNames();
		StringBuilder sBuilder = new StringBuilder();
		Object kObject;
		while (names.hasMoreElements()) {
			kObject = names.nextElement();
			if (kObject == null)
				continue;
			String v = props.getProperty(kObject.toString());
			if (v == null)
				continue;
			sBuilder.append(kObject);
			sBuilder.append(":\t");
			if ("line.separator".compareTo(kObject.toString()) == 0) {
				for (int i = 0; i < v.length(); i++) {
					char endl = v.charAt(i);
					switch (endl) {
					case '\r':
						sBuilder.append("\\r");
						break;
					case '\n':
						sBuilder.append("\\n");
						break;
					default:
						sBuilder.append(((int) v.charAt(i)));
						break;
					}
					if (i < v.length() - 1)
						sBuilder.append("  ");
				}
			} else
				sBuilder.append(v);
			sBuilder.append(runtime.getSysLineseparator());
		}
		appendKeyValueLine(sBuilder, "LocalHostName", Sys_LocalHostName);
		return sBuilder.toString();
	}

	public static String getSystemEnv() {
		StringBuilder sBuilder = new StringBuilder();
		Map<String, String> envs = System.getenv();
		for (Entry<String, String> v : envs.entrySet()) {
			appendKeyValueLine(sBuilder, v.getKey(), v.getValue());
		}
		return sBuilder.toString();
	}

	static void appendKeyValueLine(StringBuilder sBuilder, String key,
			String value) {
		sBuilder.append(key);
		sBuilder.append(":\t");
		sBuilder.append(value);
		sBuilder.append(Sys_LineSeparator);
	}

	public static String getJavaVersion() {
		return Java_Version;
	}

	public static String getJavaVendor() {
		return Java_Vendor;
	}

	public static String getJavaVendorurl() {
		return Java_VendorUrl;
	}

	public static String getJavaHome() {
		return Java_Home;
	}

	public static String getJavaClassversion() {
		return Java_ClassVersion;
	}

	public static String getJavaClasspath() {
		return Java_ClassPath;
	}

	public static String getOsName() {
		return OS_Name;
	}

	public static String getOsArch() {
		return OS_Arch;
	}

	public static String getOsVersion() {
		return OS_Version;
	}

	public static String getSysFileseparator() {
		return Sys_FileSeparator;
	}

	public static String getSysPathseparator() {
		return Sys_PathSeparator;
	}

	public static String getSysLineseparator() {
		return Sys_LineSeparator;
	}

	public static String getSysUsername() {
		return Sys_UserName;
	}

	public static String getSysUserhome() {
		return Sys_UserHome;
	}

	public static String getSysUserdir() {
		return Sys_UserDir;
	}

	public static String getLocalNetworkInterfacesHardwareDressList() {
		Enumeration<NetworkInterface> faces = null;
		try {
			faces = NetworkInterface.getNetworkInterfaces();
		} catch (Exception e) {
			return null;
		}
		StringBuilder sBuilder = new StringBuilder();
		int idx = 0;
		while (faces.hasMoreElements()) {
			NetworkInterface nf = faces.nextElement();
			String macstr = "";
			try {
				byte[] macbin = nf.getHardwareAddress();
				macstr = macbin == null ? "" : Converter.ToHexString(macbin);
			} catch (Exception e) {
				macstr = "";
			}
			if (macstr.length() > 0) {
				idx++;
				sBuilder.append('{');
				sBuilder.append(macstr);
				sBuilder.append('}');
			}
		}
		if (idx == 0)
			return null;
		return sBuilder.toString();
	}

	public static String getLocalNetINFlist() {
		Enumeration<NetworkInterface> faces = null;
		try {
			faces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			return null;
		}
		if (faces == null)
			return null;
		//
		StringBuilder sBuilder = new StringBuilder(), dev = new StringBuilder();
		int idx = 0;
		while (faces.hasMoreElements()) {
			NetworkInterface nf = faces.nextElement();
			dev.delete(0, dev.length());
			sBuilder.append("设备：");
			sBuilder.append(idx++);
			sBuilder.append(runtime.getSysLineseparator());
			appendKeyValueLine(sBuilder, "DisplayName", nf.getDisplayName());
			appendKeyValueLine(sBuilder, "Name", nf.getName());
			appendKeyValueLine(sBuilder, "isVirtual",
					Boolean.toString(nf.isVirtual()));
			String isloopback = "false";
			try {
				if (nf.isLoopback())
					isloopback = "true";
			} catch (Exception e) {
				isloopback = "Error at get";
			}
			appendKeyValueLine(sBuilder, "isLoopback", isloopback);
			String ispop = "false";
			try {
				if (nf.isPointToPoint())
					ispop = "true";
			} catch (Exception e) {
				ispop = "Error at get";
			}
			appendKeyValueLine(sBuilder, "isPointToPoint:", ispop);
			String isup = "false";
			try {
				if (nf.isUp())
					isup = "true";
			} catch (Exception e) {
				isup = "Error at get";
			}
			appendKeyValueLine(sBuilder, "isUP", isup);
			//
			Enumeration<InetAddress> drss = nf.getInetAddresses();
			while (drss.hasMoreElements()) {
				InetAddress inetAddress = (InetAddress) drss.nextElement();
				dev.append('{');
				dev.append("CanonicalHostName:");
				dev.append(inetAddress.getCanonicalHostName());
				dev.append("; HostName:");
				dev.append(inetAddress.getHostName());
				dev.append("; HostAddress:");
				dev.append(inetAddress.getHostAddress());
				dev.append('}');
			}
			appendKeyValueLine(sBuilder, "InetAddresses", dev.toString());
			//
			String macstr = "";
			try {
				byte[] macbin = nf.getHardwareAddress();
				macstr = macbin == null ? "" : Converter.ToHexString(macbin);
			} catch (Exception e) {
				macstr = "";
			}
			appendKeyValueLine(sBuilder, "MAC", macstr);
		}
		if (idx == 0)
			return null;
		return sBuilder.toString();
	}
}
