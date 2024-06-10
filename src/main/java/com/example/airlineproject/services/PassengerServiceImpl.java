package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Passenger;
import com.example.airlineproject.data.repositories.PassengerRepository;
import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.exceptions.UserException;
import com.example.airlineproject.utils.ApiResponse;
import com.example.airlineproject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final EmailService emailService;
    private static final ModelMapper mapper = new ModelMapper();


    @Override
    public ApiResponse register(UserRegisterRequest registerRequest) throws UserException {
        if (passengerRepository.existsByEmailAddress(registerRequest.getEmailAddress())) {
            throw new UserException(GenerateApiResponse.CUSTOMER_ALREADY_EXIST);
        }
        Passenger passenger = mapper.map(registerRequest, Passenger.class);
        passengerRepository.save(passenger);
        return GenerateApiResponse.create(GenerateApiResponse.REGISTER_SUCCESSFULLY);

    }
}
