package com.melihsurkmez.secondhand.ecommerce.DTO;

import lombok.Data;

@Data
public class CreateUserRequest {

    String firstName;
    String middleName;
    String lastName;
    String email;

}
