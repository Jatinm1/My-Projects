<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/styles.css">
    <title>Register</title>
</head>
<body>

<input type="hidden" id ="status" value = "<%= request.getAttribute("status") %>">
     <div class="container">
        <div class="box">
        
          <div class="box-register" id="register">
            <div class="top-header">
                <h3>Sign Up, Now!</h3>
            </div>
            <form method="post" action="register" class="register-form"
							id="register-form">
            <div class="input-group">
                 <div class="input-field">
                    <input type="text" name="name" id="name" class="input-box" required = "required"/>
                    <label for="name">Username</label>
                 </div>
                 <div class="input-field">
                    <input type="email" name="email" id="email" class="input-box" required = "required"/>
                    <label for="regEmail">Email address</label>
                 </div>
                 <div class="input-field">
                    <input type="password" name="pass" id="pass" class="input-box"  required = "required"/>
                    <label for="pass">Password</label>
                    <div class="eye-area">
                      <div  class="eye-box" onclick="myReg1Password()">
                       <i class="fa-regular fa-eye" id="eye-1"></i>
                       <i class="fa-regular fa-eye-slash" id="eye-slash-1"></i>
                    </div>
                  </div>
                 </div>
                 <div class="input-field">
                    <input type="password" name="re_pass" id="re_pass" class="input-box" required = "required"/>
                    <label for="re-pass">Re-type Password</label>
                    <div class="eye-area">
                      <div  class="eye-box" onclick="myRegPassword()">
                       <i class="fa-regular fa-eye" id="eye-2"></i>
                       <i class="fa-regular fa-eye-slash" id="eye-slash-2"></i>
                    </div>
                  </div>
                 </div>
                 <div class="input-field">
                    <input type="tel" name="contact" id="contact" class="input-box"  required ="required"/>
                    <label for="regPassword">Phone</label>
                 </div>
           
                 <div class="input-field">
                    <input type="submit" name="signup" id="signup" class="input-submit" value="Register"/>
                 </div>
            </div>
            </form>

            <div class="bottom-footer">
                <h4>Already a Member ? <a href="login.jsp">Login</a></h4>
            </div>
         </div>
      
         
        </div>
        
     </div>

     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

     <script type="text/javascript">
        
     function myReg1Password(){
         var a = document.getElementById("pass");
         var b = document.getElementById("eye-1");
         var c = document.getElementById("eye-slash-1");

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

        function myRegPassword(){
    
         var d = document.getElementById("re_pass");
         var e = document.getElementById("eye-2");
         var f = document.getElementById("eye-slash-2");
         
         if(d.type === "password"){
            d.type = "text";
            e.style.opacity = "0";
            f.style.opacity = "1";
         }else{
            d.type = "password";
            e.style.opacity = "1";
            f.style.opacity = "0";
         }

        }



        var status = document.getElementById("status").value;
if(status == "success"){
	swal("Congratulations", "Your Account Created Succesfully","success");
	
}

else if(status == "invalidUname"){
	swal("Sorry", "Name cannot be Empty","error");
}

else if(status == "invalidEmail"){
	swal("Sorry", "Email cannot be Empty","error");
}
else if(status == "invalidUpwd"){
	swal("Sorry", "Password cannot be Empty","error");
}
else if(status == "invalidReUpwd"){
	swal("Sorry", "Re- Password cannot be Empty","error");
}
else if(status == "RepassNotSame"){
	swal("Sorry", "Re- Password should be same as Password","error");
}
else if(status == "invalidUmob"){
	swal("Sorry", "Phone Number is Required","error");
}
else if(status == "invalidUmobLength"){
	swal("Warning", "Phone Number should contain 10 Digits","warning");
}
else if(status == "userNotFound"){
	swal("Warning", "User Not Exists","warning");
}
else if(status == "sameUser"){
	swal("Warning", "User with this Email id already exists","warning");
}
     </script>
</body>
</html>