package com.example.library.management.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.library.management.app.entities.Account;

import jakarta.transaction.Transactional;

@Repository
public interface Accrepo extends JpaRepository<Account, Integer>{
	@Modifying
	@Transactional
    @Query(value="UPDATE account SET balance=balance+:money WHERE id=:id",nativeQuery = true)
    public double getbalan(long money,double balance,int id);
	@Query(value="select account_no from account where account_no=:account",nativeQuery = true)
	public Long getaccount_no(long account,int id);
	@Query(value="select balance from account where account_no=:account",nativeQuery = true)
	public double getBalanace(long account );	
	@Modifying
	@Transactional
	 @Query(value="UPDATE account SET balance=balance-:money WHERE id=:id",nativeQuery = true)
	    public double getbalance(long money,double bal,int id);
}
