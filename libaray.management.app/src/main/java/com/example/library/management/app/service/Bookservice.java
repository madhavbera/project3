package com.example.library.management.app.service;

import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

//import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.library.management.app.entities.Account;
import com.example.library.management.app.entities.Book;
import com.example.library.management.app.repo.Accrepo;
import com.example.library.management.app.repo.Bookrepo;
//import com.example.library_management_app.Entities.Book;

import Exception.Exceptionhandle;

@Service
public class Bookservice  {
@Autowired
Bookrepo repo;
@Autowired
Accrepo repo1;
public List<Book> getAll()
{
	return repo.findAll();
}
//public ResponseEntity<?> insertvalue(String name,String author) {
//	// TODO Auto-generated method stub
//	return new ResponseEntity<Book>(repo.save(name),repo.save(author), HttpStatus.OK);
//}
public int getSum(@RequestBody int a,int b)
{
//	int a=5,b=6;
//	int sum=a+b;
	return a+b;
}
public String getcount(String name)
{
	int length=name.length();
	int vowel=0;
	int space=0;
	int consonent=0;
	for(int i=0;i<length;i++)
	{
		if(name.charAt(i)=='a' || name.charAt(i)=='e'||name.charAt(i)=='i'||name.charAt(i)=='o'||name.charAt(i)=='u')
		{
			vowel++;
		}
		else if(name.charAt(i)==' ')
		{
			space++;
		}
		else {
			consonent++;
		}
		
	}
	return "vowel:"+vowel+"<br>consonent:"+consonent+"<br>space:"+space;
}
public String getarray(List<String> num)
{
	String[] num1=num.toArray(new String[0] );
	return "String"+num1.toString();
}
public String getoutput(int a,int b)
{
	int c;
	try {
		 c=a/b;
	}catch(ArithmeticException e )
	{
		return "NUMBER cannot devided by Zero";
	}
		return "Devide of a/b is:"+c;
//	finally {
//			return "This block run anytime ";
//		}

}
public Map<String, String> getoriginalmap(Map<String, String> value)
{
	return value;
}
double balance=0;
Account ac=new Account();
public String getmoney(int id,long account_no,long money)
{
//	long balance=0;
	Long acc=repo1.getaccount_no(account_no,id);
	if(acc==null)    
	{
//		throw new NullPointerException("not found");
//		throw new Exceptionhandle("not found");
		
		return "not found";
	}
	else if(balance>=0)
	{
//		balance=balance+money;
//		repo1.save(new Account(balance));
//		ac.setId(id);
//		ac.setAccount_no(account_no);
//		ac.setBalance(balance);
//		ac.setName(name);
//		repo1.save(ac);
		repo1.getbalan(money,balance, id);
	}
	return "Rs "+money+" Credited from (TLC) \n"+" in your Ac "+account_no+" \n"
	
	+"on "+LocalDateTime.now()+" Avl BalRs "+repo1.getBalanace(account_no);
}
@ExceptionHandler(NullPointerException.class)
public ResponseEntity<?> getexception(NullPointerException ex)
{
	Map<String , Object> map=new HashMap<>();
	map.put("time:", LocalDateTime.now());
	map.put("Error occured",ex.getMessage());
	map.put("status", HttpStatus.NOT_FOUND);
	
	return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
}
public String withdrowmoney(int id,long account_no,long money)
{
//	long balance=0;
//	double bal=repo1.getBalanace(account_no);
	Long acc=repo1.getaccount_no(account_no,id);
	if(acc==null)    
	{
//		throw new NullPointerException("not found");
//		throw new NullPointerException("not found");
		
		return "not found";
	}
	else if(repo1.getBalanace(account_no)==0)
	{
//		balance=0;
		return "your balance is zero then you can not withdrow money";
	}
	else if(repo1.getBalanace(account_no)>=money)
	{
//		balance=balance-money;
//		ac.setId(id);
//		ac.setAccount_no(account_no);
//		ac.setBalance(balance);
//		ac.setName(name);
//		repo1.save(ac);
//		repo1.save(new Account(balance));
//		ac.setBalance(balance);
		repo1.getbalance(money,repo1.getBalanace(account_no), id);
		return "Rs "+money+" debited(CASH) in your \n Ac "+account_no+" on "+LocalDateTime.now()+" Avl BalRs "+repo1.getBalanace(account_no);
	}
	
//	else if(balance<money){
//		return "Withdrow is not possible because your balance is less than money<br>"
//	+"your balance is :"+balance+"<br>you want to withdrow money that is :"+money;
//		
//	}
	return "your balance is less than balance";
	}
public String getvalue(String key)
{
	Map<String ,Integer> map=new HashMap<String, Integer>();
	map.put("I", 1);
	map.put("II", 2);
	map.put("III", 3);
	map.put("IV", 4);
	map.put("V", 5);
	map.put("VI", 6);
	map.put("VII", 7);
	map.put("VIII", 8);
	map.put("IX", 9);
	map.put("X", 10);
	map.put("XI", 11);
	map.put("XII", 12);
	if(map.containsKey(key)) {
	return "Element is exist:"+map.get(key);
	}
	else {
		return "Roman value is not exist in memory";
	}
}
public String getRoot(long num)
{
	double root=Math.sqrt(num);
	return "Root:"+root;
}
public String getverify(long otp)
{
//    long num=0;
//    long n=otp;
//    while(n>0)
//    {
//    	long remain=n%10;
//    	num=num*10+remain;
//    	n=n/10;
//    	
//    }
	Random r=new Random();
	String num=String.valueOf(otp);
    int n=num.length();
	String ran="";
	for(int i=0;i<n;i++)
	{
		ran=ran+r.nextInt(n);
				
	}
//	System.out.println("Random number"+ran);
		if(num==ran)
	{
		return "Otp is Verify";
	}
	else
	{
		return "Not verified"+"<br>Please try again"+"<br>your otp is:"+ran;
	}
	}
public String getsearch(int num,List<Integer> list)
{
for(int i=1;i<list.size();i++)
{
	int temp=list.get(i);
	int j=i-1;
	while(j>=0&&list.get(j)>temp)
	{
		list.set(j+1, list.get(j));
		j--;
		
	}
	list.set(j+1, temp);
}
//int c=0;
//for(int i=0;i<list.size();i++)
//{
//	if(num==list.get(i))
//	{
//		return "Element is found at index :"+i;
//	}
//}
//
//	return  list+"Element is not found";
//
int upper=list.size();
int lower=0;
for(int i=0;i<list.size();i++)
{
	int mid=lower+(upper-lower)/2;
	if(num==list.get(mid))
	{
		return "Element is found at index :"+mid;
	}
	else if(list.get(mid)>num)
	{
		upper=mid-1;
	}
	else if(list.get(mid)<num)
	{
		lower=mid+1;
	}
}
return list+" Element is not found";
}
public void getinsert(Book book)
{
	repo.save(book);
}
public String gettext(  String text) throws IOException
{
	File file=new File("demo.txt");
	if(file.exists())
	{
		return "File is exsists";
	}
	else {
		file.createNewFile();
	}
//	FileWriter writer=new FileWriter(file);
//	writer.write(text);
	return "successfully written";
}
}
