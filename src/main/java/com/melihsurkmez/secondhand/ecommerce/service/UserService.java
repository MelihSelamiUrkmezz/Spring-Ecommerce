package com.melihsurkmez.secondhand.ecommerce.service;

import com.melihsurkmez.secondhand.ecommerce.DTO.CreateUserRequest;
import com.melihsurkmez.secondhand.ecommerce.DTO.UpdateUserRequest;
import com.melihsurkmez.secondhand.ecommerce.DTO.UserResponse;
import com.melihsurkmez.secondhand.ecommerce.DTO.UserResponseConverter;
import com.melihsurkmez.secondhand.ecommerce.exception.UserNotFound;
import com.melihsurkmez.secondhand.ecommerce.model.User;
import com.melihsurkmez.secondhand.ecommerce.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserResponseConverter userResponseConverter;


    public UserService(UserRepository userRepository, UserResponseConverter userResponseConverter) {
        this.userRepository = userRepository;
        this.userResponseConverter = userResponseConverter;
    }

    private User findUserByEmail(String email){

        return userRepository.findBymail(email).orElseThrow(() -> new UserNotFound("User with email "+email+" not found!"));
    }

    public UserResponse getUserbyEmail(String email) {

        User user= findUserByEmail(email);
        return userResponseConverter.convert(user);

    }

    public UserResponse createUser(CreateUserRequest newUser) {

        User user= new User(newUser.getFirstName(),newUser.getMiddleName(),newUser.getLastName(),newUser.getEmail(),Boolean.TRUE);

        return userResponseConverter.convert(userRepository.save(user));

    }

    public UserResponse updateUser(String email,UpdateUserRequest updatedUser) {

            User user = findUserByEmail(email);
            if(user.getIsActive()){
                User newUser = new User(user.getId(),updatedUser.getFirstName(),updatedUser.getMiddleName(),updatedUser.getLastName(),email,user.getIsActive());
                return userResponseConverter.convert(userRepository.save(newUser));
            }

        throw new UserNotFound("User is not active!");

    }

    public void deactiveUser(String email) {
        User user = findUserByEmail(email);
        changeActivateUser(user.getId(),Boolean.FALSE);
    }

    public void deleteUserbyEmail(String email) {

        User user= findUserByEmail(email);
        userRepository.deleteById(user.getId());

    }
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userResponseConverter::convert).collect(Collectors.toList());}

    public void activateUser(String email) {
        User user = findUserByEmail(email);
        changeActivateUser(user.getId(),Boolean.TRUE);
    }
    private void changeActivateUser(Long id, Boolean isActive){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("User with id "+id+" not found!"));
        User newUser=new User(user.getId(),user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getMail(),isActive);
        userRepository.save(newUser);
    }

}
