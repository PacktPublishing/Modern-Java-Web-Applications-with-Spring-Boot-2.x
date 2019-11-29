<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${ projName }</title>
</head>
<body>
    <h2>Search Harvest</h2>
    <form action="/farm/search" method="POST">
         <label>Search: </label>
         <input type="text" name="keyword" /><br/>
         <input type="submit" value="Search" />
    </form>
</body>
</html>