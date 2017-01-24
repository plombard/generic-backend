package io.placeholder.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pascal Lombard
 * @since 14/01/2017.
 */
@ApplicationScoped
public class MyMongo {

  private final Datastore datastore;

  @Inject
  public MyMongo() {
    Morphia morphia = new Morphia();
    morphia.mapPackage("io.placeholder.beans");

    // create the Datastore using credentials and data from environment
    String username = System.getenv
        ("OPENSHIFT_MONGODB_DB_USERNAME");
    String password = System.getenv
        ("OPENSHIFT_MONGODB_DB_PASSWORD");
    MongoCredential credential = MongoCredential.createCredential(username,
        "backend", password.toCharArray());
    List<MongoCredential> credentials = new ArrayList<>();
    credentials.add(credential);
    String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
    String port = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
    ServerAddress address = new ServerAddress(host, Integer.parseInt(port));
    datastore = morphia.createDatastore(new MongoClient(address, credentials),
        "backend");
    datastore.ensureIndexes();
  }


}
