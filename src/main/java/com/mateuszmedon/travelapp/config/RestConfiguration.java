package com.mateuszmedon.travelapp.config;

import com.mateuszmedon.travelapp.entity.City;
import com.mateuszmedon.travelapp.entity.Continent;
import com.mateuszmedon.travelapp.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

//    method make the respond from server will send id field
//    For all entity, default REST field is hidden
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

//        config.exposeIdsFor(Continent.class, Country.class, City.class...);
        config.exposeIdsFor(
                entityManager.getMetamodel().getEntities().stream()
                .map(Type::getJavaType)
                .toArray(Class[]::new));
    }
}
