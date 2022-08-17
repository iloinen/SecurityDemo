package app.services;

import app.models.AppUser;
import app.repos.AppUserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    private AppUserRepo repo;
    private PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        saveDefaultUser();

        return repo.findByUsername(username);
    }

    public void saveDefaultUser() {
        String pw = passwordEncoder.encode("user");
        repo.save(new AppUser("user", pw));
    }

}
