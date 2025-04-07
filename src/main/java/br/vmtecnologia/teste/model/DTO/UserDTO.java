package br.vmtecnologia.teste.model.DTO;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import br.vmtecnologia.teste.model.User;

@EqualsAndHashCode
@NoArgsConstructor
public class UserDTO {

    private String email;
    private String name;

    public static UserDTO convertEntity(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(userDTO.getEmail());
        userDTO.setName(userDTO.getName());
        return userDTO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
