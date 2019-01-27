/*
 * Purpose : Learn about Java Networking. This programs lists the various network interfaces available on a machine
 * It also prints information available with a particular address
 * Date: 25-January-2019
 */

package sk.learns.networkInterfaces;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ListAllNetworkInterfaces {

	public static void main(String[] args) throws UnsupportedEncodingException {

		try {
			Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();
			NetworkInterface netwrkIntfce = null;
			InetAddress address = null;

			int i = 0;

			while (ni.hasMoreElements()) {
				netwrkIntfce = ni.nextElement();
				System.out.println("-----Network Interface # " + (i++) + " #-----");
				System.out.println("netwrkIntfce.getDisplayName() : " + netwrkIntfce.getDisplayName());
				System.out.println("netwrkIntfce.getName() : " + netwrkIntfce.getName());
				System.out.println("netwrkIntfce.getIndex() : " + netwrkIntfce.getIndex());
				System.out.println("netwrkIntfce.getMTU() : " + netwrkIntfce.getMTU());

				/* Converting the byte array to a String */
				byte[] bytes = netwrkIntfce.getHardwareAddress(); 
				try {
					System.out.println("Hardware Address : " + getHexForHardWareAddress(bytes));
				} catch (NullPointerException e) { // If no hardware is found, I get a NullPointerException which is being handled
					System.out.println("No Hardware Address found");
				}

				Enumeration<InetAddress> iNetEnmtr = netwrkIntfce.getInetAddresses();
				while (iNetEnmtr.hasMoreElements()) {
					address = iNetEnmtr.nextElement();
					System.out.println("\t address.getHostAddress() : " + address.getHostAddress());
					System.out.println("\t address.getHostName() : " + address.getHostName());
					System.out.println("\t address.getCanonicalHostName() : " + address.getCanonicalHostName());
				}
			}

		} catch (SocketException e) {
			e.printStackTrace();
		}

	}// EO main()

	private static StringBuilder getHexForHardWareAddress(byte[] bytes) {

		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x ", b));
		}
		return sb;
	}

} // EOC ListAllNetworkInterfaces
