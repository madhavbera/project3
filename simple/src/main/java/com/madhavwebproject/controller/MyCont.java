package com.madhavwebproject.controller;

import java.util.Arrays;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entities.Bca;
import com.Entities.Btech;
import com.Entities.Department;
import com.Entities.Dto;
import com.Entities.Employe;
import com.Entities.Example;
import com.Entities.Student;
import com.Entities.Userdetails;
import com.GlobalException.Exceptions;
//import com.madhav.testapi.fiegnclient.Myfiegnclient;
import com.madhavwebproject.service.Service;
import com.madhavwebproject.simple.repo.Bcarepo;
import com.madhavwebproject.simple.repo.Btechrepo;
import com.madhavwebproject.simple.repo.Deptrepo;
import com.madhavwebproject.simple.repo.Emprepo;
import com.madhavwebproject.simple.repo.Userdetailsrepo;
import com.madhavwebproject.simple.repo.examprepo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
//@ComponentScan(basePackages = "com.GlobalException")
@RequestMapping("/map")
public class MyCont {
	@Autowired
	Service service;
	@Autowired
	Emprepo repo;
	@Autowired
	Deptrepo repo1;
	@Autowired
	Bcarepo b;
	@Autowired
	Btechrepo b1;
	@Autowired
	examprepo emrepo;
	private final Userdetailsrepo userrepo;
	private final PasswordEncoder encoder;
	public MyCont(Userdetailsrepo user,PasswordEncoder encoder)
	{
		this.userrepo=user;
		this.encoder=encoder;
	}

	
	private String name;
	private int age;
	private Student st;
	@GetMapping("/hellow")
	public String getmessage()
	{
		return "Hellow user";
	}
	@GetMapping("/welcome")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getnewmessage()
	{
		return new ResponseEntity<>("Hellow admin",HttpStatus.OK);
	}
	@GetMapping("/sort")
	@PreAuthorize("hasRole('USER')")
	public String getinsertion(@RequestParam List<Integer> num,int n)
	{
		return service.getvalue(num,n);
	}
	@PostMapping("/Insertdata/{id}")
	
