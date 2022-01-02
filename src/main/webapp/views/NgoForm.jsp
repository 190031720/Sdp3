<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,700,900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assertsproperies/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="assertsproperies/css/style.css">

    <title>Collaboration Form</title>
  </head>
  <body>
  

  <div class="content">
    
    <div class="container">
      <div class="row">
        <div class="col-md-5 mr-auto">
          <h3 class="mb-3">Let's work together</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae sequi, ipsa hic alias officia facilis eveniet, neque laborum cumque maxime soluta. Neque atque necessitatibus ipsam sequi soluta magni, iste vero fuga inventore, explicabo totam quis quia nemo possimus cupiditate doloribus?</p>
          <p>Quasi optio numquam pariatur amet laudantium, dicta ullam obcaecati nihil eveniet et aperiam beatae illum vitae in asperiores, a ex. Voluptates accusantium, beatae dolorem natus delectus nostrum, iusto nemo optio quas eum, quis a in reprehenderit totam, sequi distinctio impedit.</p>
          <p>Dolor aliquid, commodi vitae dolorum veniam amet error! Nemo nam quibusdam delectus dolore eveniet officia harum eum sit magnam possimus. Eum optio dolores repellat ea impedit, in unde, rem ipsam rerum autem iusto vero facilis blanditiis explicabo sapiente consequatur provident? <a href="#">info@mywebsite.com</a></p>
          
        </div>

        <div class="col-md-6">
          <div class="box">
            <h3 class="heading">Collaboration Form</h3>
            <form class="mb-5" method="post" action="/submitNgoForm" enctype="multipart/form-data" modeAttribute="ngodata" id="contactForm" name="contactForm">
              <div class="row">
                
                <div class="col-md-6 form-group">
                  <label for="name" class="col-form-label">Charity Name *</label>
                  <input type="text" class="form-control"  name="orgname" path="orgname" id="name" placeholder="Your name">
                </div>

                <div class="col-md-6 form-group">
                  <label for="name" class="col-form-label">Organization Url</label>
                <input type="text" class="form-control" name="orgurl" path="orgurl" id="organization" placeholder="Your organization">
                  </div>

                 
                <div class="col-md-6 form-group">
                    <label for="name" class="col-form-label">Logo: *</label>
                    <input type="file" id="avatar" name="orglogo"  path="orglogo" >
                  </div>

                </div>


              <div class="row">
                <div class="col-md-12 form-group">
                  <label for="name" class="col-form-label">Email *</label>
                  <input type="email" class="form-control" name="orgemail" path="orgemail" id="email" placeholder="Your email address">
                </div>
              </div>

               <div class="row">
                <div class="col-md-12 form-group">
                  <label for="orgmobile" class="col-form-label">Phone Number *</label>
                  <input type="text" class="form-control" name="orgmobile" id="phone" path="orgmobile" placeholder="Your Phone Number">
                </div>
              </div>

              <div class="row">
                <div class="col-md-12 form-group">
                  <label for="message" class="col-form-label">What is your Charity's Mission :*</label>
                  <textarea class="form-control" name="orgdesc" id="message" cols="15" path="orgdesc" rows="3"></textarea>
                </div>
              </div>


              <div class="row mb-3">

                <div class="col-md-6 form-group">
                  <label for="message" class="col-form-label">How much Fund Raise *</label>
                  <input type="number" class="form-control" name="orgfunds" path="orgfunds" id="quantity">
                
                </div>
              </div>


              <div class="row mb-3">                 
                <div class="col-md-6 form-group">
                  <label for="budget" class="col-form-label">Donation Type: </label>
                <select id="orgtype" path="orgtype" name="orgtype">
  					<option value="plants">Plants</option>
  					<option value="animals">Animals</option>
  					<option value="humans">Humans</option>
				</select>
                </div>
              </div>
                

               <div class="row">
                <div class="col-md-6">
                    <label for="message" class="col-form-label">Certificate: *</label>
              <input type="file" name="orgcertificate" path="orgcertificate">
            </div>
          </div>
          <br>

              <div class="row">
                <div class="col-md-12">
                  <input type="submit" value="Send" class="btn btn-block btn-primary rounded-0 py-2 px-4">
                  <span class="submitting"></span>
                </div>
              </div>

            </form>

            <div id="form-message-warning mt-4"></div> 
            <div id="form-message-success">
              ${message}
            </div>
          </div>
        </div>
      </div>
  </div>
    
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/main.js"></script>

  </body>
</html>