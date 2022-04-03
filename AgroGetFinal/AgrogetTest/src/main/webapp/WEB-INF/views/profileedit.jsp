<%@page import="com.agroget.entity.FarmerEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    
    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="../assets/css/fontawesome.css">
    <link rel="stylesheet" href="../assets/css/templatemo-edu-meeting.css">
    <link rel="stylesheet" href="../assets/css/owl.css">
    <link rel="stylesheet" href="../assets/css/lightbox.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">


    <link rel="stylesheet" href="../assets/css/profile.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
    <link rel="javascript" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
</head>
<body>
<%
	FarmerEntity farmerEntity = (FarmerEntity)request.getAttribute("farmer");
	System.out.println(farmerEntity.getFarmerFname());
%>
     <!-- ***** Header Area Start ***** -->
  <header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="index.html" class="logo">
                      <img src="../assets/images/logo.png" class="img">
                    </a>
                    <!-- ***** Logo End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a href="index">Home</a></li>
                        <li><a href="login" >Login</a></li>
                        <li class="has-sub">
                            <a href="javascript:void(0)">Registration</a>
                            <ul class="sub-menu">
                                <li><a href="farmer">As Farmer</a></li>
                                <li><a href="renter">As Renter</a></li>
                            </ul>
                        </li>
                        <li><a href="aboutus">About Us</a></li> 
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
<br> <br> 

    <div class="container mt-4" >
        <div class="row">
            <div class="col-lg-3 my-lg-0 my-md-1">
                <div id="sidebar" class="bg-purple">
                    <div class="h4 text-white">Account</div>
                    <ul>
                      <li> <a href="profilesearch?farmerid=<%=farmerEntity.getFarmerId() %>" class="text-decoration-none d-flex align-items-start">
                        <div class="far fa-address-book pt-2 me-3"></div>
                        <div class="d-flex flex-column">
                            <div class="link">Search Equipment</div>
                            <div class="link-desc">search and rent equipment</div>
                        </div>
                    </a> </li>
                        <li > <a href="farmerprofile?farmerid=<%=farmerEntity.getFarmerId() %>" class="text-decoration-none d-flex align-items-start">
                                <div class="fas fa-box pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">My Account</div>
                                    <div class="link-desc">View & Manage orders and returns</div>
                                </div>
                            </a> </li>
                        <li> <a href="showorder?farmerid=<%=farmerEntity.getFarmerId()%>" class="text-decoration-none d-flex align-items-start">
                                <div class="fas fa-box-open pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">My Orders</div>
                                    <div class="link-desc">View & Manage Bookings </div>
                                </div>
                            </a> </li>
                       
                        <li class="active"> <a href="profileedit?farmerid=<%=farmerEntity.getFarmerId() %>" class="text-decoration-none d-flex align-items-start">
                                <div class="far fa-user pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">Edit Profile</div>
                                    <div class="link-desc">Change your profile details & password</div>
                                </div>
                            </a> </li>
                            <li> <a href="index" class="text-decoration-none d-flex align-items-start">
                              <div class="fas fa-headset pt-2 me-3"></div>
                              <div class="d-flex flex-column">
                                  <div class="link">Log Out</div>
                                  <div class="link-desc"></div>
                              </div>
                          </a> </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-9 my-lg-0 my-1">
                

              
  <section class="contact-us1" id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 align-self-center">
          <div class="row">
            <div class="col-lg-12 setborder">
            
            
              <form id="contact" action="updatefarmer" method="post">
                <div class="row">
                  <div class="col-lg-12 ">
                    <h2>Enter Your Details</h2>
                  </div>
                  <div class="col-lg-4">
                    <fieldset>
                      <input name="fname" type="text" id="fname"  value=<%=farmerEntity.getFarmerFname() %>  required="" >
                    </fieldset>
                  </div>
                  <div class="col-lg-4">
                    <fieldset>
                      <input name="lname" type="text" id="lname" placeholder="LastName"  value=<%=farmerEntity.getFarmerLname() %>>
                    </fieldset>
                  </div>
                  <div class="col-lg-4">
                    <fieldset>
                    <input name="email" type="text" id="email" pattern="[^ @]*@[^ @]*" placeholder="Email"  value=<%=farmerEntity.getFarmerEmail() %> required="">
                  </fieldset>
                  </div>
                  
                  <div class="col-lg-4">
                    <fieldset>
                      <input name="password" type="password" id="password" placeholder="Password" value=<%=farmerEntity.getFarmerPassword() %>> 
                    </fieldset>
                  </div>


                  <div class="col-lg-4">
                    <fieldset>
                      <input  name="mobile" type="number" id="mobile" placeholder="Phone"  value=<%=farmerEntity.getFarmerMobile() %> required="">
                    </fieldset>
                  </div>

                  <div class="col-lg-4">
                    <fieldset>
                      <input name="address" type="text" id="address" placeholder="Address" value=<%=farmerEntity.getFarmerAddress() %> required="">
                    </fieldset>
                  </div>
                  
                  <div class="col-lg-4">
                    <fieldset>
                      <input name="pincode" type="number" id="pin" placeholder="Pincode" value=<%=farmerEntity.getFarmerPincode() %> required="">
                    </fieldset>
                  </div>
              
                <input type="hidden" value=<%=farmerEntity.getFarmerId()%> name="farmerid" id="farmerid"   />
  
                
                  <div class="col-lg-12">
                    <fieldset>
                      <div>
                      <button type="submit" id="form-submit" class="button">Save Changes</button>
                    </fieldset>
                    
                  </div>
                  <br>
                  
                
            
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
  

            
            
           




        </div>
    </div>  
     


    <div class="footer">
        <p>Copyright © 2022 AgroGet, Ltd. All Rights Reserved. 
            <br>Design: <a href="https://templatemo.com" target="_parent" title="free css templates">AgroGet</a></p>
      </div>





      <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="../assets/js/isotope.min.js"></script>
    <script src="../assets/js/owl-carousel.js"></script>
    <script src="../assets/js/lightbox.js"></script>
    <script src="../assets/js/tabs.js"></script>
    <script src="../assets/js/isotope.js"></script>
    <script src="../assets/js/video.js"></script>
    <script src="../assets/js/slick-slider.js"></script>
    <script src="../assets/js/custom.js"></script>
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

</html>

