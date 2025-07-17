package org.example.identity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.example.identity.entity.User;

import java.io.Serializable;
@Getter
@Setter

public class UserDto implements Serializable {
    int id;
    String name;
    String email;
    String password;
}