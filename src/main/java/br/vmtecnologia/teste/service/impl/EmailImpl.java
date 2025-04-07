package br.vmtecnologia.teste.service.impl;

import br.vmtecnologia.teste.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailImpl implements EmailService {

    @Override
    public void itsWork() {
        System.out.println("Email send successfull !");
    }

}
