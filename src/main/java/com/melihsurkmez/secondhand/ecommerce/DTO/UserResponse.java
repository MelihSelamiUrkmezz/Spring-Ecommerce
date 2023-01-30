package com.melihsurkmez.secondhand.ecommerce.DTO;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class UserResponse {
    @NonNull
    String firstName;
    @NonNull
    String middleName;
    @NonNull
    String lastName;
    @NonNull
    String mail;

    @NonNull
    Boolean isActive;


}
