package co.com.personal.practicamvn.api.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class User {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    @Column(name = "ID_USUARIO")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDUSUARIOINFOCONTACTO", referencedColumnName = "IDUSUARIOINFOCONTACTO")
    private UserInfoContact idUserInfo;

    @Column(name = "USUARIO")
    private String user;

    @Column(name = "CONTRASE\u00D1A")
    private String password;

    @Column(name = "USUARIO_CREACION")
    private String userCreate;

    @Column(name = "FECHA_CREACION")
    private String dateCreate;

}
