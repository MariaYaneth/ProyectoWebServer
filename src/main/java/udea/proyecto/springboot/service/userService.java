package udea.proyecto.springboot.service;
import udea.proyecto.springboot.util.Messages;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import udea.proyecto.springboot.exception.BusinessException;
import udea.proyecto.springboot.model.User;
import udea.proyecto.springboot.repository.UserRepository;

@Service
public class userService {
	

    private UserRepository userRepository;
    private Messages messages;

    public userService(UserRepository userRepository, Messages messages){
        this.messages = messages;
        this.userRepository = userRepository;
    }

    public User getUser(long cedula){
        return userRepository.findById(cedula).get();
    }
    
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    
    public User addUser(User user){
        Optional<User> optionalUser = userRepository.findById(user.getCedula());
        if(optionalUser.isPresent()){
            throw new BusinessException(messages.get("exception.data_duplicate_name.user"));
        }
        return userRepository.save(user);
    }
}
