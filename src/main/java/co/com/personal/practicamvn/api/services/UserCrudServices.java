package co.com.personal.practicamvn.api.services;


import co.com.personal.practicamvn.api.entities.User;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public interface UserCrudServices {
    User save(final User user);

    void delete(final Long id) throws EntityNotFoundException;

    List<User> findByFilters(Long id, String user, String password, String userCreate, String dateCreate)
            throws EntityNotFoundException;

    Optional<User> findByID(Long id) throws EntityNotFoundException;
}
