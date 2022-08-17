package app.repos;

import app.models.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepo extends CrudRepository<AppUser, Long> {

    AppUser findByUsername(String username);

}
