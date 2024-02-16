package co.com.personal.practicamvn.api.services.implementation;

import co.com.personal.practicamvn.api.entities.User;
import co.com.personal.practicamvn.api.entities.UserInfoContact;
import co.com.personal.practicamvn.api.repositories.UserInfoContactRepository;
import co.com.personal.practicamvn.api.services.UserInfoContactCrudServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserInfoContactCrud implements UserInfoContactCrudServices {
    private final UserInfoContactRepository userInfoContactRepository;
    @Override
    public UserInfoContact save(UserInfoContact userInfoContact) {
        return userInfoContactRepository.save(userInfoContact);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        if (userInfoContactRepository.findById(id).isPresent()) {
            userInfoContactRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("The client info does not exist");
        }
    }

    @Override
    public List<UserInfoContact> findByFilters(
            long id, String documentType, String documentNumber, String name, String lastName, String phone, String email,
            String userCreate, String dateCreate

    ) throws EntityNotFoundException {
        return null ; //userInfoContactRepository.save;
    }
}
