<%@ page import="java.sql.*"%>
<%
String ID=request.getParameter("book_id");
String TITLE=request.getParameter("book_title");
String AUTHOR=request.getParameter("book_author");
String PRICE=request.getParameter("book_price");
if(TITLE!=null||AUTHOR!=null||PRICE!=null){

  try
{
      Class.forName("oracle.jdbc.OracleDriver");
    Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:jayam","scott","tiger");
    PreparedStatement pst= con.prepareStatement("insert into books values(?,?,?,?)");
    pst.setString(1, ID);
    pst.setString(2, TITLE);
    pst.setString(3, AUTHOR);
    pst.setString(4, PRICE);
    
    int x=pst.executeUpdate();
    if(x!=0){
        RequestDispatcher req = request.getRequestDispatcher("listbooks.jsp");
			req.include(request, response);
    }else
               {
        out.println("something went wrong");
    }
        
  }
  
   
catch (Exception e)
               {
    out.println(e);
}
   }
else
       {
    out.println("Password not matching");
}

%>
