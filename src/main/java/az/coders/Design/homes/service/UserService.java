package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.security.UserDto;
import az.coders.Design.homes.models.UserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDto> getUsers();

    UserDto getUserById(Integer id);

    UserDto createUser(UserDto userDto);

    void deleteUser(Integer id);

    UserDto updateUser(Integer id, UserDto userDto);
    UserRequest updateUser(Integer id, UserRequest userRequest);
}
