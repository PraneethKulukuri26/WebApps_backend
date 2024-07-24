package com.praneeth_works.WebApps.Controller.AdminController;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praneeth_works.WebApps.Data.RecieveTestData;
import com.praneeth_works.WebApps.Data.TestResponse;
import com.praneeth_works.WebApps.JDBC.Connect;

@RestController
@RequestMapping("/admin")
public class AdminLogin {
	
	
	@PostMapping("/test")
	public TestResponse test(@RequestBody RecieveTestData recive) throws ClassNotFoundException, SQLException {
		return saveData(recive);
	}
	
	public TestResponse saveData(RecieveTestData recive) throws ClassNotFoundException, SQLException {
		Connect con=new Connect();
		TestResponse res=new TestResponse();
		int x=con.insertData("insert into users (`id`,`name`,`email`,`password`) value(\""+recive.getId()+"\",\""+recive.getName()+"\",\""+recive.getEmail()+"\",\""+recive.getPassword()+"\");");
		if(x>=1) {
			res.setCode(1);
			res.setMessage("Inserted");
		}else {
			res.setCode(-1);
			res.setMessage("error");
		}
		return res;
	}	
}
