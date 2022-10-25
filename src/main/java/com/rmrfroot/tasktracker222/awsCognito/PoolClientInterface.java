package com.rmrfroot.tasktracker222.awsCognito;

import java.util.List;

public interface PoolClientInterface {
    public List<String> getUserInfo(String username);

    public void deleteUserByUsername(String username);
    public void updatePassword(String oldPassword, String newPassword, String accessToken, String username);
}
