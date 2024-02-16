package co.com.personal.practicamvn.api.services.implementation;


import co.com.personal.practicamvn.api.entities.User;
import co.com.personal.practicamvn.api.repositories.UserCrudRepository;
import co.com.personal.practicamvn.api.services.UserCrudServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserCrud implements UserCrudServices {
    private final UserCrudRepository userCrudRepository;

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public void delete(Long id) throws EntityNotFoundException {
        if (userCrudRepository.findById(id).isPresent()) {
            userCrudRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("The client does not exist");
        }
    }

    public List<User> findByFilters(Long id, String user, String password, String userCreate, String dateCreate) throws EntityNotFoundException {
        return userCrudRepository.findByFilters(id,user, password, userCreate, dateCreate);
    }
}
