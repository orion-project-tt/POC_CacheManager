package rtl.tot.corp.mrex.prcn.provider.cachemanager.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.model.Provider;

@Repository
@Primary
public interface ProviderRepository extends MongoRepository<Provider, String> {

}
