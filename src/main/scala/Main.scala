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

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

/**
 * Entry point in test application for SPARK-8498.
 */
object Main {
  def main(args: Array[String]) {
    println("Running regression test for SPARK-8498.")
    val sc = new SparkContext("local", "testing")
    val hc = new HiveContext(sc)
    // This line should not throw scala.reflect.internal.MissingRequirementError.
    // See SPARK-8470 for more detail.
    val df = hc.createDataFrame(Seq(MyCoolClass("1", "2", "3")))
    df.collect()
    println("Regression test for SPARK-8498 success!")
  }
}
