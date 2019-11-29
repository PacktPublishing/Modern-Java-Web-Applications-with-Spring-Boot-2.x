<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${ projName }</title>
</head>
<body>
   <h2>Harvest Inventory</h2>
   <table>
      <#list dbHarvest as harvest>
         <tr>
             <td>${ harvest.name }</td>
             <td>${ harvest.qty }</td>
             <td>${ harvest.price }</td>
         </tr>
      </#list>
   </table>
</body>
</html>