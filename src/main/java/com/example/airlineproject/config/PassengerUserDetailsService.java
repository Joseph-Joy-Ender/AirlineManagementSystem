//package com.example.airlineproject.config;
//
//import com.example.airlineproject.data.models.Passenger;
//import com.example.airlineproject.data.repositories.PassengerRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//
//public class PassengerUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private  PassengerRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       Optional<Passenger> passenger = repository.findByFullName(username);
//      return passenger.map(PassengerUserDetails::new)
//               .orElseThrow(()->new UsernameNotFoundException("User not found "+username));
//
//    }
//}
