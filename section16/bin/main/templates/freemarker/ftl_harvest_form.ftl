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
    <form method="GET" action="#" class="form-horizontal">
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
		  <input type="number" class="form-control input-md" name="price" type="text" placeholder="Price">
		  <@spring.formInput "harvestForm.price" "class='form-control input-md' placeholder='Price'" , "number"/> 
		  </div>
		</div>
		
		<!-- Textarea -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="internalreferencenumber">Description</label>
		  <div class="col-md-4">  
		  <@spring.formTextarea "harvestForm.description" "class='form-control' placeholder='Description'"/>                    
		    
		  </div>
		</div>
		
		<!-- Multiple Radios -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="financialeffect">Type</label>
		  <div class="col-md-4">
		  <div class="radio">
		    <label for="financialeffect-0">
		      <input name="financialeffect" id="financialeffect-0" type="radio" checked="checked" value="With loss of value">
		      Vegetable
		    </label>
		    </div>
		  <div class="radio">
		    <label for="financialeffect-1">
		      <input name="financialeffect" id="financialeffect-1" type="radio" value="Without loss of  value">
		      Fruit
		    </label>
			</div>
		  </div>
		</div>
		
		<!-- Button (Double) -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="approvereject"></label>
		  <div class="col-md-8">
		    <button name="approve" class="btn btn-success" id="approve">Approve</button>
		    <button name="reject" class="btn btn-danger" id="cancel">Reject</button>
		  </div>
		</div>
	</fieldset>
  </div>
</form>
</body>
</html>