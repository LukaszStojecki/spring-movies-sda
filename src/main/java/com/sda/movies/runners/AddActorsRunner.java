package com.sda.movies.runners;

import com.sda.movies.model.Actor;
import com.sda.movies.repo.IAcotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AddActorsRunner implements CommandLineRunner {

    private final IAcotorRepository actorRepository;


    public AddActorsRunner(IAcotorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (actorRepository.count() == 0){
            Actor actor = new Actor();
            actor.setName("Cezary");
            actor.setSurname("Pazura");
            Actor actor1 = new Actor();
            actor1.setName("Cezary");
            actor1.setSurname("Zak");

            System.out.println(actor);
            System.out.println(actor1);
            actorRepository.save(actor);
            actorRepository.save(actor1);
        }
    }
}
