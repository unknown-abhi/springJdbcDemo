package com.abhi.springjdbcdemo;

import com.abhi.springjdbcdemo.model.Alien;
import com.abhi.springjdbcdemo.repository.AlienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

        Alien alien = context.getBean(Alien.class);
        alien.setId(06);
        alien.setName("Abhi");
        alien.setAge(23);
        alien.setTechnology("Java");

        AlienRepository repository = context.getBean(AlienRepository.class);
        repository.save(alien);
        System.out.println(repository.findAll());
    }

}
