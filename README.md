Step1, pull the code and run it
Step2, open swagger page:  http://localhost:8080/swagger-ui.html
      this step can prove use Swagger documentation for endpoints is preferred.
Step3, select a spec "login Interface" find the login-controller, press the 'post' button, then try it out and execute it,you will get the username"Frank"'s token.
   profile1: username: Frank, password:123456 , write access,admin role 
   profile2: username: employee, password:123456 , read access,normal role 
  This case can prove  JWT for public user which has a scope of READ 
Step4, copy the token ,then select a spec"JwtToken required Interface",fill the token in the header for below interface
1.person-controller GET /v1/get-person/{personId}
  P Path Variable value example: 1
  a.use Frank username'token and use default value(1), will request success,show success code 200 and data.
  This case can prove 1-1: This relationship is shown by the PersonInfo entity.

2.addreses-controller/ GET /v1/getAllAddresses
  Path Variable value example: 1
  a.use Frank username'token and put path Variable, will request success,show success code 200 and data.
  This case can prove: 1-many: This relationship is shown by Address entity. So one person can have many addresses.
  
3.club-controller GET /v1/getAllClubs/{cid}
   Path Variable value example: 2 and 3
  a.use Frank username'token and put path Variable, will request success,show success code 200 and data. 
   for cid=2 result
	  [
		  {
			"id": 2,
			"name": "ali",
			"personInfos": [
			  {
				"id": 1,
				"name": "fenglirong"
			  },
			  {
				"id": 2,
				"name": "Frank"
			  }
			]
		  }
	  ]
  for cid=3 result
	  [
	  {
		"id": 3,
		"name": "meituan",
		"personInfos": [
		  {
			"id": 2,
			"name": "Frank"
		  },
		  {
			"id": 3,
			"name": "zhangsan"
		  }
		]
	  }
	]
	cid =2 result or cid=3 result can approve , multi person can join one clubs.
	cid =2 result and cid=3 result both include name:"Frank" user,can approve same person can join many clubs.
  Include: Those cases can prove: Many-many: This relationship is shown by Club entity.So same person can join many clubs.
1.person-controller POST /v1/post-person
  request exapmle:id=10&name=test10
  a. use Frank username'token and use default value(id=10&name=test10), will request success,show success code 200.
  b. use employee username'token and use default value(id=10&name=test10) or put new value(id=11&name=test11) , will request fail ,show error code 500 ,message:Access Denied,please contact admin.
Those two case can prove write access and  for admin user only function.
  
2.person-controller GET /v1/get-person/{personId}
  Path Variable value example: 1
  a.use employee username'token and use default variable(1), request success,show success code 200.
  b.use Frank username'token and use default value(1), will request success,show success code 200. 
  Those two case can prove (Needs either READ or WRITE Access) for admin or public use
3.person-controller DELETE /v1/delete-person/{personId} 
   Path Variable value example: 1
  a.use Frank username'token and use default value(1), will request success,show success code 200.
     logon h2 use:http://localhost:8080/h2-console ,check the personinfo table ,you will see id =1 deleted.
  b.use employee username'token and fill existing id in database(id=2), will request fail ,show error code 500,message:Access Denied,please contact admin.
  Those two case can prove (Needs WRITE Access) for admin user only
Step5, run the test case,you will see test coverage.
   This step can prove Classes should have proper test coverage. 








