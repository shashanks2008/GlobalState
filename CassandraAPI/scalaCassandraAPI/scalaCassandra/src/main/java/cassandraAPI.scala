/**
  * Created by s152134 on 1/14/2017.
  */
import com.datastax.driver.core.{Cluster, ResultSet, Session}
object cassandraAPI {
  def main(args: Array[String]) {
    System.out.print("***** Cassandra - Scala Connection Tester ******")
    var cluster: Cluster = null
    var session: Session = null
    // Connect to the cluster and keyspace "Matrix" 127.0.0.1:9042/9160
    cluster = Cluster.builder.addContactPoint("localhost").build
    session = cluster.connect("Matrix")


    // Code for reading CSV
    val bufferedSource = scala.io.Source.fromFile("C:\\Big Data\\Data\\test.csv")
    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
     // println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}|${cols(4)}")
      // Use insert statement
      System.out.println("Inserting into Cassandra Database...")
      val queryPost = "INSERT INTO Matrix1(row_id, row_values, ts) VALUES (" + cols(0) +",[" +cols(1)+"," +cols(2)+"," +cols(3)+","+cols(4)+"],dateof(now()))"
      session.execute(queryPost)
    }
    bufferedSource.close

    val queryGet = "SELECT row_id, row_values FROM Matrix1"
    val results: ResultSet = session.execute(queryGet)
    import scala.collection.JavaConversions._
    var rowid:Int = 0
    for (row <- results)  {
      //println("row = " + row)
      rowid = row.getInt("row_id")
      //System.out.println("Row ID: " + rowid)
      val rowval = row.getList("row_values", classOf[Integer])

      //System.out.println("Row Values: " + rowval)
      //print(rowval(0).toDouble+ rowval(1).toDouble)
    }
    //session.execute(querySet)
    // Use select statement
//    var rowid:Int = 0


    // Clean up the connection by closing it
    cluster.close()
  }
}