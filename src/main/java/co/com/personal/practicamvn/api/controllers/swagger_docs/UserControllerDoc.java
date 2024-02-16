package co.com.personal.practicamvn.api.controllers.swagger_docs;

import co.com.personal.practicamvn.api.dtos.UserDto;
import co.com.personal.practicamvn.api.dtos.security.ApiResponseDTO;
import co.com.personal.practicamvn.api.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Tag(name = "Users")
public interface UserControllerDoc {
    @Operation(summary = "Create a user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User created successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserDto.class))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<UserDto>> save(@RequestBody final User user);

    @Operation(summary = "Delete a user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client deleted successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ApiResponseDTO.class))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<Object>> delete(@PathVariable final Long id);

    @Operation(summary = "Update a user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client updated successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserDto.class))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<UserDto>> update(@RequestBody final User user) throws EntityNotFoundException;

    @Operation(summary = "Find a user by filters")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client list retrieved successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<List<UserDto>>> findUsers(
            @RequestParam(name = "id", required = false) final Long id,
            @RequestParam(name = "password", required = false) final String password,
            @RequestParam(name = "user", required = false) final String user,
            @RequestParam(name = "userCreate", required = false) final String userCreate,
            @RequestParam(name = "dateCreate", required = false) final String dateCreate
    ) throws EntityNotFoundException;



    @Operation(summary = "Find a user by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client retrieved successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))
                    }
            )
    })
    ResponseEntity<ApiResponseDTO<List<UserDto>>> findUserById(
            @RequestHeader("Host") final String hostName,
            @RequestParam(name = "id", required = false) final Long id
    ) throws EntityNotFoundException;
}