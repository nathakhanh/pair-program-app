package com.thd.pairprogram.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBClient {

    public void getMongoDataSource() {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase mydatabase = mongoClient.getDatabase("thd-pair-program");
        FindIterable<Document> mydatabaserecords = mydatabase.getCollection("collectionName").find();
        MongoCursor<Document> iterator = mydatabaserecords.iterator();
        while (iterator.hasNext()) {
            Document doc = iterator.next();
            // do something with document
        }

    }
}
