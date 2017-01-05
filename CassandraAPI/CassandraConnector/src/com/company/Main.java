package com.company;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        final com.company.CassandraConnector client = new com.company.CassandraConnector();
        final String ipAddress = args.length > 0 ? args[0] : "localhost";
        final int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;
        out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
        client.connect(ipAddress, port);
        client.close();
    }
}
