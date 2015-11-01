<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!-- Bootstrap -->
<link href="<%= request.getContextPath() %>/resources/css/bootstrap.min.css"  rel='stylesheet' type='text/css' />
<link href="<%= request.getContextPath() %>/resources/css/bootstrap.css"  rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<link href="<%= request.getContextPath() %>/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/profile.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
<!-- start slider -->
<link href="<%= request.getContextPath() %>/resources/css/slider.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/modernizr.custom.28468.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery.cslider.js"></script>
	<script type="text/javascript">
			$(function() {

				$('#da-slider').cslider({
					autoplay : true,
					bgincrement : 450
				});

			});
		</script>
<!-- Owl Carousel Assets -->
<link href="<%= request.getContextPath() %>/resources/css/owl.carousel.css" rel="stylesheet">
<script src="<%= request.getContextPath() %>/resources/js/owl.carousel.js"></script>
		<script>
			$(document).ready(function() {

				$("#owl-demo").owlCarousel({
					items : 4,
					lazyLoad : true,
					autoPlay : true,
					navigation : true,
					navigationText : ["", ""],
					rewindNav : false,
					scrollPerPage : false,
					pagination : false,
					paginationNumbers : false,
				});

			});
		</script>
		<!-- //Owl Carousel Assets -->
<!----font-Awesome----->
   	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/fonts/css/font-awesome.min.css">
   	   	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/fonts/css/font-awesome.css">
   	
<!----font-Awesome----->
