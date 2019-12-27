<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 9 ]><html class="no-js oldie" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="no-js oldie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

    <!--- basic page needs
   ================================================== -->
    <meta charset="utf-8">
    <title>DFS</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
   ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS
   ================================================== -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/vendor.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel = "stylesheet" href = "css/client.css"> 

    <!-- script
   ================================================== -->
    <script src="js/modernizr.js"></script>
    <script src="js/pace.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- favicons
	================================================== -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    
 <!-- style
	================================================== -->
	<style>
	#b1,#b2
	{
	background : #000000;
	color: #ffffff;
	}
	</style>
</head>

<body id="top">

    <!-- header 
   ================================================== -->
   <header id="header" class="row">   

   		<div class="header-logo">
	        <a href="index.jsp">DFS</a>
	    </div>

	   	<nav id="header-nav-wrap">
			<ul class="header-main-nav">
				<li class="current"><a class="smoothscroll"  href="#home" title="home">Home</a></li>
				<li><a class="smoothscroll"  href="#pricing" title="pricing">ClientSide</a></li>
				<li><a class="smoothscroll"  href="#download" title="download">AdminSide</a></li>	
			</ul>

            <a href="#" title="sign-up" class="button button-primary cta">Go Back</a>
		</nav>

		<a class="header-menu-toggle" href="#"><span>Menu</span></a>    	
   	
   </header> <!-- /header -->


   <!-- home
   ================================================== -->
   <section id="home" data-parallax="scroll" data-image-src="images/tu.jpg" data-natural-width=3000 data-natural-height=2000>

        <div class="overlay"></div>
        <div class="home-content">        

            <div class="row contents">                     
                <div class="home-content-left">

                    <h1 data-aos="fade-up">Deafening Silence</h1>

                    <h1 data-aos="fade-up">
                        Welcomes <br>
                        you to our site 
                        
                    </h1>

                    <div class="buttons" data-aos="fade-up">
                        <a href="#download" class="smoothscroll button stroke">
                            <span class="icon-circle-down" aria-hidden="true"></span>
                            Admin Site
                        </a>
                        <a href="#pricing" class="smoothscroll button stroke">
                            <span class="icon-circle-down" aria-hidden="true"></span>
                            Client Site
                        </a>
                    </div>                                         

                </div>

                <div class="home-image-right">
                    <img src="images/stars.png" 
                        srcset="images/stars.png 1x, images/stars.png 2x"  
                        data-aos="fade-up">
                </div>
            </div>

        </div> <!-- end home-content -->

        <ul class="home-social-list">
            <li>
                <a href="#"><i class="fa fa-facebook-square"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-twitter"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-instagram"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-youtube-play"></i></a>
            </li>
        </ul>
        <!-- end home-social-list -->

        <div class="home-scrolldown">
            <a href="#about" class="scroll-icon smoothscroll">
                <span>Scroll Down</span>
                <i class="icon-arrow-right" aria-hidden="true"></i>
            </a>
        </div>

    </section> <!-- end home -->  


    
    <!-- pricing
    ================================================== -->
    <section id="pricing">
        <div class="row pricing-content">

            <div class="col-four pricing-intro">
                <h1 class="intro-header" data-aos="fade-up">Client Page</h1>

                <p data-aos="fade-up">Hi !! This helps you to upload your database with us. We'll Let Users to rate thier Purchased products securely. Thank You :)	  </p>
            </div>

            <div class="col-eight pricing-table">
              
                <form action="Up2Ad" method="post" enctype="multipart/form-data">
	
	
		<h2>Select File to Upload:</h2>
		<div class="buttons" data-aos="fade-up">
		
	<div class = "file-input"  >
		
		<input type='file' name="fileName">
		<a class="button full-width">
                            <span class="icon-file" aria-hidden="true"></span>
                            Choose
                        </a>
                        
  
  	
  
  </div>
	</div>
	<input type="submit"  value="Upload">
	</form>          
            </div> <!-- end pricing-table -->

        </div> <!-- end pricing-content -->
    </section> <!-- end pricing -->


   

    <!-- download
    ================================================== -->
    <section id="download">

        <div class="row">
            <div class="col-full">
                <h1 class="intro-header"  data-aos="fade-up">Admin Site.</h1>

                <p class="lead" data-aos="fade-up">
                    Here we can successfully insert database of our clients. Mail Customers button helps us to send mails to all our customers.
                    Which in turn lets our customers to rate their products
                </p>

                        
					<form action="Insert2DB" method="post">					
					<button id = "b1" type="submit" class="btn btn-info" value="Insert"><i class="icon-file-add"> Insert Details </i></button>
					
					</form>
					<div>&nbsp;&nbsp;</div>

					<form action="MailingCust" method="post">
					<button id = "b2" type="submit" class="btn btn-info" value="Mail"><i class="icon-mail"> Mail Customers </i></button>
					
					</form>
				

            </div>
        </div>

    </section> <!-- end download -->    


    <!-- footer
    ================================================== -->
    <footer>

        <div class="footer-main">
            <div class="row">  

                <div class="col-three md-1-3 tab-full footer-info">            

                    <div class="footer-logo"></div>

                    <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in ipsum id orci porta dapibus. Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus. 
                    </p>

                    <ul class="footer-social-list">
                        <li>
                            <a href="#"><i class="fa fa-facebook-square"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-behance"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dribbble"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                    </ul>
                    
                    
                </div> <!-- end footer-info -->

                <div class="col-three md-1-3 tab-1-2 mob-full footer-contact">

                    <h4>Contact</h4>

                    <p>
                    Sunkeerth Kumar B<br>
                    Lekshmi NS <br>
                    Sathya Priya<br>		        
                    </p>

                    <p>
                    Manoj <br>
                    Madhu Hass<br>
                    Raghav Vadavadagi  
                    </p>                    

                </div> <!-- end footer-contact -->  

                <div class="col-two md-1-3 tab-1-2 mob-full footer-site-links">

                    <h4>Site Links</h4>

                    <ul class="list-links">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Client</a></li>
                        <li><a href="#">Admin</a></li>
                    </ul>	      		
                            
                </div> <!-- end footer-site-links --> 

                <div class="col-four md-1-2 tab-full footer-subscribe">

                    <h4>Our Newsletter</h4>

                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

                    <div class="subscribe-form">
                
                        <form id="mc-form" class="group" >

                            <input type="email" value="" name="EMAIL" class="email" id="mc-email" placeholder="Email Address" > 
                
                            <input type="submit" name="subscribe" value="Send">
                
                            <label for="mc-email" class="subscribe-message"></label>
                
                        </form>

                    </div>	      		
                            
                </div> <!-- end footer-subscribe -->         

            </div> <!-- /row -->
        </div> <!-- end footer-main -->


      <div class="footer-bottom">

      	<div class="row">

      		<div class="col-twelve">


		         <div id="go-top">
		            <a class="smoothscroll" title="Back to Top" href="#top"><i class="icon-arrow-up"></i></a>
		         </div>         
	      	</div>

      	</div> <!-- end footer-bottom -->     	

      </div>

    </footer>

    <div id="preloader"> 
    	<div id="loader"></div>
    </div>  

    <!-- Java Script
    ================================================== -->
    <script src="js/jquery-2.1.3.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>

</body>

</html>