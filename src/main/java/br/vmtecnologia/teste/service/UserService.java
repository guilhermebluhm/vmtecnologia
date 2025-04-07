package br.vmtecnologia.teste.service;


import br.vmtecnologia.teste.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService {

    ResponseEntity<String> saveUser(User user);
    ResponseEntity<String> findById(String id);
    ResponseEntity<String> updateUser(String id, String email);
    ResponseEntity<Map<String, Object>> findByCriteriaWithPageable(int page, int offset, String criteria);


}
