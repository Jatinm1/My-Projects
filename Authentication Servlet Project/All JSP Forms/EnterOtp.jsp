

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/styleso.css">
    <title>Enter OTP</title>
<!--     
    
    <script type ="text/javascript">

    window.history.pushState(null, null, 'login.jsp');

    </script> -->
</head>
<body>

   <!-- <input type="hidden" id ="status" value = "<%= request.getAttribute("status") %>"> -->
     <div class="container">
        <div class="box1">
        <div class="box-login" id="login">
            <div class="top-header">
                <h3>Enter OTP</h3>
            </div>
            <form method="post" action="ValidateOtp" class="register-form"
							id="login-form" autocomplete="off">
            <div class="input-group">
                <div class="lockicon"><img src="css/icons8-lock.svg" alt=""></div>
                <%
		  			if(request.getAttribute("message")!=null)
		  			{
		  				out.print("<p class='text-danger ml-1'>"+request.getAttribute("message")+"</p>");
		  			}
		  
		  %>
                 <!-- <div class="input-field">
                    <input type="email" name="uemail" id="uemail" class="input-box" required ="required">
                    <label for="username">Email address</label>
                 </div> -->
                 <div class="input-field">
                    <input type="text" name="otp" id="opt" class="input-box"  required ="required">
                    <label for="password">Enter OTP here</label>
                    <div class="eye-area">
                     <div  class="eye-box" onclick="myLogPassword()">
                      <i class="fa-regular fa-eye" id="eye"></i>
                      <i class="fa-regular fa-eye-slash" id="eye-slash"></i>
                   </div>
                 </div>
                 </div>
                 <div class="input-field">
                    <input type="submit" name="recover-submit" id="signin" class="input-submit" value="Submit OTP" required ="required">
                 </div>
            </div>

            <input type="hidden" class="hide" name="token" id="token"
										value="">
                 </form>

                 <div class="forgot">
                    <a href="login.jsp">Back to Login</a>
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

         if(a.type === "text"){
            a.type = "password";
            b.style.opacity = "0";
            c.style.opacity = "1";
         }else{
            a.type = "text";
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