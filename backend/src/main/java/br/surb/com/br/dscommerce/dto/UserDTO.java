package br.surb.com.br.dscommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5904887576085638970L;
    private String userId;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
}
