package proyecto.springboot.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.springboot.eventos.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    public User findByEmail(String email);
    
}
