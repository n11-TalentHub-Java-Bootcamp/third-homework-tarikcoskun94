package com.n11.thirdhomeworktarikcoskun94.service;

import com.n11.thirdhomeworktarikcoskun94.dto.UserDTO;
import com.n11.thirdhomeworktarikcoskun94.entity.User;
import com.n11.thirdhomeworktarikcoskun94.exception.UserNotFoundException;
import com.n11.thirdhomeworktarikcoskun94.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final ProductCommentService productCommentService;

    public List<UserDTO> findAllUsers() {

        // This DTO list is for response.
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            userDTOList.add(UserDTO.convertUserToUserDTO(user));
        }

        return userDTOList;
    }

    public UserDTO findUserById(String id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User is not found by id: " + id));

        return UserDTO.convertUserToUserDTO(user);
    }

    public UserDTO saveUser(UserDTO userDTO) {

        User requestUser = UserDTO.convertUserDTOToUser(userDTO);
        User responseUser = userRepository.save(requestUser);

        return UserDTO.convertUserToUserDTO(responseUser);
    }

    public void deleteUserById(String id) {

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User is not found by id: " + id);
        }

        userRepository.deleteById(id);
        productCommentService.deleteProductCommentByUserId(id);
    }
}
