<%@ page import="java.sql.*"%>
<%
String ID=request.getParameter("admin_id");
String NAME=request.getParameter("admin_name");
String EMAIL=request.getParameter("admin_email");
String GENDER=request.getParameter("admin_gender");
String PASS1=request.getParameter("admin_pass1");
String PASS2=request.getParameter("admin_pass2");
String original="jayaraman";
String orgpass="jayam1234";
if(NAME.equals(original)&&(orgpass.equals(PASS2))){
  try
{
      Class.forName("oracle.jdbc.OracleDriver");
    Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:jayam","scott","tiger");
    PreparedStatement pst= con.prepareStatement("insert into admin values(?,?,?,?,?)");
    pst.setString(1, ID);
    pst.setString(2, NAME);
    pst.setString(3, EMAIL);
    pst.setString(4, GENDER);
    pst.setString(5, PASS2);
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
