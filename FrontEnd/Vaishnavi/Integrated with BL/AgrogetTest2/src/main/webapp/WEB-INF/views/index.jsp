<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <meta name="View Equipmentport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="TemplateMo">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

    <title>Agroget</title>

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

  <img src="assets/images/back.jpg">
 
  <!-- ***** Header Area Start ***** -->
  <header class="header-area header-sticky">
      <div class="container">
          <div class="row">
              <div class="col-12">
                  <nav class="main-nav">
                      <!-- ***** Logo Start ***** -->
                      <a href="index" class="logo">
                        <img src="assets/images/logo.png" class="img">
                      </a>
                      <!-- ***** Logo End ***** -->
                      <!-- ***** Menu Start ***** -->
                      <ul class="nav">
                        <li class="scroll-to-section"><a href="index.html" class="active">Home</a></li>
                        <li><a href="login">Login</a></li>
                        
                        <li class="has-sub">
                            <a href="javascript:void(0)">Registration</a> 
                            <ul class="sub-menu">
                                <li><a href="farmer">As Farmer</a></li>
                                <li><a href="renter">As Renter</a></li>
                            </ul>
                        </li>
                        <li ><a href="aboutus">About Us</a></li>
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

  <!-- ***** Main Banner Area Start ***** -->
  <section class="section main-banner" id="top" data-section="section1">
      <!-- <video autoplay muted loop id="bg-video">
          <source src="assets/images/course-video.mp4" type="video/mp4" />
      </video> -->

      <div class="video-overlay header-text">
          <div class="container">
            <div class="row">
              <div class="col-lg-12">
                <div class="caption">
   
              <h2>Welcome to AgroGet</h2>
              <p>AgroGet is a web application. The main objective of the AgroGet is to provide a service for farmers to take equipment on rent from different renters and Provide Renter the functionality to list their equipment for rent and track their equipment which are rented.</p>
           
          </div>
              </div>
            </div>
          </div>
      </div>
  </section>
  <!-- ***** Main Banner Area End ***** -->

  <section class="services">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="owl-service-item owl-carousel">
          
            <div class="item">
              <div class="icon">
                <img src="assets/images/service-icon-01.png" alt="">
              </div>
              <div class="down-content">
                <h4>Harvesting Equipment</h4>
                <a href="harvestingequipment" class="btn1 btn-success btn1"> View</a>
              </div>
            </div>
            
            <div class="item">
              <div class="icon">
                <img src="assets/images/service-icon-02.png" alt="">
              </div>
              <div class="down-content">
                <h4>Seeding Equipment</h4>
                <a href="seedingequipment" class="btn1 btn-success btn1">View</a>
              </div>
            </div>
            
            <div class="item">
              <div class="icon">
                <img src="assets/images/service-icon-03.png" alt="">
              </div>
              <div class="down-content">
                <h4>Planting Equipment</h4>
                <a href="plantingequipment" class="btn1 btn-success btn1">View</a>
              </div>
            </div>
            
            <div class="item">
              <div class="icon">
                <img src="assets/images/service-icon-02.png" alt="">
              </div>
              <div class="down-content">
                <h4>Tillage Equipment</h4>
                <a href="tillagequipment" class="btn1 btn-success btn1">View</a>
            </div>
            </div>
            
            <div class="item">
              <div class="icon">
                <img src="assets/images/service-icon-03.png" alt="">
              </div>
              <div class="down-content">
                <h4>Cuttlers and Shredders</h4>
                <a href="tillage.html" class="btn1 btn-success btn1">View</a>
           </div>
            </div>
            
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
</section>
 
 
    
  


  <!-- Scripts -->
  <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/isotope.min.js"></script>
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/lightbox.js"></script>
    <script src="assets/js/tabs.js"></script>
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