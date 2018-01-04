<!DOCTYPE html>
<html lang="en">
<head>
<title>CMS Health</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

.navbar-cms {
    background-color: #112e51;
    border-color: #E7E7E7;
    height: 80px;
}

.cms-font-color > li > a {
    font-family: 'Source Sans Pro', 'Helvetica Neue', 'Helvetica', 'Roboto', 'Arial', sans-serif;
    color: #ffffff;
    text-transform: capitalize;
    overflow: hidden;
    text-overflow: ellipsis;
    padding-right: 18px;
    font-size: 17px;
    font-weight: 500;
}

</style>
</head>
<body>

	<nav class="navbar-cms">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="https://www.cms.gov/">
                    <img src="resources/images/logo.png" style="width: 40%">
                </a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right cms-font-color">
					<li class="active"><a href="applications">Applications</a></li>
					<li><a href="createtemplate">
                       
                        CreateTemplate
                    </a></li>
					<li><a href="./upload">
                        Upload
                        </a>
                    </li>
					<li><a href="./reports">
                        Reports
                        </a>
                    </li>
					<!-- <li><a href="./demonstration">Demonstration Description</a></li> -->
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
