<#import "/spring.ftl" as spring />

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
    <legend style="text-align : center; color : #6B8E23">Add Harvest</legend>
     <@spring.bind "harvestForm"/>
    <form method="POST" action="/farm/harvest/add" class="form-horizontal">
    <fieldset>
		<!-- Text input -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="documentid">ID</label>  
		  <div class="col-md-4">
		  <@spring.formInput "harvestForm.id" "class='form-control input-md' placeholder='ID'" , "number"/> 
		  </div>
		</div>
		
		<!-- Text input -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="status">Name</label>
		  <div class="col-md-4">
		    <@spring.formInput "harvestForm.name" "class='form-control input-md' placeholder='Product Name'" , "text"/> 
		  
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="creationdate">Harvest Date</label>  
		  <div class="col-md-4">
		  <@spring.formInput "harvestForm.deliveryDate" "class='form-control input-md' placeholder='DD/MM/YYYY'" , "text"/> 
		  </div>
		</div>
		
		
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="qty">Quantity</label>  
		  <div class="col-md-4">
		  <@spring.formInput "harvestForm.qty" "class='form-control input-md' placeholder='Quantity'" , "number"/> 
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="qty">Price</label>  
		  <div class="col-md-4">
		   <@spring.formInput "harvestForm.price" "class='form-control input-md' placeholder='Price'" , "number"/> 
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="qty">Owner</label>  
		  <div class="col-md-4">
		   <@spring.formInput "harvestForm.owner" "class='form-control input-md' placeholder='Owner'" , "text"/> 
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="qty">Location</label>  
		  <div class="col-md-4">
		   <@spring.formInput "harvestForm.location" "class='form-control input-md' placeholder='Location'" , "text"/> 
		  </div>
		</div>
		
		<!-- Textarea -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="internalreferencenumber">Description</label>
		  <div class="col-md-4">  
		  <@spring.formTextarea "harvestForm.description" "class='form-control' placeholder='Description'"/>                    
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="qty">Status</label>  
		  <div class="col-md-4">
		   <@spring.formSingleSelect "harvestForm.status" status "class='form-control input-md' placeholder='Status'"/> 
		  </div>
		</div>
		
		<!-- Multiple Radios -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="type">Type</label>
		  <div class="col-md-4">
		      <@spring.formRadioButtons "harvestForm.type" types "" "class='radio'" /> 
		  </div>
		  </div>
		
		<!-- Button (Double) -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="approvereject"></label>
		  <div class="col-md-8">
		    <input type="submit" name="approve" class="btn btn-success" id="approve" value="Approve" />
		    <button name="reject" class="btn btn-danger" id="cancel">Reject</button>
		  </div>
		</div>
	</fieldset>
  </div>
</form>
</body>
</html>