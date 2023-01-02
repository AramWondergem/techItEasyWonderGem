package nl.WonderGem.techItEasyWonderGem.repository;

import nl.WonderGem.techItEasyWonderGem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
