<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
   
</head>
<body>
    <h2>Comment Form</h2>
    <form action="/farm/email" method="POST" enctype="text/plain">
         <label>From: </label>
         	<input type="text" name="from" /><br/>
         <label>To: </label>
         	<input type="text" name="to" /><br/>
         <label>Comment: </label><br/>
         	<textarea name="comment" rows="10" cols="20"></textarea><br/>
         <input type="submit" value="Search" />
    </form>
</body>
</html>