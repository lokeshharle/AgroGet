<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="TemplateMo">
  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

  <title>Education Meeting HTML5 Template</title>

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


  <!-- Sub Header -->


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
                                <li><a href="farmer">As Farmer</a></li>
                                <li><a href="renter">As Renter</a></li>
                            </ul>
                        </li>
                        <li><a href="aboutus">About Us</a></li> 
                        <li><a href="feedback">Feedback</a></li> 
                        <li><a href="contact" class="active">ContactUs</a></li>
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
  <div>

    <p>








    </p>
  </div>
  <!-- ***** Header Area End ***** -->
  <section class="heading-page header-text" id="top">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h2>Contact Us</h2>
          <h6>We appreciate you taking the time to provide us with your views
            so that we can best meet the needs of users</h6>
        </div>
      </div>
    </div>
  </section>
  <!-- ***** Main Banner Area Start ***** -->

  <section class="contact-us" id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-9 align-self-center">
          <div class="row">
            <div class="col-lg-12">
                <div class="row">
                  <div class="col-md-14">
                   
                    <div class="googlemap">
                    <iframe  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3782.9923134959513!2d73.83140251489284!3d18.52924948740388!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bc2bf4a06f8ec33%3A0x8fbd07f290a4163a!2sIET%20C-DAC%20ACTS%20ATC%2C%20Pune%5B%20INSTITUTE%20OF%20EMERGING%20TECHNOLOGIES%20PVT.%20LTD%5D%7C%20Best%20CDAC%20Centre%20in%20Pune%20%7C%20Best%20Pre-DAC%20Pune%20%7C!5e0!3m2!1sen!2sin!4v1648296422337!5m2!1sen!2sin"  style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                  </div>
                </div>
                </div>
            </div>
          </div>
        </div>
        <div class="col-lg-3">
          <div class="right-info">
            <ul>
              <li>
                <h6>Phone Number</h6>
                <span>010-020-0340</span>
              </li>
              <li>
                <h6>Email Address</h6>
                <span>agroget@gmail.com</span>
              </li>
              <li>
                <h6>Street Address</h6>
                <span>IET, Model Colony, Pune-411016</span>
              </li>
              <li>
                <h6>career</h6>
                <span>careersagrgt@gmail.com</span>
                <br>
              </li>

            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="footer">
      <p>Copyright © 2022 AgroGet Co., Ltd. All Rights Reserved.
        <br>Design: <a href="https://templatemo.com" target="_parent" title="free css templates">AgroGet</a>
      </p>
    </div>
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
  <script src="assets\js\templatemo_script.js" type="text/javascript"></script>
  <script src="assets\js/jquery.min.js" type="text/javascript"></script>
  <script src="assets\js/bootstrap.min.js" type="text/javascript"></script>
  <script src="assets\js/stickUp.min.js" type="text/javascript"></script>
  <script src="assets\js/colorbox/jquery.colorbox-min.js" type="text/javascript"></script>
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
          scrollTop: reqSectionPos
        },
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