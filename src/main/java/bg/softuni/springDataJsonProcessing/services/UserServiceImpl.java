package bg.softuni.springDataJsonProcessing.services;

import bg.softuni.springDataJsonProcessing.dtos.UserDto;
import bg.softuni.springDataJsonProcessing.repositories.UserRepository;
import bg.softuni.springDataJsonProcessing.services.interfaces.UserService;
import bg.softuni.springDataJsonProcessing.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addAll(UserDto[] userDtos) {
        List<User> users = Arrays.stream(userDtos).map(dto -> modelMapper.map(dto, User.class)).toList();

        userRepository.saveAll(users);
    }
}
