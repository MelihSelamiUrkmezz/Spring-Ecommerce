package com.melihsurkmez.secondhand.ecommerce.DTO;

import com.melihsurkmez.secondhand.ecommerce.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component // Sor
public class UserResponseConverter {

    public UserResponse convert(User from){
        return new UserResponse(from.getFirstName(), from.getMiddleName(),from.getLastName(),from.getMail());
    }



}
