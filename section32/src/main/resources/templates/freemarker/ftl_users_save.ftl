INSERT INTO signup(id, name, email, mobile, address, username, password, approved, birthday) 
VALUES
<#list records as rec>
   ( <@p value=rec.id/>, <@p value=rec.name/>, <@p value=rec.email/>, <@p value=rec.mobile/>, <@p value=rec.address/>, <@p value=rec.username/>, <@p value=rec.password/>, <@p value=rec.approved/>, <@p value=rec.bday/> )<#sep>,
</#list>