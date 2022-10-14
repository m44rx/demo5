package con.tup.demo5.service;

import java.util.List;

import con.tup.demo5.entity.UserLdapSync;

public interface UserLdapSyncService {

    List<UserLdapSync> getUserxUserName();
    
    List<UserLdapSync> getUserxUserNameGroupName();

    UserLdapSync getListUserWithAccesss(String username);
}
