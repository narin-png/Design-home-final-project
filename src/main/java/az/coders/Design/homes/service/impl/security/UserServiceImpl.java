package az.coders.Design.homes.service.impl.security;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.security.UserDto;
import az.coders.Design.homes.entity.User;
import az.coders.Design.homes.models.UserRequest;
import az.coders.Design.homes.repository.security.UserRepository;
import az.coders.Design.homes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EnhancedObjectMapper mapper;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
//    }
    @Override
    public List<UserDto> getUsers() {
        return mapper.convertList(userRepository.findAll(), UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer id) {
        return mapper.convertValue(findById(id), UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapper.convertValue(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return mapper.convertValue(userRepository.save(user), UserDto.class);
    }

    @Override
    public void deleteUser(Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDto) {
        User findUser = findById(id);
        User user = mapper.convertValue(userDto, User.class);
        user.setId(findUser.getId());
        user.setUsername(findUser.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return mapper.convertValue(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserRequest updateUser(Integer id, UserRequest userRequest) {
        User findUser = findById(id);
        User user = mapper.convertValue(userRequest, User.class);
        user.setId(findUser.getId());
        user.setUsername(findUser.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return mapper.convertValue(userRepository.save(user), UserRequest.class);
    }

    private User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("cant find user by id: " ));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
