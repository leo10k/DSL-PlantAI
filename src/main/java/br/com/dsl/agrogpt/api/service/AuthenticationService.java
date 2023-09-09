package br.com.dsl.agrogpt.api.service;

import br.com.dsl.agrogpt.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {


    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clienteRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado"));
    }
}
