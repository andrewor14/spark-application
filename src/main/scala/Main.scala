
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Main application class.
 */
object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf()
                 .setMaster("local[*]")
                 .setAppName("Best app ever")
    val sc = new SparkContext(conf)
    //...
    println("Done.")
  }
}
