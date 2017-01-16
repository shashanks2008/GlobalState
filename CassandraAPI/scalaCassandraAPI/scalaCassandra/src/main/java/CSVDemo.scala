/**
  * Created by s152134 on 1/14/2017.
  */
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object CSVDemo extends App {
  println("row_id, row_values1, row_values2, row_values3, row_values4")
  val bufferedSource = scala.io.Source.fromFile("C:\\Big Data\\Data\\test.csv")
  for (line <- bufferedSource.getLines) {
    val cols = line.split(",").map(_.trim)
    // do whatever you want with the columns here
    println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}|${cols(4)}")
  }
  bufferedSource.close
}