package com.sda.movies.runners;

import com.sda.movies.model.Actor;
import com.sda.movies.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AddActorsRunner implements CommandLineRunner {

    private final ActorRepository actorRepository;

    @Autowired
    public AddActorsRunner(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            Actor actor1 = new Actor();
            actor1.setName("Tom");
            actor1.setSurname("Hanks");
            actorRepository.save(actor1);
    }
}
