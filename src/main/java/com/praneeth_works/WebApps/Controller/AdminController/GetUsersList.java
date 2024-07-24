package com.praneeth_works.WebApps.Controller.AdminController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praneeth_works.WebApps.Data.ListUsers;
import com.praneeth_works.WebApps.Data.ResponseUserList;
import com.praneeth_works.WebApps.JDBC.Connect;

@RestController
@RequestMapping("/admin/list")
public class GetUsersList {
	
	@GetMapping("/getList")
	public ResponseUserList getUsersList() throws ClassNotFoundException, SQLException {
		return getList();
	}
	
	private ResponseUserList getList() throws ClassNotFoundException, SQLException {
		Connect con=new Connect();
		ResultSet result=con.getData("select uid,name,id,branch from users");
		ResponseUserList responce=new ResponseUserList();
		List<ListUsers> list=new ArrayList<>();
		while(result.next()) {
			ListUsers user=new ListUsers();
			user.setId(result.getLong("id"));
			user.setName(result.getString("name"));
			user.setUid(result.getInt("uid"));
			user.setBrance(result.getString("branch"));
			list.add(user);
		}
		
		responce.setCode(1);
		responce.setMessage("Data fetched successfully.");
		responce.setList(list);
		return responce;
	}
}
