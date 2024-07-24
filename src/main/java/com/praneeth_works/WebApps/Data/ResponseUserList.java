package com.praneeth_works.WebApps.Data;

import java.util.*;

import lombok.Data;

@Data
public class ResponseUserList {
	
	private int code;
	private String message;
	private List<ListUsers> list;

}
