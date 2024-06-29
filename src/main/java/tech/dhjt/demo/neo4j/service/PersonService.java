package tech.dhjt.demo.neo4j.service;

import java.util.Optional;

import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.dhjt.demo.neo4j.entity.Person;
import tech.dhjt.demo.neo4j.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Mono<Void> createRelationship(Long personId1, Long personId2) {
        // 首先加载两个Person实体
        Optional<Person> person1Mono = personRepository.findById(personId1);
        Optional<Person> person2Mono = personRepository.findById(personId2);

        Person p1 = person1Mono.orElse(Person.builder().name("张三").build());
        Person p2 = person2Mono.orElse(Person.builder().name("李华").build());
        p1.getKnows().add(p2);

        personRepository.save(p1);

        return null;
    }

}
