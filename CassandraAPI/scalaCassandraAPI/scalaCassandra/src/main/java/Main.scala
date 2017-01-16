package main.java

import java.lang.System._

/**
  * Created by s152134 on 1/11/2017.
  */
object Main {
  def main(args: Array[String]) {
    val client: CassandraConnector = new CassandraConnector
    val ipAddress: String = if (args.length > 0) args(0)
    else "localhost"
    val port: Int = if (args.length > 1) args(1).toInt
    else 9042
    out.println("Connecting to IP Address " + ipAddress + ":" + port + "...")
    client.connect(ipAddress, port)
    client.close()
  }
}
