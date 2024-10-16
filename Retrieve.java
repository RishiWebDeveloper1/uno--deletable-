import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;

public class Mongodb_connection_find_all_documents {
    public static void main(String args[]) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            DB db = mongoClient.getDB("testdb");
            DBCollection collection = db.getCollection("stucollec");
            DBCursor cursor = collection.find();
            
            try {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            } finally {
                cursor.close();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
