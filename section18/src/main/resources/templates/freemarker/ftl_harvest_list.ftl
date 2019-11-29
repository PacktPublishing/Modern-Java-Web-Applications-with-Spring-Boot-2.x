<html>
<head>
	<title>${ projName }</title>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
</head>
<body>
  <div class="container">
      <div class="col-lg-6">
            <div class="panel panel-default">
            <div class="panel-heading"><h3 style="color : #006400">${ header }</h3></div>
            <div class="panel-body">
             
				<table class="table table-condensed" style="border-collapse:collapse;">
				    <thead>
				        <tr><th> </th>
				            <th>ID</th>
				            <th>Name</th>
				            <th>Quantity</th>
				            <th>Price per kilo</th>
				            <th>Delivery Date</th>
				        </tr>
				    </thead>

				    <tbody>
				     <#list harvest as h>
				        <tr data-toggle="collapse" data-target="#${h.id}" class="accordion-toggle">
				            <td><button class="btn btn-default btn-xs"><span style="color : #6B8E23"  class="glyphicon glyphicon-tree-deciduous"></span></button></td>
				            <td>${h.id}</td>
				            <td>${h.name}</td>
				            <td>${h.price}</td>
				            <td>${h.qty}</td>
				            <td>${h.deliveryDate}</td>
				        </tr>
				         
				        <tr>
				            <td colspan="12" class="hiddenRow"><div class="accordian-body collapse" id="${h.id}"> 
				              <table class="table table-striped">
				                 <thead>
				                    <tr><td><a style="color : #32CD32" href="WorkloadURL">Workload link</a></td><td>Bandwidth: Dandwidth Details</td><td>OBS Endpoint: end point</td></tr>
				                    <tr>
				                       <th>Description</th>
				                       <th>Type</th>
				                       <th>Status</th>
				                       <th>Market</th>
				                       <th>Owner</th>
				                       <th>Buy</th>
				                     </tr>
				                   </thead>
				                   <tbody>
				                     <tr><td>${h.description}</td><td>${h.type}</td><td>ok</td><td>${h.location}</td><td>${h.owner}</td><td><a href="#" class="btn btn-default btn-sm">
				                  		<i class="glyphicon glyphicon-shopping-cart"></i></a></td>
				                  	 </tr>                  
				                   </tbody>
				               	</table>
				              </div>
				            </td>
				        </tr>
				       </#list>
				    </tbody>
				</table>
				
            </div>
          </div> 
      </div>
      </div>
    </body>
</html>