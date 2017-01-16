package main.java

/**
  * Created by s152134 on 1/11/2017.
  */
/**
  * Created by s152134 on 1/7/2017.
  */

import java.lang.System.out

import com.datastax.driver.core.{Cluster, Metadata, Session}

/**
  * Class used for connecting to Cassandra database.
  */
class CassandraConnector {
  /** Cassandra Cluster. */
  private var cluster: Cluster = null
  /** Cassandra Session. */
  private var session: Session = null

  /**
    * Connect to Cassandra Cluster specified by provided node IP
    * address and port number.
    *
    * @param node Cluster node IP address.
    * @param port Port of cluster host.
    */
  def connect(node: String, port: Int) {
    this.cluster = Cluster.builder.addContactPoint(node).withPort(port).build
    val metadata: Metadata = cluster.getMetadata
    out.printf("Connected to cluster: %s\n", metadata.getClusterName)
    import scala.collection.JavaConversions._
    for (host <- metadata.getAllHosts) {
      out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter, host.getAddress, host.getRack)
    }
    session = cluster.connect
  }

  /**
    * Provide my Session.
    *
    * @return My session.
    */
  def getSession: Session = this.session

  /** Close cluster. */
  def close() {
    cluster.close()
  }
}