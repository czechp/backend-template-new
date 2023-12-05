package app.web.authentication;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@AllArgsConstructor
@Validated
class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/users")
    void registerUser(@RequestBody @Valid RegisterUserBody body) {
        authenticationService.registerUser(body.login, body.email);
    }


    record RegisterUserBody(@NotNull @Length(min = 3) String login, @NotNull @Length(min = 3) String email) {
    }
}
