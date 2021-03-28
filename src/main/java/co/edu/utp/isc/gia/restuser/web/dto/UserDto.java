package co.edu.utp.isc.gia.restuser.web.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserDto implements Serializable{
    
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;

}