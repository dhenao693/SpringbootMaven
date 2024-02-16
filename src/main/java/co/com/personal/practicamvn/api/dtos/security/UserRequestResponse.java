package co.com.personal.practicamvn.api.dtos.security;

import co.com.personal.practicamvn.api.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Data
public class UserRequestResponse implements Serializable {

    private static final long serialVersionUID = -979112439818239436L;

    private UserDto user;

    private HttpServletRequest request;
}
