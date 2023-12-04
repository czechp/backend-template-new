package app.web.backendtemplate.foo;

import org.springframework.data.jpa.repository.JpaRepository;

interface FooRepo  extends JpaRepository<Foo, Long> {
}
