package co.com.personal.practicamvn.api.services;

import co.com.personal.practicamvn.api.entities.UserInfoContact;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface UserInfoContactCrudServices {

    UserInfoContact save(final UserInfoContact userInfoContact);

    void delete(final Long id) throws EntityNotFoundException;

    List<UserInfoContact> findByFilters(
            long id, String documentType, String documentNumber, String name, String lastName, String phone, String email,
            String userCreate, String dateCreate

    )
            throws EntityNotFoundException;
}
