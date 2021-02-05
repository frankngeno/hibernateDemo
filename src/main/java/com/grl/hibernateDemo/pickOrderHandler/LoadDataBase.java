package com.grl.hibernateDemo.pickOrderHandler;

import com.grl.hibernateDemo.dao.PickOrderRepository;
import com.grl.hibernateDemo.model.PickOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(PickOrderRepository pickOrderRepository) {

        return args -> {
            log.info("Preloading " + pickOrderRepository.save(new PickOrder("Frank","Ngeno",5,"customer")));
            log.info("Preloading " + pickOrderRepository.save(new PickOrder("Fabian", "Kip", 6, "Custome3")));
        };
    }
}
