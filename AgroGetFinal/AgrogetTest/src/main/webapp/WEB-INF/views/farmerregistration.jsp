<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Template Mo">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

    <title>AgroGet</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-edu-meeting.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/lightbox.css">
<!--

TemplateMo 569 Edu Meeting

https://templatemo.com/tm-569-edu-meeting

-->
  </head>

<body>

   
  <!-- ***** Header Area Start ***** -->
  <header class="header-area header-sticky">
      <div class="container">
          <div class="row">
              <div class="col-12">
                  <nav class="main-nav">
                      <!-- ***** Logo Start ***** -->
                      <a href="index.html" class="logo">
                        <img src="assets/images/logo.png" class="img">
                      </a>
                      <!-- ***** Logo End ***** -->
                      <!-- ***** Menu Start ***** -->
                      <ul class="nav">
                          <li><a href="index">Home</a></li>
                          <li><a href="login">Login</a></li>
                          <li class="has-sub">
                              <a href="javascript:void(0)">Registration</a>
                              <ul class="sub-menu">
                                  <li><a href="farmer" class="active">As Farmer</a></li>
                                  <li><a href="renter">As Renter</a></li>
                              </ul>
                          </li>
                          <li><a href="aboutus">About Us</a></li> 
                          <li><a href="feedback">Feedback</a></li> 
                          <li><a href="contact">ContactUs</a></li>
                      </ul>        
                      <a class='menu-trigger'>
                          <span>Menu</span>
                      </a>
                      <!-- ***** Menu End ***** -->
                  </nav>
              </div>
          </div>
      </div>
  </header>
  <!-- ***** Header Area End ***** -->



  <section class="heading-page header-text" id="top">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h2> Farmer Registration</h2>
         
        </div>
      </div>
    </div>
  </section>


  <section class="contact-us" id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-9 align-self-center">
          <div class="row">
            <div class="col-lg-12 setborder">
              <form id="contact" action="addFarmer1" method="post" enctype="multipart/form-data" >
                <div class="row">
                  <div class="col-lg-12 ">
                    <h2>Enter Your Details</h2>
                  </div>
                  <div class="col-lg-4">
                    <fieldset>
                      <input name="fname" type="text" id="fname" placeholder="FirstName" required="">
                    </fieldset>
                  </div>
                  <div class="col-lg-4">
                    <fieldset>
                      <input name="lname" type="text" id="lname" placeholder="LastName" required="">
                    </fieldset>
                  </div>
                  <div class="col-lg-4">
                    <fieldset>
                    <input name="email" type="text" id="email" pattern="[^ @]*@[^ @]*" placeholder="Email" required="">
                  </fieldset>
                  </div>
                  
                  <div class="col-lg-4">
                    <fieldset>
                      <input name="password" type="password" id="password" placeholder="Password" required="">
                    </fieldset>
                  </div>


                  <div class="col-lg-4">
                    <fieldset>
                      <input  name="mobile" type="number" id="mobile" placeholder="Phone" required="">
                    </fieldset>
                  </div>

                  <div class="col-lg-4">
                    <fieldset>
                      <input name="address" type="text" id="address" placeholder="Address" required="">
                    </fieldset>
                  </div>
                  
                  <div class="col-lg-4">
                    <fieldset>
                      <input name="pincode" type="number" id="pincode" placeholder="Pincode" required="">
                    </fieldset>
                  </div>
              
                  
                  <div class="col-lg-5">
                   <!--  <fieldset class="height"><label for="files" class="btn">Upload Kisan Card</label>
                      <input type="file" id="file" style="visibility:hidden;" name="file" accept="image/png , image/jpeg" required="" >
                    </fieldset> -->
                    <fieldset>
                        <input type="file" id="file" name="file" accept="image/png , image/jpeg" >
                    </fieldset>
                  </div>
                
                
                  <div class="col-lg-12">
                    <fieldset>
                      <div>
                      <button type="submit" id="form-submit" class="button">Register</button>
                    </fieldset>
                    
                  </div>
                  <br>
                  <div>
                    <hr>
                 <h6 style="margin-left: 340px;">Already User? <a href="login"><u style="color: green;">Login here</u></a></h6>
                  </div>
                
            
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
  
      
        <section class="meetings-page" id="meetings">
          <div class="footer">
            <p>Copyright © 2022 AgroGet Co., Ltd. All Rights Reserved. 
                <br>Design: <a href="https://templatemo.com/page/1" target="_parent" title="website templates">AgroGet</a></p>
          </div>
        </section>
         ***** Main Banner Area End ***** -->
      
  


  <!-- Scripts -->
  <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/isotope.min.js"></script>
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/lightbox.js"></script>
    <script src="assets/js/tabs.js"></script>
    <script src="assets/js/isotope.js"></script>
    <script src="assets/js/video.js"></script>
    <script src="assets/js/slick-slider.js"></script>
    <script src="assets/js/custom.js"></script>
    <script>
        //according to loftblog tut
        $('.nav li:first').addClass('active');

        var showSection = function showSection(section, isAnimate) {
          var
          direction = section.replace(/#/, ''),
          reqSection = $('.section').filter('[data-section="' + direction + '"]'),
          reqSectionPos = reqSection.offset().top - 0;

          if (isAnimate) {
            $('body, html').animate({
              scrollTop: reqSectionPos },
            800);
          } else {
            $('body, html').scrollTop(reqSectionPos);
          }

        };

        var checkSection = function checkSection() {
          $('.section').each(function () {
            var
            $this = $(this),
            topEdge = $this.offset().top - 80,
            bottomEdge = topEdge + $this.height(),
            wScroll = $(window).scrollTop();
            if (topEdge < wScroll && bottomEdge > wScroll) {
              var
              currentId = $this.data('section'),
              reqLink = $('a').filter('[href*=\\#' + currentId + ']');
              reqLink.closest('li').addClass('active').
              siblings().removeClass('active');
            }
          });
        };

        $('.main-menu, .responsive-menu, .scroll-to-section').on('click', 'a', function (e) {
          e.preventDefault();
          showSection($(this).attr('href'), true);
        });

        $(window).scroll(function () {
          checkSection();
        });
    </script>
</body>


  </body>

</html>
