package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Test
    void findUser() throws Exception {
        UserService userService = new UserService(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);

        userService.findUser("testuser");

        verify(preparedStatement).setString(1, "testuser");
        verify(preparedStatement).executeQuery();
    }
}
