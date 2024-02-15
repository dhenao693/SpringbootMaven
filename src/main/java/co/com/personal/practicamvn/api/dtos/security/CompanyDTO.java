package co.com.personal.practicamvn.api.dtos.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO implements Serializable {
    private static final long serialVersionUID = -2780880194250415564L;
    private Long id;
    private String timezone;
    private String name;
}
