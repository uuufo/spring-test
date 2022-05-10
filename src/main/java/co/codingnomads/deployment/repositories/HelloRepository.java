package co.codingnomads.deployment.repositories;

import co.codingnomads.deployment.models.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, Long> {

    Hello findByName(String name);
}