package bg.softuni.springDataJsonProcessing.services.interfaces;

import bg.softuni.springDataJsonProcessing.dtos.UserDto;

public interface UserService {
    void addAll(UserDto[] userDtos);
}
