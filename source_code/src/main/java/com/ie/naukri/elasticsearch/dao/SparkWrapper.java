package com.ie.naukri.elasticsearch.dao;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class SparkWrapper {

	private SparkWrapper(SparkSession session) {
		this.sparkSession = session;
		// this.javaSparkContext = jsc;
	}

	SparkSession sparkSession;
	// JavaSparkContext javaSparkContext;

	private static class SingleTonInstanceProvider {
		static SparkConf conf = new SparkConf().setMaster("local").setAppName("Spring boot spark example")
				.set("spark.driver.allowMultipleContexts", "true").set("spark.es.index.auto.create", "true")
				.set("spark.es.resource", "data_lab_test").set("spark.es.nodes", "localhost")
				.set("spark.es.port", "9200");

		static SparkSession sparkSession = SparkSession

				.builder()

				.config(conf)

				.getOrCreate();

		// static JavaSparkContext javaSparkContext = new JavaSparkContext(conf);

		private static final SparkWrapper instance = new SparkWrapper(sparkSession);

	}

	public static SparkWrapper getSparkWrapper() {
		return SingleTonInstanceProvider.instance;
	}

	public SparkSession getSparkSession() {
		return sparkSession;
	}

	public void setSparkSession(SparkSession sparkSession) {
		this.sparkSession = sparkSession;
	}

}
