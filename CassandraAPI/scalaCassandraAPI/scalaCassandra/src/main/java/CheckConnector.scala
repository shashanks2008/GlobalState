import com.datastax.driver.core.{Cluster, ResultSet, Session}

/**
  * Created by s152134 on 1/11/2017.
  */
object CheckConnector {
  def main(args: Array[String]) {
    System.out.print("***** Cassandra - Scala Connection Tester ******")
    var cluster: Cluster = null
    var session: Session = null
    // Connect to the cluster and keyspace "ecommerce" 127.0.0.1:9042/9160
    cluster = Cluster.builder.addContactPoint("localhost").build
    session = cluster.connect("ecommerce")
    // Use insert statement
    System.out.println("Inserting into Cassandra Database...")
    session.execute("INSERT INTO products (pdt_id, cat_id, pdt_name, pdt_desc, price, shipping) VALUES (015,120, 'Sony HeadPhone 1', 'Sony HeadPhone 3d sound, Woofer', 135.00, 'Loud')")
    // Use select statement
    var pdtid: String = null
    var pdtname: String = null
    var pdtdesc: String = null
    var price: Float = 0
    // Use select statement
    val results: ResultSet = session.execute("SELECT * FROM products where pdt_id = 15")
    import scala.collection.JavaConversions._
    for (row <- results) {
      pdtid = Integer.toString(row.getInt("pdt_id"))
      pdtname = row.getString("pdt_name")
      pdtdesc = row.getString("pdt_desc")
      price = row.getFloat("price")
      System.out.println("Product ID: " + pdtid)
      System.out.println("Name: " + pdtname)
      System.out.println("Description: " + pdtdesc)
      System.out.println("Price: " + price)
    }
    // Clean up the connection by closing it
    cluster.close()
  }
}