<%@ page import="java.sql.*" %>

<HTML>
       <HEAD>
       <TITLE>Select Data From a Database</TITLE>
       </HEAD>
       <BODY BGCOLOR="cyan">
           
            <H1>Welcome Admin</H1>
            <%
              Class.forName("oracle.jdbc.OracleDriver");                
             Connection connection = DriverManager.getConnection(
               "jdbc:oracle:thin:@localhost:1521:jayam","scott","tiger");
                Statement statement = connection.createStatement() ;
                ResultSet resultset =
                statement.executeQuery("select * from books") ;
            %>
                <TABLE BORDER="1" width="100%" cellpadding="5pt">
           <TR>
                 <TH>Book_ID</TH>
                 <TH>Title</TH>
                 <TH>Author</TH>
                 <TH>Price</TH>
            
          </TR>
           <% while(resultset.next()){ %>
           <TR>
                <TD> <%= resultset.getString(1) %></td>
               <TD> <%= resultset.getString(2) %></TD>
               <TD> <%= resultset.getString(3) %></TD>
               <TD> <%= resultset.getString(4) %></TD>
               
               
          </TR>
          
          
           <% } %>
               </TABLE>
               <br>
               <br>
               <b><a href="update.html">Update Books</a></b>
           &nbsp;
           <b><a href="delete.html">Delete Books</a></b>
         </BODY>
</HTML>