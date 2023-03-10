/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ch.so.agi;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.flatgeobuf.FlatGeobufDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.simple.SimpleFeatureStore;
import org.opengis.feature.simple.SimpleFeatureType;

public class App {

    public static void main(String[] args) throws IOException {

        Map<String,Object> params = new HashMap();
        params.put("dbtype", "geopkg");
        params.put("database", "src/test/data/ch.so.agi.av_gb_administrative_einteilungen.gpkg");
        params.put("read-only", true);

        DataStore datastore = DataStoreFinder.getDataStore(params);
        
        System.out.println(datastore.getTypeNames());
        
        for (String typeName : datastore.getTypeNames()) {
            System.out.println(typeName);
        }
        
        
        SimpleFeatureSource fs = datastore.getFeatureSource("grundbuchkreise_grundbuchkreis");
        SimpleFeatureCollection fc = fs.getFeatures();
        System.out.println(fc.getBounds());
    
        File fgbFile = new File("/Users/stefan/tmp/grundbuchkreise_grundbuchkreis.fgb");
        Map<String, Serializable> fgbParams = new HashMap<>();
        fgbParams.put("url", fgbFile.toURI().toURL());
        FlatGeobufDataStoreFactory dataStoreFactory = new FlatGeobufDataStoreFactory();
        DataStore fgbDatastore = dataStoreFactory.createDataStore(fgbParams);
    
        SimpleFeatureType featureType = fc.getSchema();
        System.out.println(featureType.getCoordinateReferenceSystem());
        
        
        
        
        fgbDatastore.createSchema(featureType);
  
        System.out.println(fgbDatastore.getTypeNames()[0]);
        
        
        SimpleFeatureStore featureStore = (SimpleFeatureStore) fgbDatastore.getFeatureSource("grundbuchkreise_grundbuchkreis");
        featureStore.addFeatures(fc);

    
    }
}
