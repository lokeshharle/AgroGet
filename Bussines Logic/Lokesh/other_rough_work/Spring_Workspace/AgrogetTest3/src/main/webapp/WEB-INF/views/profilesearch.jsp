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


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
    <link href="../assets/css/main.css" rel="stylesheet" />

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="../assets/css/fontawesome.css">
    <link rel="stylesheet" href="../assets/css/templatemo-edu-meeting.css">
    <link rel="stylesheet" href="../assets/css/owl.css">
    <link rel="stylesheet" href="../assets/css/lightbox.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">


    <link rel="stylesheet" href="../assets/css/profile.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
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
                        <a href="../index.html" class="logo">
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
<br><br>
    <!-- ***** Header Area End ***** -->
    <!-- <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container"> <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynav" aria-controls="mynav" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button> <a class="navbar-brand" href="#">
                <div class="d-flex">
                    <div class="d-flex align-items-center logo bg-purple">
                        <div class="fab fa-joomla h2 text-white"></div>
                    </div>
                    <div class="ms-3 d-flex flex-column">
                        <div class="h4">Furfection</div>
                        <div class="fs-6">My pet App</div>
                    </div>
                </div>
            </a>
            <div class="collapse navbar-collapse" id="mynav">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item"> <a class="nav-link active" aria-current="page" href="#">Categories <span class="fas fa-th-large px-1"></span></a> </li>
                    <li class="nav-item"> <a class="nav-link" href="#">Exclusive</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="#">Collections</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="#">Blogs</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="#">
                            <div class="cart bg-purple"> <span class="fas fa-shopping-cart text-white"></span> </div>
                        </a> </li>
                    <li class="nav-item"> <a class="nav-link" href="#"> <span class="fas fa-user pe-2"></span> Hello Jhon</a> </li>
                </ul>
            </div>
        </div>
    </nav> -->
    <div class="container mt-4">
        <div class="row">
            <div class="col-lg-3 my-lg-0 my-md-1">
                <div id="sidebar" class="bg-purple">
                    <div class="h4 text-white">Account</div>
                    <ul>
                        <li class="active"> <a href="ProfileSearch.html"
                                class="text-decoration-none d-flex align-items-start">
                                <div class="far fa-address-book pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">Search Equipment</div>
                                    <div class="link-desc">search and rent equipment</div>
                                </div>
                            </a> </li>
                        <li> <a href="profile?farmerid=<%=farmerEntity.getFarmerId()%>" class="text-decoration-none d-flex align-items-start">
                                <div class="fas fa-box pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">My Account</div>
                                    <div class="link-desc">View & Manage orders and returns</div>
                                </div>
                            </a> </li>
                        <li> <a href="ProfileMyOrders.html" class="text-decoration-none d-flex align-items-start">
                                <div class="fas fa-box-open pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">My Orders</div>
                                    <div class="link-desc">View & Manage Bookings </div>
                                </div>
                            </a> </li>

						
                        <li> <a href="profileedit?farmerid=<%=farmerEntity.getFarmerId() %>" class="text-decoration-none d-flex align-items-start">
                                <div class="far fa-user pt-2 me-3"></div>
                                <div class="d-flex flex-column">
                                    <div class="link">Edit Profile</div>
                                    <div class="link-desc">Change your profile details & password</div>
                                </div>
                            </a> </li>
                            <li> <a href="../index.html" class="text-decoration-none d-flex align-items-start">
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
                    <!-- <div class="d-flex flex-column">
                        <div class="h5">Hello Jhon,</div>
                        <div>Logged in as: someone@gmail.com</div>
                    </div>
                    <div class="d-flex my-4 flex-wrap">
                        <div class="box me-4 my-1 bg-light"> <img src="https://www.freepnglogos.com/uploads/box-png/cardboard-box-brown-vector-graphic-pixabay-2.png" alt="">
                            <div class="d-flex align-items-center mt-2">
                                <div class="tag">Orders placed</div>
                                <div class="ms-auto number">10</div>
                            </div>
                        </div>
                        <div class="box me-4 my-1 bg-light"> <img src="https://www.freepnglogos.com/uploads/shopping-cart-png/shopping-cart-campus-recreation-university-nebraska-lincoln-30.png" alt="">
                            <div class="d-flex align-items-center mt-2">
                                <div class="tag">Items in Cart</div>
                                <div class="ms-auto number">10</div>
                            </div>
                        </div>
                        <div class="box me-4 my-1 bg-light"> <img src="https://www.freepnglogos.com/uploads/love-png/love-png-heart-symbol-wikipedia-11.png" alt="">
                            <div class="d-flex align-items-center mt-2">
                                <div class="tag">Wishlist</div>
                                <div class="ms-auto number">10</div>
                            </div>
                        </div>
                    </div> -->

                    <div class="s003">
                        <form>
                            <div class="inner-form">
                                <div class="input-field first-wrap">
                                    <div class="input-select">
                                        <select data-trigger="" name="choices-single-defaul">
                                            <option placeholder="">Category</option>
                                            <option>Harvesting</option>
                                            <option>Seeding</option>
                                            <option>Planting</option>
                                            <option>Tillage</option>
                                            <option>Cutters and Shredders</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="input-field second-wrap">
                                    <input id="search" type="text" placeholder="Enter Keywords?" />
                                </div>
                                <div class="input-field third-wrap">
                                    <button class="btn-search" type="button">
                                        <svg class="svg-inline--fa fa-search fa-w-16" aria-hidden="true"
                                            data-prefix="fas" data-icon="search" role="img"
                                            xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                            <path fill="currentColor"
                                                d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z">
                                            </path>
                                        </svg>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <script src="../assets/js/choices.js"></script>
                    <script>
                        const choices = new Choices('[data-trigger]',
                            {
                                searchEnabled: false,
                                itemSelectText: '',
                            });

                    </script>

                    <br> <br> <br>

                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="row">
                                    <div class="col-lg-4 ">
                                        <div class="meeting-item shadow">
                                            <div class="thumb">
                                                <div class="price">
                                                    <span>???36.00</span>
                                                </div>
                                                <a href="meeting-details.html"><img src="../assets/images/disc.jpg"
                                                        alt="New Lecturer Meeting"></a>
                                            </div>
                                            <div class="down-content">

                                                <a href="meeting-details.html">
                                                    <h4>New Lecturers Meeting</h4>
                                                </a>
                                                <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                                                
                                                    <div class="main-button-red">
                                                        <div class="scroll-to-section" style="display: flex;">
                                                            <a href="#contact">Order Now</a> 
                                                            <a href="#contact">add to cart</a>
                                                        </div>
                                                        
                                                    </div>
                                                

                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-lg-4 ">
                                        <div class="meeting-item shadow">
                                            <div class="thumb">
                                                <div class="price">
                                                    <span>???36.00</span>
                                                </div>
                                                <a href="meeting-details.html"><img src="../assets/images/disc.jpg"
                                                        alt="New Lecturer Meeting"></a>
                                            </div>
                                            <div class="down-content">

                                                <a href="meeting-details.html">
                                                    <h4>New Lecturers Meeting</h4>
                                                </a>
                                                <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                                                <div class="main-button-red">
                                                    <div class="scroll-to-section"><a href="#contact">Order Now</a>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-lg-4 ">
                                        <div class="meeting-item shadow">
                                            <div class="thumb">
                                                <div class="price">
                                                    <span>???36.00</span>
                                                </div>
                                                <a href="meeting-details.html"><img src="../assets/images/disc.jpg"
                                                        alt="New Lecturer Meeting"></a>
                                            </div>
                                            <div class="down-content">

                                                <a href="meeting-details.html">
                                                    <h4>New Lecturers Meeting</h4>
                                                </a>
                                                <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                                                <div class="main-button-red">
                                                    <div class="scroll-to-section"><a href="#contact">Order Now</a>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-lg-4 ">
                                        <div class="meeting-item shadow">
                                            <div class="thumb">
                                                <div class="price">
                                                    <span>???36.00</span>
                                                </div>
                                                <a href="meeting-details.html"><img src="../assets/images/disc.jpg"
                                                        alt="New Lecturer Meeting"></a>
                                            </div>
                                            <div class="down-content">

                                                <a href="meeting-details.html">
                                                    <h4>New Lecturers Meeting</h4>
                                                </a>
                                                <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                                                <div class="main-button-red">
                                                    <div class="scroll-to-section"><a href="#contact">Order Now</a>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-lg-4 ">
                                        <div class="meeting-item shadow">
                                            <div class="thumb">
                                                <div class="price">
                                                    <span>???36.00</span>
                                                </div>
                                                <a href="meeting-details.html"><img src="../assets/images/disc.jpg"
                                                        alt="New Lecturer Meeting"></a>
                                            </div>
                                            <div class="down-content">

                                                <a href="meeting-details.html">
                                                    <h4>New Lecturers Meeting</h4>
                                                </a>
                                                <p>Morbi in libero blandit lectus<br>cursus ullamcorper.</p>
                                                <div class="main-button-red">
                                                    <div class="scroll-to-section"><a href="#contact">Order Now</a>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>






                                </div>
                            </div>
                        </div>
                    </div>


                    <br> <br> <br> <br><br> <br> <br> <br> <br>
                    <div class="footer">
                        <p>Copyright ?? 2022 Edu Meeting Co., Ltd. All Rights Reserved.
                            <br>Design: <a href="https://templatemo.com" target="_parent"
                                title="free css templates">TemplateMo</a>
                        </p>
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

</html>