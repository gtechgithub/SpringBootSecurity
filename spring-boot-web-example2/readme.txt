Spring customized login module
--------------------------------

a) define the following tags for customized url, important part is implementing the form-login with login page and page to be shown 
   for the login failure, and incase of logout success url success url is shown.


   <security:form-login 
	        login-page="/login" 
	        authentication-failure-url="/login?error" 
	        default-target-url="/index" 
	        username-parameter="username" 
	        password-parameter="password"  
	        always-use-default-target="true"/>
	        <!--  login-processing-url="j_spring_security_check.action"-->
			
		<security:logout logout-success-url="/login?logout" />


b) defining the login html page, and here we use j_spring_security_check with username and password as j_username and j_password 

  <h2> login with user name and password</h2>
	
      <div th:if ="${error != null}">
			  <div class="error" th:text="${error}"> </div>
	    </div>
	    
	    <div th:if ="${msg != null}">
			  <div class="msg" th:text="${msg}"></div>
	    </div>
	    
	    <form th:action="@{/j_spring_security_check}" method="post">
			<input type='text' name='j_username' th:placeholder="username"/>
			<input type='password' name='j_password' th:placeholder="Password"/>
	        <button name="Submit" type="Submit" th:text="Login">
	        </button>
	        
	    </form>
