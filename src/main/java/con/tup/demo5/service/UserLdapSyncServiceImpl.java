package con.tup.demo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import con.tup.demo5.entity.UserLdapSync;
import con.tup.demo5.repository.UserLdapSyncRepository;

@Service
public class UserLdapSyncServiceImpl implements UserLdapSyncService{
    
    @Autowired
    private UserLdapSyncRepository repository;

    @Override
    public List<UserLdapSync> getUserxUserName() {

        return repository.findAll();
    }

    @Override
    public List<UserLdapSync> getUserxUserNameGroupName() {
        
        // return repository.findAll();
        return repository.myUser();
    }


}
