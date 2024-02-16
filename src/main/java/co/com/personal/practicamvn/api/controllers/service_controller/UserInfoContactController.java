package co.com.personal.practicamvn.api.controllers.service_controller;

import co.com.personal.practicamvn.api.dtos.UserInfoContactDTO;
import co.com.personal.practicamvn.api.dtos.security.ApiResponseDTO;
import co.com.personal.practicamvn.api.entities.UserInfoContact;
import co.com.personal.practicamvn.api.services.implementation.UserInfoContactCrud;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userInfoContacCrud")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserInfoContactController {
    private final ObjectMapper objectMapper;
    private final UserInfoContactCrud userInfoContactCrud;


    //------------------------------------/

    @PostMapping("/createUserInfo")
    public ResponseEntity<ApiResponseDTO<UserInfoContactDTO>> save(UserInfoContact userInfoContact) {

        final UserInfoContact userInfoContactSaved = userInfoContactCrud.save(userInfoContact);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.<UserInfoContactDTO>builder()
                .code(HttpStatus.CREATED.value()).message("Client saved successfully")
                .data(objectMapper.convertValue(userInfoContactSaved, UserInfoContactDTO.class)).build());
    }

    @DeleteMapping(path = "DeleteUserInfo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long id) {
        userInfoContactCrud.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.builder().code(HttpStatus.OK.value()).message("User deleted successfully").build());
    }

    @PutMapping("/updateUserInfo")
    public ResponseEntity<ApiResponseDTO<UserInfoContactDTO>> update(UserInfoContact userInfoContact) throws EntityNotFoundException {
        return null;
    }

    @GetMapping(path = "/findUsersInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ApiResponseDTO<List<UserInfoContactDTO>>> findUsers(
            @RequestParam(name = "id", required = false) final Long id,
            @RequestParam(name = "documentType", required = false) final String documentType,
            @RequestParam(name = "documentNumber", required = false) final String documentNumber,
            @RequestParam(name = "name", required = false) final String name,
            @RequestParam(name = "lastName", required = false) final String lastName,
            @RequestParam(name = "phone", required = false) final String phone,
            @RequestParam(name = "email", required = false) final String email,
            @RequestParam(name = "userCreate", required = false) final String userCreate,
            @RequestParam(name = "dateCreate", required = false) final String dateCreate
    )
            throws EntityNotFoundException {
        List<UserInfoContact> UserInfoContact = userInfoContactCrud.findByFilters(id, documentType, documentNumber, name, lastName, phone, email,
                userCreate, dateCreate);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.<List<UserInfoContactDTO>>builder()
                .code(HttpStatus.OK.value()).message("Client info list retrieved successfully")
                .data(UserInfoContact.stream().map(this::convertModelToDto).collect(Collectors.toList())).build());
    }

    private UserInfoContactDTO convertModelToDto(UserInfoContact user) {
        return objectMapper.convertValue(user, UserInfoContactDTO.class);
    }
}
