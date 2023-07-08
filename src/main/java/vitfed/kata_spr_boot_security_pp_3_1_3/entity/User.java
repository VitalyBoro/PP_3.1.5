package vitfed.kata_spr_boot_security_pp_3_1_3.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true)
    @Email
    private String username;
    @Column(name = "password", unique = true)
    private String password;
    @Column(name = "first_name")
    @NotEmpty(message = "Field cannot be empty")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Wrong format")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "Field cannot be empty")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Wrong format")
    private String lastName;
    @Column(name = "age")
    @NotNull(message = "Field cannot be empty")
    @Min(value = 1, message = "Age must be above 1")
    private int age;
    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, Integer age, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getRolesToString() {
        StringBuilder sb = new StringBuilder();
        for (Role role : roles) {
            sb.append(role);
            sb.append(" ");
        }
        return sb.toString();
    }
    public String roleToString() {
        return roles.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + username + '\'' +
                ", role=" + roles +
                '}';
    }
}
