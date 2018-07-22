package com.ie.naukri.elasticsearch.dao;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.elasticsearch.spark.sql.api.java.JavaEsSparkSQL;
import org.springframework.stereotype.Component;

@Component
public class TestSpark {

	public String isSparkWorking() {
		SparkSession sc = SparkWrapper.getSparkWrapper().getSparkSession();
		Dataset<Row> df = sc.read().parquet("/home/ravikatiyar/Downloads/untangle-vpn/resmanSampleParquet/");
		// Dataset<Row> df =
		// sc.read().json("/home/ravikatiyar/Downloads/untangle-vpn/hackedge_data.json");

		df.printSchema();

		// System.out.println("number of rows in parquet " + df.count());

		JavaEsSparkSQL.saveToEs(df, "resman_test/docs");

		return "Yes spark is working with the Spark Version: " + sc.version() + " es config "
				+ sc.conf().get("spark.es.index.auto.create");
	}

}
