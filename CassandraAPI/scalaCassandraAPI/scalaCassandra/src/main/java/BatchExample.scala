/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util

import com.datastax.driver.core.Cluster
import com.datastax.driver.core.Cluster.Builder
import org.apache.flink.api.common.typeinfo.TypeHint
import org.apache.flink.api.java.DataSet
import org.apache.flink.api.java.ExecutionEnvironment
import org.apache.flink.api.java.tuple.Tuple2
import org.apache.flink.api.java.typeutils.TupleTypeInfo
import org.apache.flink.batch.connectors.cassandra.CassandraInputFormat
import org.apache.flink.batch.connectors.cassandra.CassandraOutputFormat
import org.apache.flink.streaming.connectors.cassandra.ClusterBuilder
import java.util.ArrayList

/**
  * This is an example showing the to use the Cassandra Input-/OutputFormats in the Batch API.
  *
  * The example assumes that a table exists in a local cassandra database, according to the following query:
  * CREATE TABLE test.batches (number int, strings text, PRIMARY KEY(number, strings));
  */
object BatchExample {
//  private val INSERT_QUERY: String = "INSERT INTO test.batches (number, strings) VALUES (?,?);"
//  private val SELECT_QUERY: String = "SELECT number, strings FROM test.batches;"
//
//  /*
//       *	table script: "CREATE TABLE test.batches (number int, strings text, PRIMARY KEY(number, strings));"
//       */ @throws[Exception]
//  def main(args: Array[String]) {
//    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
//    env.setParallelism(1)
//    val collection: util.Collection[Tuple2[Integer, String]] = new util.ArrayList[Tuple2[Integer, String]](20)
//    var i: Int = 0
//    while (i < 20) {
//      {
//        collection.add(new Tuple2[Integer, String](i, "string " + i))
//      }
//      {
//        i += 1; i - 1
//      }
//    }
//    val dataSet: DataSet[Tuple2[Integer, String]] = env.fromCollection(collection)
//    dataSet.output(new CassandraOutputFormat[Tuple2[Integer, String]](INSERT_QUERY, (builder: Cluster.Builder) => builder.addContactPoints("127.0.0.1").build))
//    env.execute("Write")
//    val inputDS: DataSet[Tuple2[Integer, String]] = env.createInput(new CassandraInputFormat[Tuple2[Integer, String]](SELECT_QUERY, new ClusterBuilder() {
//      protected def buildCluster(builder: Cluster.Builder): Cluster = builder.addContactPoints("127.0.0.1").build
//    }), TupleTypeInfo.of(new TypeHint[Tuple2[Integer, String]]() {}))
//    inputDS.print()
//  }
}