	public String insertdata(@RequestBody  Dto us,@PathVariable int id)
	{
		Userdetails user= new Userdetails();
		user.setId(id);
		user.setName(us.getName());
		user.setPassword(encoder.encode(us.getPassword()));
		user.setRoles(us.getRoles());
		userrepo.save(user);
		return "insert succesfully";
		
	}
	@GetMapping("/divide")
	@PreAuthorize("hasRole('USER')")
	public String getdivide()
	{
		int a=10/0;
		return "Hellow";
	}
//	@ExceptionHandler(ArithmeticException.class)
//	public ResponseEntity<?> handler(ArithmeticException ex)
//	{
//		Map<String,Object> map=new HashMap<>();
//		map.put("status", HttpStatus.BAD_REQUEST);
//		map.put("error", "Number cannot divisible by zero ");
//		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
//	}
	@GetMapping("/add/{a}/{b}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getadd(@PathVariable int a,@PathVariable int b) throws Exception
	{
		if(a!=0&&b==0)
		{
			throw new ArithmeticException("cannot divided by zero");
		}
		double sum=(double)a/b;//type casting(explicit type casting)
		 return ResponseEntity.ok("Division:"+sum);
//			return  
		

	}
	@GetMapping("/All")
	@PreAuthorize("hasRole('USER')")
	public List<Bca> getall()
	{
		return service.getfindall();
	}
	@GetMapping("/id/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Bca> getid(@PathVariable int id)
	{
		return ResponseEntity.ok(service.getbyid(id));
	}
	@GetMapping("/btechid/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Btech> getbtechid(@PathVariable int id)
	{
		return ResponseEntity.ok(service.getBtechid(id));
	}
//	@GetMapping("/deptid/{id}")
//	public 
	@GetMapping("/reverse/{name}")
	@PreAuthorize("hasRole('USER')")
	public String getreverse(@PathVariable String name)
	{
		String reverse="";
		for(int i=name.length()-1;i>-1;i--)
		{
			reverse=reverse+name.charAt(i);
		}
		return "Reverse:"+reverse;
	}
	@GetMapping("/foreignkeyid/{id}")
	public Optional<Employe> getbyid(@PathVariable int id)
	{
		return repo.findById(id);//.orElseThrow(()->new NullPointerException("not found "));
	}
	@GetMapping("/info")
//	public @Query("select * from Department d")
	public List<Department> info()
	{
		return repo1.getall();
	}
	@GetMapping("/deleteinfo")
	public String getdeleteinfo()
	{
		repo1.deleteall();
		return "delete successfully";
	}
	@GetMapping("/deletebca")
	public String deletebca()
	{
		b.deletebca();
		return "delete successfully";
	}
	@GetMapping("/getdata")
	public ResponseEntity<?> getbca()
	{
		if(b.findAll()==null)
		{
			return new ResponseEntity<>( "table is empty",HttpStatus.NOT_FOUND);
			
		}
		return ResponseEntity.ok("Table is not empty");
	}
	@PostMapping("/insertvalue")
	public String insert(@RequestBody Student st)
	{
		this.st=st;
//		Student st=new Student();
//		 st.setName(name);
//		st.setAge(age);
		return "value insert successfully";
	}
	@GetMapping("/display")
	public Student getdisplay()
	{
//		Student st=new Student();
		return st ;
	}
	@PutMapping("/update")
	public String update(@RequestBody Student st)
	{
		this.st=st;
		return "update successfully";
	}
	@GetMapping("/updatevalue")
	public Student getupdate()
	{
		return st;
	}
	@DeleteMapping("/delete")
	public String delete()
	{
		 st=null;
		return "Delete successfully";
		
	}
	@GetMapping("/deletevalue")
	public ResponseEntity<?> getdelete()
	{
		Map<String, Object> map=new HashMap<>();
		map.put("status:", HttpStatus.NOT_FOUND);
		map.put("error", "object is null");
		if(st==null)
		{
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>( st,HttpStatus.OK);
	}
//	@GetMapping("/getidd/{id}")
//	public Department getdep(@PathVariable int id)
//	{
//		if(repo1.getiddep(id)==null)
//		{
//			throw new NullPointerException("not found at id:"+id);
//		}
//		return repo1.getiddep(id);
//	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/getid/{id}")

	public Employe get(@PathVariable int id)
	{
		if(repo.getidemp(id)==null)
		{
			throw new NullPointerException("Not found at id:"+id);
		}
		return repo.getidemp(id);
	}
	@GetMapping("/department/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getbid(@PathVariable int id)
	{
		if(repo1.getiddeponly(id)==null)
		{
			throw new NullPointerException("not found");
		}
		return ResponseEntity.ok( repo1.getiddeponly(id));
	}
	@GetMapping("/countdeveloper")
	public ResponseEntity<?> getcount()
	{
		return ResponseEntity.ok("Number of data in table:"+emrepo.countdeveloper());
	}
	@GetMapping("/maximum")
	public ResponseEntity<?> getmax()
	{
		return ResponseEntity.ok("maximum value in the table :"+emrepo.findmax());
	}
	@GetMapping("/minimum")
	public ResponseEntity<?> getmin()
	{
		return ResponseEntity.ok("minimum value in the table :"+emrepo.findmin());
	}
	@GetMapping("/salary")
	public ResponseEntity<?> getdevsalary()
	{
		return ResponseEntity.ok("List is : "+ emrepo.getsalary());
	}
	@GetMapping("/name/{id}")
	public ResponseEntity<?> getnameofdept(@PathVariable int id)
	{
		if(emrepo.getname(id)==null)
		{
			throw new NullPointerException("not found");
		}
		return ResponseEntity.ok("name is :"+emrepo.getname(id));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getsalary/{salary}")

	public ResponseEntity<?> getNamebasedonsalary(@PathVariable double salary)
	{
		if(emrepo.getnameofsalary(salary)==null)
		{
			throw new NullPointerException("salary is not found");
		}
		return    ResponseEntity.ok( emrepo.getnameofsalary(salary));
	}
	
	@GetMapping("/allinfoabouturl")
	public ResponseEntity<?> getinfoab(HttpServletRequest request)
	{
		StringBuilder br=new StringBuilder();
	  	br.append("port number:").append(request.getServerPort()).append("<br>");
		br.append("local number:").append(request.getLocalPort()).append("<br>");
		br.append("path :").append(request.getServletPath()).append("<br>");
		br.append("client port:").append(request.getRemoteAddr()).append("<br>");
		Enumeration<String > headers=request.getHeaderNames();
		while(headers.hasMoreElements())
		{
			
			String header=headers.nextElement();
			br.append(header)
			.append(":")
			.append(request.getHeader(header));
			
		}
		return ResponseEntity.ok(br.toString());
	}
	@GetMapping("/array")
	@PreAuthorize("hasRole('USER')")
	public String  getarray(@RequestParam Integer[] arr)
	{
		List<Integer> list=Arrays.asList(arr);
		return "your list is :"+list;
	}
	@GetMapping("/list")
	@PreAuthorize("hasRole('ADMIN')")
	public String getlist(@RequestParam List<Integer> list)
	{
		Integer[] arr=list.toArray(new Integer[0]);
		return "Your array is:"+Arrays.toString(arr);
	}
	}
