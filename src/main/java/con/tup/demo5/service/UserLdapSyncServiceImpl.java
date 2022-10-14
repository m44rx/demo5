package con.tup.demo5.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import con.tup.demo5.entity.UserLdapSync;
import con.tup.demo5.repository.UserLdapSyncRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserLdapSyncServiceImpl implements UserLdapSyncService{
    
    private final List<String> groupUserAccess 
    = Arrays.asList("GESTORCONV","EJECUTIVO_TELEVENTAS","RF_TIENDAS");

    @Autowired
    private UserLdapSyncRepository repository;

    @Override
    public List<UserLdapSync> getUserxUserName() {

        return repository.findAll();
    }

    @Override
    public List<UserLdapSync> getUserxUserNameGroupName() {
        var miLista = repository.findAll();
    var resultado = miLista.stream()
        .filter(x -> groupUserAccess.contains(filterGroup(x.getUsername())))
        .collect(Collectors.toList());
        
        return resultado;
    }

    public String filterGroup(String userName){

        var sequence1 = userName.split(",");
        var sequence2 = sequence1[0].split("=");
        var sequence3 = sequence2[1].split("_", 3);

        return sequence3[2];
    }

    @Override
    public UserLdapSync getListUserWithAccesss(String username) {
        var rpta1 =  repository.encontrarPorUsername(username);
        log.warn("Respuesta de repositorio " );
        var rpta2 = filterGroup(rpta1.getUsername());

        if(!groupUserAccess.contains(rpta2)){
            throw new IllegalArgumentException("El usuario no esta dentro del grupo de acceso");
        }

        return rpta1;
        
    }

}
