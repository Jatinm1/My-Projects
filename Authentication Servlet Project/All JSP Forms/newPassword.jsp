<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/newstyle.css">
    <title>Reset Password</title>
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
                <h3>Reset Your Password</h3>
            </div>
            <form method="post" action="newPassword" class="register-form"
							id="login-form" autocomplete="off">
            <div class="input-group">
                
             
                 <div class="input-field">
                  <input type="text" name="password" id ="pass" class="input-box"  required ="required">
                  <label for="password">New Password</label>
                  <div class="eye-area">
                   <div  class="eye-box" onclick="myReg1Password()">
                    <i class="fa-regular fa-eye" id="eye-1"></i>
                    <i class="fa-regular fa-eye-slash" id="eye-slash-1"></i>
                 </div>
               </div>
               </div>
                 <div class="input-field">
                    <input type="text" name="confPassword" id = "re_pass" class="input-box"  required ="required">
                    <label for="confPassword">Retype New Password</label>
                    <div class="eye-area">
                     <div  class="eye-box" onclick="myRegPassword()">
                      <i class="fa-regular fa-eye" id="eye-2"></i>
                      <i class="fa-regular fa-eye-slash" id="eye-slash-2"></i>
                   </div>
                 </div>
                 </div>
                 <div class="input-field">
                    <input type="submit" name="recover-submit" id="signin" class="input-submit" value="Reset" required ="required">
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
        </script>
</body>
</html>