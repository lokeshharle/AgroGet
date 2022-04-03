<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.agroget.entity.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
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
     <!-- ** Header Area Start ** -->
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
<br> <br> <br> <br> <br><br> <br> 

    <div class="container mt-4">
        <div class="row">
            <div class="col-lg-3 my-lg-0 my-md-1">
                <div id="sidebar" class="bg-purple">
                    <div class="h4 text-white">Account</div>
                    <ul>
                        <li > <a href="ProfileRenter" class="text-decoration-none d-flex align-items-start">
                                <div class="fas fa-box pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">My Account</div>
                                    <div class="link-desc">View & Manage Bookings</div>
                                </div>
                            </a> </li>
                        <li class="active"> <a href="rentershowlist" class="text-decoration-none d-flex align-items-start">
                                <div class="fas fa-box-open pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">My Equipments</div>
                                    <div class="link-desc">View & Manage Equipments</div>
                                </div>
                            </a> </li>
                        <li> <a href="ProfileAddEquipment" class="text-decoration-none d-flex align-items-start">
                                <div class="far fa-address-book pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">Add New Equipment</div>
                                    <div class="link-desc">list new Equipment</div>
                                </div>
                            </a> </li>
                        <li> <a href="ProfileRenterEdit" class="text-decoration-none d-flex align-items-start">
                                <div class="far fa-user pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">Edit Profile</div>
                                    <div class="link-desc">Change your profile details & password</div>
                                </div>
                            </a> </li>
                            <li> <a href="logoutrenter" class="text-decoration-none d-flex align-items-start">
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
                <div id="main-content" class="bg-white border">
                    
                    <div class="text-uppercase">My Listed Equipment</div>
                    


<%
	List<EquipmentInfoTable> equipmentRenterList = (List<EquipmentInfoTable>) request.getAttribute("equipmentRenterList");
	if(equipmentRenterList!=null && equipmentRenterList.size()!=0){
	for(EquipmentInfoTable equipment : equipmentRenterList )
	{
		%>
			</br>
			
                    <div class="order my-3 bg-light shadow">
                        <div class="row">
                            <div class="col-lg-3">
                                <img src="../assets/images/planter.jpg" alt="">
                            </div>
                            <div class="col-lg-6">
                                <div class="d-flex flex-column justify-content-between order-summary">
                                    <div class="d-flex align-items-center">
                                        <div class="text-uppercase">Name: <%=equipment.getEquipment_name() %></div>
                                         <div class="green-label ms-auto text-uppercase">Type: <%=equipment.getEquipment_type()%> </div>
                                        <div class="green-label ms-auto text-uppercase">Rate: <%=equipment.getEquipment_rate()%>Rs  </div>
                                        <div class="green-label ms-auto text-uppercase">Description: <%=equipment.getEquipment_description()%> </div>
                                          <div class="green-label ms-auto text-uppercase">Rate Type: <%=equipment.getEquipment_rate_type()%>  </div>
                                    </div>
                                  
                                    
                                    <br>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="d-sm-flex align-items-sm-start justify-content-sm-between">
                                   
                                    <div class="btn btn-primary text-uppercase"><a href="/editequipment?equipmentid=<%=equipment.getEquipment_id()%>"> Edit Details</a> </div>
                                   
                                </div>
                                <br>
                                
                                <div class="d-sm-flex align-items-sm-start justify-content-sm-between">
                                   
                                    <div class="btn btn-primary text-uppercase"><a href="/deleteequipment?equipmentid=<%=equipment.getEquipment_id()%>"> Delete</a></div>
                                   
                                </div>

                            </div>
                        </div>
                    </div>
		<%
	}
	}
	else{
%>
      <div><%="You dont have any equipments listed" %></div>
     
  <%} %>  
              </div>
            </div>
        </div>
    </div>  



    <div class="footer">
        <p>Copyright © 2022 Edu Meeting Co., Ltd. All Rights Reserved. 
            <br>Design: <a href="https://templatemo.com" target="_parent" title="free css templates">TemplateMo</a></p>
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