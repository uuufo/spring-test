package co.codingnomads.deployment.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hello")
@Getter
@Setter
@NoArgsConstructor
public class Hello {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    private String now;

    public Hello(String name) {
        this.name = name;
    }
}