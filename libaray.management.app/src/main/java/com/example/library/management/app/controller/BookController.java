package com.example.library.management.app.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.management.app.entities.Account;
import com.example.library.management.app.entities.Book;
import com.example.library.management.app.repo.Accrepo;
import com.example.library.management.app.repo.Bookrepo;
//import com.example.library_management_app.Entities.Book;
//import com.example.library_management_app.Services.Bookservice;
import com.example.library.management.app.service.Bookservice;

import jakarta.annotation.PostConstruct;
@RestController
@RequestMapping("/Books")
public class BookController {
	
	@Autowired
   Bookservice service;
	private Book book;
    private Book Book;
    @Autowired
    Bookrepo repo;
    @Autowired
    Accrepo Arepo;
@GetMapping(value="/Welcome")
public String getwelcome()
{
	return "WELCOME TO MY BANK 101";
}
@PostMapping("/insert")
public String insert(@RequestBody Book book)
{
	this.book=book;
	return "Values Successfully inserted";
}
@GetMapping("/all")
public Book getAll()
{
	return book;
}
@PutMapping("/update")
public String update(@RequestBody Book book)
{
	this.book=book;
	return "Successfully update";
}
@GetMapping("/updatedvalue")
public Book getupdate()
{
	return book;
}
@DeleteMapping("/delete")
public String delete(@RequestBody Book book)
{
	this.book=book;
	return "Successfully delete";
}
@GetMapping("/deletedvalue")
public Book getdelete()
{
	return book;
}

@PostMapping("/add")
public String add(@RequestBody Book b)
{
	this.book=b;
	return "Values Successfully inserted";
}

@GetMapping("/sum/{a}/{b}")
public String getsum(@PathVariable int a,@PathVariable int b)
{
	
	return "sum=" +(a+b) ;
}

@GetMapping("/primeno/{a}")
public List<Integer> getprime(@PathVariable int a)
{
	int c=0;
	List<Integer> prime=new ArrayList<>();
//	int b[]=new int[a];
//	for(int k=0;k<a;k++)
//	{
	for(int i=1;i<=a;i++)
	{
		for(int j=1;j<=i;j++)
		{
			if(i%j==0)
			{
				c++;
			}
		}
		if(c==2)
		{
//			return i;
//			Integer num=i;
			prime.add(i);
			
		}
		c=0;
	}
//	}
	return prime;
 
}
@GetMapping("/search/{search}")
public String  getsearch(@PathVariable int search)
{
//	List<Integer> num=new ArrayList<>();
	int num[]=new int[100];
	for(int i=0;i<100;i++)
	{
		num[i]=i*2;
	}
	
 for(int i=0;i<100;i++)
 {
//	 num.add(i);
	if(num[i]==search)
	{
		return "ELEMENT IS PRESENT AT INDEX "+i;
	}
 }
	return "ELEMENT IS NOT PRESENT "+search;
}
@GetMapping("/sort")
public String getsort(@RequestParam List<Integer> num,@RequestParam int search)
{
//	List<Integer> sort=new ArrayList<>();
//	sort.add(a);
//	sort.add(b);
//	sort.add(c);
//	sort.add(d);
//	sort.add(e);
	int length=num.size();
	for(int i=0;i<length-1;i++)
	{
		for(int j=0;j<length-1-i;j++)
		{
			if(num.get(j)>num.get(j+1))
			{
				int temp=num.get(j);
				num.set(j, num.get(j+1))	;
				num.set(j+1, temp);				
			}
		}
		
	}
	int index=0;
	int c=0;
	for(int i=0;i<num.size();i++)
	{
		if(num.get(i)==search)
		{
			 index=i;
			 c++;
			break;
		}
	}
	if(c==1)
	{
		return num+" <br> Element is found at index "+index;
	}
//	System.out.println("ELEMENT IS FOUND AT INDEX "+index);
	else {
		return "ELEMENT IS NOT FOUND";
	}
//	List.sort(sort);
	
}
@GetMapping("/reverse")
public String getreverse(@RequestParam String name)
{
	String reverse="";
	int num=name.length();
	for(int i=num-1;i>=0;i--)
	{
		reverse=reverse+name.charAt(i);
	}
	return "Original string is:"+name+"<br>Reverse string is:"+reverse;
}
@GetMapping("/combinelists")
public List<Integer> getcombine(@RequestParam List<Integer> num,@RequestParam List<Integer> num1)
{
List<Integer> combine=new ArrayList<>();
for(int i=0;i<num.size()-1;i++)
{
	int mid=i;
	for(int j=i+1;j<num.size();j++)
	{
		if(num.get(j)>num.get(mid))
		{
			mid=j;
		}
	}
	int temp=num.get(i);
	num.set(i,num.get(mid));
	num.set(mid, temp);
	
	}
for(int i=0;i<num1.size()-1;i++)
{
	int mid=i;
	for(int j=i+1;j<num1.size();j++)
	{
		if(num1.get(j)>num1.get(mid))
		{
			mid=j;
		}
	}
	int temp=num1.get(i);
	num1.set(i,num1.get(mid));
	num1.set(mid, temp);
	
	}
num.addAll(num1);
for(int i=0;i<num.size();i++)
{
	combine.add(num.get(i));
}
//combine.add(num);
for(int i=0;i<combine.size()-1;i++)
{
	int mid=i;
	for(int j=i+1;j<combine.size();j++)
	{
		if(combine.get(j)<combine.get(mid))
		{
			mid=j;
		}
	}
	int temp=combine.get(i);
	combine.set(i,combine.get(mid));
	combine.set(mid, temp);
	
	}

return combine;
}

@GetMapping("/count")
public String getchar(@RequestParam String name)
{
	return service.getcount(name);
}
@GetMapping("/convert")
public String getconvert(@RequestParam List<String> num)
{
	return service.getarray(num);
}
@GetMapping("/exception/{a}/{b}")
public String getexception(@PathVariable int a,@PathVariable int b)
{
	return service.getoutput(a,b);
}
@GetMapping("/map")
public Map<String, String> getmap(@RequestParam Map<String, String> value)
{
return service.getoriginalmap(value);	
}
@PreAuthorize("hasRole('USER')")
@GetMapping("/credit/{id}/{account_no}/{money}")
public String getdeposite(@PathVariable int id,@PathVariable long account_no,@PathVariable long money)
{
	return service.getmoney(id,account_no,money);
}
@GetMapping("/debit/{id}/{account_no}/{money}")
@PreAuthorize("hasRole('USER')")
public String getwithdrow(@PathVariable int id,@PathVariable long account_no,@PathVariable long money)
{
	return service.withdrowmoney(id,account_no,money);
}
@GetMapping("/roman/{key}")
public String getRoman(@PathVariable String key)
{
	return service.getvalue(key);
}
@GetMapping("/root/{num}")
public String getroot(@PathVariable long num)
{
	return service.getRoot(num);
}
@GetMapping("/verifyotp/{otp}")
public String getotp(@PathVariable long otp)
{
	return service.getverify(otp);
}
@GetMapping("/binarysearch")
public String getelement( @RequestParam int num,@RequestParam List<Integer> list)
{
	return service.getsearch(num,list);
}
@PostMapping("/valueinsert")
public String  getinsert(@RequestBody Book book )
{
	this.book=book;
service.getinsert(book);
return "Successfully save";
}
@GetMapping("/display")
public Book getdisplay()
{
	return book;
}
@PostMapping("/data")
public String getdata(@RequestBody String text) throws IOException
{
//	this.text=text;
		return service.gettext(text);
	

}
@GetMapping("displaydata")
public String getdisplaydata() throws IOException
{
//	File file=new File("text.txt");
	FileReader reader=new FileReader("demo.txt");
//    StringBuilder data=new StringBuilder();
//	  int ch;
	
	BufferedReader br=new BufferedReader(reader);
	String Line;
	String text="";
      while((Line = br.readLine()) != null){
//          data.append((char) ch);
    	 text=text+ Line;
      }		
//      reader.close();
      return text;
//      return data.toString();
  
//	return read.read();
}
@GetMapping("/GETALL")
@PreAuthorize("hasRole('ADMIN')")
public List<Book> getbookall()
{
	return repo.findAll();
}
@GetMapping("/getalldata")
@PreAuthorize("hasRole('ADMIN')")
public List<Account> getdataall()

{
    return Arepo.findAll();   
}
}