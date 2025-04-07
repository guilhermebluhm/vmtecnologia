package br.vmtecnologia.teste.service.impl;

import jakarta.persistence.EntityManager;
import br.vmtecnologia.teste.model.DTO.UserDTO;
import br.vmtecnologia.teste.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.vmtecnologia.teste.repository.UserRepository;
import br.vmtecnologia.teste.service.UserService;
import br.vmtecnologia.teste.service.exception.ObjectNotFoundInSearch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EmailImpl email;

    @Override
    @Transactional
    public ResponseEntity<String> saveUser(User user) {
        try {
            this.entityManager.persist(user);
            this.email.itsWork();
            return ResponseEntity.status(HttpStatus.OK).body("Save successful!");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ObjectNotFoundInSearch(e.getMessage()).toString());
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> updateUser(String id, String email) {
        try{
            User existingUser = this.userRepository.findByIdWithJPQL(id);
            existingUser.setEmail(email);
            this.entityManager.merge(existingUser);
            this.email.itsWork();
            return ResponseEntity.ok("User updated successfully!");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ObjectNotFoundInSearch(e.getMessage()).toString());
        }
    }

    @Override
    public ResponseEntity<String> findById(String id) {
        try {
            User user = this.userRepository.findByIdWithJPQL(id);
            if (user != null)
                return ResponseEntity.ok(UserDTO.convertEntity(user).toString());
            else
                return ResponseEntity.badRequest().body(new ObjectNotFoundInSearch("Id not found: +" + id).toString());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ObjectNotFoundInSearch(e.getMessage()).toString());
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> findByCriteriaWithPageable(int page, int offset, String criteria) {

        try {
            Pageable pageable = PageRequest.of(page, offset);
            if (criteria == null) {
                Page<User> all = this.userRepository.findAll(pageable);
                List<User> content = all.getContent();

                Map<String, Object> response = new HashMap<>();
                response.put("data", content);
                response.put("page", all.getNumber());
                response.put("total elements", all.getTotalElements());
                response.put("total pages", all.getTotalPages());
                return ResponseEntity.status(HttpStatus.OK).body(response);

            } else {
                Page<User> data = this.userRepository.findByUserWithPageable(criteria, pageable);
                List<User> content = data.getContent();

                Map<String, Object> response = new HashMap<>();
                response.put("data", content);
                response.put("page", data.getNumber());
                response.put("total elements", data.getTotalElements());
                response.put("total pages", data.getTotalPages());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }
        catch (Exception e){
            Map<String, Object> response = new HashMap<>();
            response.put("Error!", new ObjectNotFoundInSearch(e.getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
}
