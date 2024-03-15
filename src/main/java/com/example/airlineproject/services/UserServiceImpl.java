package com.example.airlineproject.services;

import com.example.airlineproject.data.models.User;
import com.example.airlineproject.data.repositories.UserRepository;
import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.utils.ApiResponse;
import com.example.airlineproject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private static final ModelMapper mapper = new ModelMapper();
    @Override
    public ApiResponse register(UserRegisterRequest registerRequest) {
        User user = mapper.map(registerRequest, User.class);
        userRepository.save(user);
        return GenerateApiResponse.create(GenerateApiResponse.REGISTER_SUCCESSFULLY);

    }
}
