package nl.WonderGem.techItEasyWonderGem.service;

import nl.WonderGem.techItEasyWonderGem.dto.UserDto;
import nl.WonderGem.techItEasyWonderGem.dto.UserInputDto;
import nl.WonderGem.techItEasyWonderGem.exception.UsernameNotFoundException;
import nl.WonderGem.techItEasyWonderGem.mapper.UserMapper;
import nl.WonderGem.techItEasyWonderGem.model.User;
import nl.WonderGem.techItEasyWonderGem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repos;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.repos = userRepository;

        this.userMapper = userMapper;
    }

    public String saveUser(UserInputDto userInputDto) {

        User newUser = userMapper.userInputDtoToUser(userInputDto);

        return repos.save(newUser).getUsername();

    }

    public User getUser(String id){
        return repos.getReferenceById(id);
    }

    public Iterable<UserDto> getAllUsers(){
        List<User> reposUserList = repos.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user :
                reposUserList) {

            userDtos.add(userMapper.userToUserDto(user));

        }
        return userDtos;
    }

    public User updateUser(String username, UserInputDto userInputDto){

        if(repos.existsById(username) && username.equals(userInputDto.getUsername())) {
            return repos.getReferenceById(saveUser(userInputDto));
        } else {
            throw new UsernameNotFoundException("Username does not exist");
        }

    }

    public void deleteUser(String user){
        repos.deleteById(user);
    }
}
