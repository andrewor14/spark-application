
import java.sql.{Connection, DriverManager, ResultSet}

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.JdbcRDD

/**
 * Main application class.
 */
object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf
    val sc = new SparkContext(conf)
    val ip = sys.env("HANA_IP")
    val user = sys.env("HANA_USER")
    val password = sys.env("HANA_PASSWORD")
    val query = sys.env("HANA_QUERY")
    val url = s"jdbc:sap://$ip:30015/?autocommit=false"

    def connectToHana(): Connection = {
      DriverManager.getConnection(url, user, password)
    }

    def processResult(rs: ResultSet): Unit = { }

    // Connect to Hana through JDBC
    Class.forName("com.sap.db.jdbc.Driver")
    val rdd = new JdbcRDD(sc, connectToHana, query, 1, 1, 1, processResult)
    rdd.collect()

    println("Done.")
  }
}
