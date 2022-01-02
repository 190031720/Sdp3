<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
<title>View All Subs</title>
<link rel="shortcut icon" href="assets/images/fav.png" type="image/x-icon">
   <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="assets/images/fav.jpg">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/all.min.css">
    <link rel="stylesheet" href="assets/css/animate.css">
    <link rel="stylesheet" href="assets/plugins/slider/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/plugins/slider/css/owl.theme.default.css">
    
<style>
body {
	background-color :#921C20;
}
main.form-group {
  /*center form inputs */
  float: none;
  margin: 0 auto;
}

main {
  /* center contents */
  text-align: center;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  background-color :#FEFCE6 ;
  padding: 15px;
  margin-left:50px;
}

.form-control {
  align-self: flex-end;
}
</style>
</head>

<body>
<h2 align=center style="color:#FEFCE6; margin-top:30px;">Lend your hand to your fav org...! </h2><br/>
<center>
<div style="width: 90%; ">
<c:forEach var="org" items="${name}">
  
        
        
        
       	<div class="col-md-3 col-sm-3 card" style=" border:1px solid black">
       	<div class="event-box">
       	<img src="data:image/jpg;base64,${org.orglogo}" alt="">
        <h4>${org.orgname}</h4>
        <p class="desic">${org.orgdesc}</p>
      	<a class="btn btn-success btn-sm" href="https://rzp.io/l/aLo97OiMBU">Donate Now</a>
        </div>
        </div>
                
                
                
                
                
                
</c:forEach>
</div>
</center>
</body>

</html>


