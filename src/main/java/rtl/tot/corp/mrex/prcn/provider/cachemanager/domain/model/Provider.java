package rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Provider
 */
@Data
@Document(collection = "provider")
public class Provider {

    @Id
    private ObjectId _id;
    private String rut;
    private String name;
    private String country;


}
