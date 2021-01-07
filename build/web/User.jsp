<%@ page import="java.sql.*"%>
<%
String ID=request.getParameter("user_id");
String NAME=request.getParameter("user_name");
String EMAIL=request.getParameter("user_email");
String GENDER=request.getParameter("user_gender");
String PASS1=request.getParameter("user_pass1");
String PASS2=request.getParameter("user_pass2");
if(PASS1.equals(PASS2)){
  try
{
      Class.forName("oracle.jdbc.OracleDriver");
    Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:jayam","scott","tiger");
    PreparedStatement pst= con.prepareStatement("insert into users values(?,?,?,?,?)");
    pst.setString(1, ID);
    pst.setString(2, NAME);
    pst.setString(3, EMAIL);
    pst.setString(4, GENDER);
    pst.setString(5, PASS2);
    int x=pst.executeUpdate();
    if(x!=0){
        RequestDispatcher req = request.getRequestDispatcher("listbooks1.jsp");
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