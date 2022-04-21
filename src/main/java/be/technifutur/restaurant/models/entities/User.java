package be.technifutur.restaurant.models.entities;

import be.technifutur.restaurant.models.entities.Restaurant;
import be.technifutur.restaurant.models.entities.Review;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "user_username", unique = true, nullable = false)
    private String username;

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_birthdate", nullable = false)
    private Date birthdate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    @ManyToMany(mappedBy = "favoriteOf")
    private List<Restaurant> favorites;

    private boolean isNotLocked = true;

    @ElementCollection(fetch = FetchType.EAGER)
    List<String> roles = new ArrayList<>();


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream()
                .map( SimpleGrantedAuthority::new )
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isNotLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isNotLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isNotLocked;
    }

    @Override
    public boolean isEnabled() {
        return isNotLocked;
    }

}
