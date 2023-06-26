<% int day = 3; %> 
<html> 
   <head><title>IF...ELSE Example</title></head> 
   
   <body>
    <div>
        day value: <%= day %>
    </div>
      <% if (day == 1 || day == 7) { %>
         <p> Today is weekend</p>
      <% } else { %>
         <p> Today is not weekend</p>
      <% } %>
   </body> 
</html>
<!-- html언어가 보이지만 jsp 파일이므로 Servlet으로 인지해야함. -->