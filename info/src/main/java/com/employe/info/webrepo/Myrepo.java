package com.employe.info.webrepo;
import org.springframework.beans.factory.BeanRegistrarDslMarker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.Entities.Employe;

//import com.employe.info.Employe;

//import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
@Repository
//@BeanRegistrarDslMarker
public interface Myrepo extends JpaRepository<com.employe.info.Zentity.Employe,Integer> {

}
