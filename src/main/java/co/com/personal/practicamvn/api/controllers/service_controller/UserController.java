package co.com.personal.practicamvn.api.controllers.service_controller;


import co.com.personal.practicamvn.api.controllers.swagger_docs.UserControllerDoc;
import co.com.personal.practicamvn.api.dtos.UserDto;
import co.com.personal.practicamvn.api.dtos.security.ApiResponseDTO;
import co.com.personal.practicamvn.api.entities.User;
import co.com.personal.practicamvn.api.services.implementation.UserCrud;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userCrud")
@CrossOrigin(origins = "*")
public class UserController implements UserControllerDoc {
    private final ObjectMapper objectMapper;
    private final UserCrud userCrud;

    public UserController(ObjectMapper objectMapper, UserCrud userCrud) {
        this.objectMapper = objectMapper;
        this.userCrud = userCrud;
    }

    //FALLA EL INSERT; REVISAR PORQUE
    @PostMapping()
    public ResponseEntity<ApiResponseDTO<UserDto>> save(User user) {
        final User userSaved = userCrud.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.<UserDto>builder().code(HttpStatus.CREATED.value()).message("Client saved successfully").data(objectMapper.convertValue(userSaved, UserDto.class)).build());
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long id) {
        userCrud.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.builder().code(HttpStatus.OK.value()).message("User deleted successfully").build());
    }

    @PutMapping()
    public ResponseEntity<ApiResponseDTO<UserDto>> update(User user) throws EntityNotFoundException {
        return null;
    }

    @GetMapping(path = "/findUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ApiResponseDTO<List<UserDto>>> findUsers(
            @RequestParam(name = "id", required = false) final Long id,
            @RequestParam(name = "user", required = false) final String user,
            @RequestParam(name = "password", required = false) final String password,
            @RequestParam(name = "userCreate", required = false) final String userCreate,
            @RequestParam(name = "dateCreate", required = false) final String dateCreate)
            throws EntityNotFoundException {
        List<User> userList = userCrud.findByFilters(id, user, password, userCreate, dateCreate);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.<List<UserDto>>builder()
                .code(HttpStatus.OK.value()).message("Client list retrieved successfully")
                .data(userList.stream().map(
                        this::convertModelToDto
                ).collect(Collectors.toList())).build());
    }

    private UserDto convertModelToDto(User user) {
        return objectMapper.convertValue(user, UserDto.class);
    }

}
