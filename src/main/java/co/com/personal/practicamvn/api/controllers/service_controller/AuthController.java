package co.com.personal.practicamvn.api.controllers.service_controller;


import co.com.personal.practicamvn.api.controllers.swagger_docs.AuthControllerDocs;
import co.com.personal.practicamvn.api.dtos.security.ApiResponseDTO;
import co.com.personal.practicamvn.api.dtos.security.JwtDto;
import co.com.personal.practicamvn.api.utils.ClientAuthentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController implements AuthControllerDocs {

    @GetMapping()
    public ResponseEntity<ApiResponseDTO<JwtDto>> getAuthorization() {
        String token = ClientAuthentication.generateToken();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseDTO.<JwtDto>builder()
                        .code(HttpStatus.CREATED.value())
                        .message("Token created successfully")
                        .data(new JwtDto(token))
                        .build());
    }
}
