package bg.softuni.springDataJsonProcessing.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UsersWrapperDto {
    @Expose
    private Integer usersCount;
    @Expose
    private List<UserWithSoldProductsWrapperDto> users;

    public UsersWrapperDto() {
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserWithSoldProductsWrapperDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProductsWrapperDto> users) {
        this.users = users;
    }
}
