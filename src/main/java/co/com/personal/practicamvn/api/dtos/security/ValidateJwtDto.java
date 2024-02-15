package co.com.personal.practicamvn.api.dtos.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateJwtDto {
    private boolean isValidAccessToken;
}
