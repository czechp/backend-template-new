package app.web.authentication;

import app.web.presistence.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.repository.Repository;

@Entity
@Table(name = AuthenticationConfiguration.USER_TABLE)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
class User extends BaseEntity {
    @NotNull
    @Length(min = 3)
    private String login;
    @Email
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;

    User(String login, String email) {
        this.login = login;
        this.email = email;
        this.role = UserRole.USER;
    }
}


interface UserRepository extends Repository<User, Long> {
    boolean existsByLoginOrEmail(String login, String email);

    void save(User user);
}
