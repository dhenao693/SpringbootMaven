package co.com.personal.practicamvn.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
    private long id;
    private UserInfoContactDTO idUserInfo;
    private String password;
    private String user;
    private String userCreate;
    private String dateCreate;
}
