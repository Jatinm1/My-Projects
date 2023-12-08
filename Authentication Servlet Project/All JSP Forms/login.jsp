<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setHeader("Expires", "0"); // Proxies
System.out.println(request.getAttribute("status"));


%>





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <title>The Andro Guide</title>
    
    
    <script type ="text/javascript">

    window.history.pushState(null, null, 'login.jsp');

    </script>
</head>
<body>

   <input type="hidden" id ="status" value = "<%= request.getAttribute("status") %>">
     <div class="container">
        <div class="box1">
        <div class="box-login" id="login">
            <div class="top-header">
                <h3>Hello, Again!</h3>
            </div>
            <form method="post" action="login" class="register-form"
							id="login-form" >
            <div class="input-group">
                 <div class="input-field">
                    <input type="email" name="uemail" id="uemail" class="input-box" required ="required">
                    <label for="username">Email address</label>
                 </div>
                 <div class="input-field">
                    <input type="password" name="pass" id="pass" class="input-box"  required ="required">
                    <label for="password">Password</label>
                    <div class="eye-area">
                     <div  class="eye-box" onclick="myLogPassword()">
                      <i class="fa-regular fa-eye" id="eye"></i>
                      <i class="fa-regular fa-eye-slash" id="eye-slash"></i>
                   </div>
                 </div>
                 </div>
                 <div class="input-field">
                    <input type="submit" name="signin" id="signin" class="input-submit" value="Log In" required ="required">
                 </div>
            </div>
                 </form>

                 <div class="forgot">
                    <a href="forgotPassword.jsp">Forgot password?</a>
                 </div>

                 <div class="bottom-footer-login">
                  <h4>New here ? <a href="registration.jsp">Register</a></h4>
              </div>
                
            </div>
         </div>
        </div>
        
   

     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
     <script type="text/javascript">
        


   // View Password codes

         
      
        function myLogPassword(){

         var a = document.getElementById("pass");
         var b = document.getElementById("eye");
         var c = document.getElementById("eye-slash");

         if(a.type === "password"){
            a.type = "text";
            b.style.opacity = "0";
            c.style.opacity = "1";
         }else{
            a.type = "password";
            b.style.opacity = "1";
            c.style.opacity = "0";
         }

        }
        var status = document.getElementById("status").value;

        
if(status == "failed"){
	swal("Sorry", "Wrong Username or Password","error");
}

else if(status == "invalidEmail"){
	swal("Sorry", "Email cannot be Empty","error");
}

else if(status == "invalidUpwd"){
	swal("Sorry", "Password cannot be Empty","error");
}
else if(status == "resetSuccess"){
	swal("Congrats", "Password changed Successfully","success");
}
else if(status == "resetFailed"){
	swal("Sorry", "Password Reset Failed","error");
}

     </script>
</body>
</html>