package co.codingnomads.deployment.services;

import co.codingnomads.deployment.models.Hello;
import co.codingnomads.deployment.repositories.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class HelloService {

    @Autowired
    HelloRepository helloRepository;

    public Hello getHello() {
        Hello hello = helloRepository.findByName("CodingNomads");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        hello.setNow(LocalDateTime.now().format(formatter));
        return hello;
    }
}