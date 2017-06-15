package com.language.word.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Administrator on 2017/6/5.
 */
public class IpUtil {
    public static String getLocalHostAddr(){

        Enumeration allNetInterfaces;

        Vector<String> ipAddr = new Vector<String>();

        String ipLocalAddr = null;

        try {

            allNetInterfaces = NetworkInterface.getNetworkInterfaces();

            while (allNetInterfaces.hasMoreElements())    {

                NetworkInterface netInterface = (NetworkInterface)

                        allNetInterfaces.nextElement();

                System.out.println(netInterface.getName()+"====Name");

//                if(!"wlan0".equals(netInterface.getName())){
//                    continue;
//                }
                Enumeration addresses = netInterface.getInetAddresses();

                while (addresses.hasMoreElements())     {

                    InetAddress ip = (InetAddress) addresses.nextElement();

                    ipAddr.add(ip.toString());

                    if (ip != null && ip instanceof Inet4Address) //IP是ipv4，ipv6换成Inet6Address

                    {

                        ipLocalAddr = ip.getHostAddress();

                        System.out.println("本机的IP =" + ipLocalAddr);

                        System.out.println("hostAddress===="+ipLocalAddr.equals("127.0.0.1"));

                        if(!ipLocalAddr.equals("127.0.0.1")  && !ipLocalAddr.equals("/127.0.0.1")){                    ipLocalAddr = ip.toString().split("[/]")[1];       //得到本地IP

                        }

                        System.out.println(ipLocalAddr+"===============ipLocalAddr");

                    }

                }

            }

        } catch (SocketException e) {

            e.printStackTrace();

        }

        return ipLocalAddr;

    }

}
