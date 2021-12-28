package com.n11.thirdhomeworktarikcoskun94.dto;

import com.n11.thirdhomeworktarikcoskun94.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class UserDTO {

    @Id
    private String userId;
    private String userUsername;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String userPhoneNumber;

    public static UserDTO convertUserToUserDTO(User user) {

        return UserDTO.builder()
                .userId(user.getId())
                .userUsername(user.getUsername())
                .userName(user.getName())
                .userSurname(user.getSurname())
                .userEmail(user.getEmail())
                .userPhoneNumber(user.getPhoneNumber())
                .build();
    }

    public static User convertUserDTOToUser(UserDTO userDTO) {

        return User.builder()
                .username(userDTO.getUserUsername())
                .name(userDTO.getUserName())
                .surname(userDTO.getUserSurname())
                .email(userDTO.getUserEmail())
                .phoneNumber(userDTO.getUserPhoneNumber())
                .build();
    }
}
