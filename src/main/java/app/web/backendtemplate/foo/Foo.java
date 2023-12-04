package app.web.backendtemplate.foo;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foos")
@NoArgsConstructor
class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;

    Foo(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
