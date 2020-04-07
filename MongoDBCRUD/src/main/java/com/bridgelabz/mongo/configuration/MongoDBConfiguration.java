package com.bridgelabz.mongo.configuration;

import org.apache.log4j.Logger;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

public class MongoDBConfiguration {
	Logger logger = Logger.getLogger(MongoDBConfiguration.class);
	public MongoDatabase database;
	private static MongoClient mongoClient;

	public MongoDBConfiguration() {
	}

	public static MongoClient getInstance() {
		if (mongoClient == null) {
			CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
	                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
			return mongoClient;
		} else {
			return mongoClient;
		}
	}
	
	public MongoDatabase getDatabase(String databaseName) {
		database = mongoClient.getDatabase(databaseName);	
		return database;
	}
}
