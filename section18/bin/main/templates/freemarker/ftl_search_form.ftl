<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${ projName }</title>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
   
<div class="container">
	<div class="row">
		<h2>Search Harvest</h2>
        
        <form method="POST" action="/farm/search" role="search">
    	<div class="input-group">
			<input type="text" class="form-control" placeholder="Search" name="keyword" id="srch-term">
			<div class="input-group-btn">
				<input class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			</div>
		</div>
		</form>
        
        
	</div>
</div>
</body>
</html>