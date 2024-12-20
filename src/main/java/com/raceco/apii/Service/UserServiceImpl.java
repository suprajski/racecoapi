package com.raceco.apii.Service;

import com.raceco.apii.Entity.Address;
import com.raceco.apii.Entity.City;
import com.raceco.apii.Entity.Role;
import com.raceco.apii.Entity.User;
import com.raceco.apii.Repository.AddressRepository;
import com.raceco.apii.Repository.CityRepository;
import com.raceco.apii.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

   @Autowired
   private CityRepository cityRepository;



    @Override
    public User addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User with this Email already exists.");
        }
        City city = cityRepository.findByCityNameAndPostcode(
                user.getAddress().getCity().getCityName(),
                user.getAddress().getCity().getPostcode()
        ).orElseGet(() -> cityRepository.save(user.getAddress().getCity()));

        // Set the city in the address
        Address address = user.getAddress();
        address.setCity(city);

        // Save the address
        address = addressRepository.save(address);

        // Set the address in the user
        user.setAddress(address);

        return userRepository.save(user);
    }

    public Optional<User> signIn(String email, String password) {
        return userRepository.findByEmailAndPasswordHash(email, password);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId ));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    @Override
    public List<User> getEmployees() {return userRepository.findByRoleIdNot(4L);}

   @Override
   public List<User> getUsersByRole(String roleName) {
        return userRepository.findByRoleRoleName(roleName);
   }

    @Override
    public void deleteUser(Long userId) { userRepository.deleteById(userId);}
}
