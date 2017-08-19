package home.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import home.sys.Config;
import org.bson.Document;

/**
 * Created by roshanalwis on 8/17/17.
 */
public class MongoConnection {
    private static MongoClient mongoClient;

    private MongoConnection(){

    }

    public static MongoClient getMongoClient(){
        if(mongoClient == null){
            mongoClient = new MongoClient(Config.MONGO_HOST, Config.MONGO_PORT);
        }
        return mongoClient;
    }

    public static void close(){
        if(mongoClient != null){
            mongoClient.close();
            mongoClient = null;
        }
    }
}
