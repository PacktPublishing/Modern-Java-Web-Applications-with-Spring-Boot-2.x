<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${ projName }</title>
</head>
<body>
    <h2>Add Harvest</h2>
    <form action="/farm/harvest/add" method="POST">
         <label>Name: </label>
         	<input type="text" name="name" /><br/>
         <label>Qty: </label>
         	<input type="text" name="qty" /><br/>
         <label>Price: </label>
         	<input type="text" name="price" /><br/>
         <input type="submit" value="Search" />
    </form>
</body>
</html>