import com.datastax.driver.core.{Cluster, ResultSet, Session}

/**
  * Created by s152134 on 1/11/2017.
  */
object cassandraQuery {
  def main(args: Array[String]) {
    System.out.print("***** Cassandra - Scala Connection Tester ******")
    var cluster: Cluster = null
    var session: Session = null
    // Connect to the cluster and keyspace "Matrix" 127.0.0.1:9042/9160
    cluster = Cluster.builder.addContactPoint("localhost").build
    session = cluster.connect("Matrix")
    // Use insert statement
    System.out.println("Inserting into Cassandra Database...")
    session.execute("INSERT INTO Matrix1(row_id, row_values, ts) VALUES (1, [3, 2, 1],dateof(now()))")
    // Use select statement
    var rowid:Int = 0
    val results: ResultSet = session.execute("SELECT * FROM Matrix1 where row_id = 1")
    import scala.collection.JavaConversions._

    for (row <- results)  {
      println("row = " + row)
      rowid = row.getInt("row_id")
      System.out.println("Row ID: " + rowid)
      val rowval = row.getList("row_values", classOf[Integer])

      System.out.println("Row Values: " + rowval)
      //print(rowval(0).toDouble+ rowval(1).toDouble)
    }
    // Clean up the connection by closing it
    cluster.close()
  }
}