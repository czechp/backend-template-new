package app.web.backendtemplate.foo;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class FooService {
    private final FooRepo fooRepo;


    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        System.out.println(fooRepo.findAll());
    }
}
