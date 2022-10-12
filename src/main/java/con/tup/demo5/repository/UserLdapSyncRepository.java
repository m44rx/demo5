package con.tup.demo5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import con.tup.demo5.entity.UserLdapSync;

@Repository
public interface UserLdapSyncRepository extends JpaRepository<UserLdapSync, Integer> {
    
    // @Query(value ="SELECT ul FROM UserLdapSync ul")
    // List<UserLdapSync> myUser();
}
