<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
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
                                  <li><a href="farmer">As Farmer</a></li>
                                  <li><a href="renter">As Renter</a></li>
                              </ul>
                          </li>
                          <li><a href="aboutus" class="active">About Us</a></li> 
                          <li><a href="feedback">Feedback</a></li> 
                          <li><a href="contact">Contact Us</a></li> 
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
          <h2> AboutUs</h2>
         
        </div>
      </div>
    </div>
  </section>


    
  <section class="contact-us" id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 align-self-center">
          <div class="row">
            <div class="col-lg-12">
              <form id="contact" action="" method="post">
                <div class="row">
                  <div class="col-lg-12">
                    <h2>Agroget</h2>
                  </div>
                  <h6><p>Farming in the INDIA has gone through a paradigm shift with the introduction of farm equipment that offers greater efficiency and productivity. However, although Modern machinery is unique and special in its own right, but not many farmers including those in The India have access to it. This is because these machines call for a large amount of investment. Not only that, these are used for a short duration and may remain idle for a long time. Besides, there is new advancement in technology now and then, making the old machines not up to the mark. Investing whopping amount in such machines may not be the right move for the farming business.
                </p><p>
                    Here, is where AGROGET steps in.</p>
                <br>
                    <p>
                        AGROGET is one such phenomenal platform that offers Smart modern farm technology for the farmers without paying the hefty tag price thereby improving the economic dynamics of farming. Bridging the gap between the ones who are in dire need of machines and the ones whose machinery is sitting idly in their farms, AGROGET serves both the renters and the owners of farm equipment. Easy to use, equipment can be viewed and booked online in simple steps making the whole process viable and reliable. It’s all easy breezy.
                </p><br>
                    <p>
                    Got a tractor or harvester and don’t know what to do with it? Simply, rent it out if they’re merely taking up space in your backyard, because equipment and implementshardly get wiped out.Hoarding obsolete equipment is like putting the cart before the horse. Post a free listing on AGROGET and rent your unavailing farm machinery. This would not just put your inactive implements to optimum utilisation but it would also assist you in making a buck and helping those who have no access to farm machinery.
                </p><br>
                  </h6>
                  <p>
                    <h6>Our Team :</h6>
                    <br>
                    <hr>
                      <ul>
                          <li><h7>Lokesh Harle</h7></li>
                          <li><h7>Tushar Sutar</h7></li>
                          <li><h7>Shridhar Patil</h7></li>
                          <li><h7>Sumit Arvikar</h7></li>
                          <li><h7>Vaishnavi Patil</h7></li>
                          <li><h7>Laxman Salgaonkar</h7></li>
                      </ul>
                  </p>
                </div>
              </form>
            </div>
          </div>
        </div>
        
      </div>
    </div>
    <div class="footer">
      <p>Copyright © 2022 AgroGet Co., Ltd. All Rights Reserved. 
          <br>Design: <a href="https://templatemo.com" target="_parent" title="free css templates">AgroGet</a></p>
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