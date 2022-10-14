package con.tup.demo5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import con.tup.demo5.entity.UserLdapSync;

@Repository
public interface UserLdapSyncRepository extends JpaRepository<UserLdapSync, Integer> {
    
    @Query(value = "SELECT * FROM userldapsync WHERE group_name =:username", nativeQuery = true)
    List<UserLdapSync> encontrarMiMetodo(@Param("username") String username);

    @Query(value ="SELECT ul FROM UserLdapSync ul")
    List<UserLdapSync> myUser();

    @Query(value = "SELECT * FROM userldapsync WHERE group_name = :username", nativeQuery = true)
    UserLdapSync encontrarPorUsername(String username);
}
