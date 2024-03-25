package br.surb.com.br.dscommerce.shared.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldMessage implements Serializable {

    @Serial
    private static final long serialVersionUID = 2723399791602903670L;

    private String fildName;
    private String message;

}