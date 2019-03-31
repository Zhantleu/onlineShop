package kz.aa.shop.onlineShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usr", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    @Email(message = "*Пожалуйста введите правильный Email")
    @NotEmpty(message = "*Пожалуйста введите Email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Пароль должен содержать минимум 5 символов")
    @NotEmpty(message = "*Пожалуйста введите пароль")
    private String password;

    @Column(name = "name")
    @NotEmpty(message = "*Пожалуйста введите ваше Имя")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "*Пожалуйста введите вашу Фамилию")
    private String lastName;

    @Column(name = "country")
    @NotEmpty(message = "*Пожалуйста введите вашу Страну")
    private String country;

    @Column(name = "city")
    @NotEmpty(message = "*Пожалуйста введите ваш Город")
    private String city;

    @Column(name = "active")
    private boolean isActive;

    private LocalDateTime registrationDate;

    @Column(columnDefinition = "varchar(32) default 'USER'")
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}