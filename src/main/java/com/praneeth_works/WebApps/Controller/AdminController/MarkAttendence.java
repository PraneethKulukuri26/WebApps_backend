package com.praneeth_works.WebApps.Controller.AdminController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praneeth_works.WebApps.Data.ResiveMarkAtt1;
import com.praneeth_works.WebApps.Data.ResiveMarkAtt2;
import com.praneeth_works.WebApps.Data.TestResponse;
import com.praneeth_works.WebApps.JDBC.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("/admin/attendece")
public class MarkAttendence {
	
	@PostMapping("/mark")
	public TestResponse attendece(@RequestBody ResiveMarkAtt1 recive) throws ClassNotFoundException, SQLException{
		return mark(recive);
	}
	
	private TestResponse mark(ResiveMarkAtt1 recive) throws ClassNotFoundException, SQLException {
		Connect con=new Connect();
		List<ResiveMarkAtt2> users=recive.getList();
		TestResponse res=new TestResponse();
		for(ResiveMarkAtt2 user:users) {
			ResultSet result=con.getData("select sil_points from users where uid="+user.getUid());
			if(result.next()) {
				int points=result.getInt("sil_points");
				if(user.isAttened()) {
					points+=40;
				}
				else {
					points-=20;
				}
				
				int x=con.insertData("update users set sil_points="+points+" where uid="+user.getUid());
			}
		}
		
		res.setCode(1);
		res.setMessage("Marked Attendence.");
		return res;
		
		
	}
}
