package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Confirmation;
import com.example.airlineproject.data.models.Passenger;
import com.example.airlineproject.data.repositories.ConfirmationRepository;
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

    private final ConfirmationRepository confirmationRepository;
    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public Passenger savePassenger(Passenger passenger) {
        if (passengerRepository.existsByEmailAddress(passenger.getEmailAddress())) throw new RuntimeException("Email Already Exist");
        passenger.setEnabled(false);
        passengerRepository.save(passenger);

        Confirmation confirmation = new Confirmation(passenger);
        confirmationRepository.save(confirmation);

        //TODO
        //send email to user with token
        emailService.sendSimpleMailMessage(passenger.getFullName(), passenger.getEmailAddress(), confirmation.getToken());
        return passenger;
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);
        Passenger passenger = passengerRepository.findByEmailAddressIgnoreCase(confirmation.getPassenger().getEmailAddress());
        passenger.setEnabled(true);
        passengerRepository.save(passenger);
        return Boolean.TRUE;
    }

    @Override
    public ApiResponse register(UserRegisterRequest registerRequest) throws UserException {
        if (passengerRepository.existsByEmailAddress(registerRequest.getEmailAddress())) {
            throw new UserException(GenerateApiResponse.CUSTOMER_ALREADY_EXIST);
        }
        Passenger passenger = mapper.map(registerRequest, Passenger.class);
//        passenger.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        passengerRepository.save(passenger);
        return GenerateApiResponse.create(GenerateApiResponse.REGISTER_SUCCESSFULLY);

    }
}
