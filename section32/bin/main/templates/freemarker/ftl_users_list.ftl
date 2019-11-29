SELECT * from signup
<#if expr?string = ''>
    WHERE name LIKE <@p name="expr"/>
</#if>
 