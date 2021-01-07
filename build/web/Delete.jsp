<html>
    <head>
        <title>Delete</title>
    </head>
    <body>
        <%@page import="java.sql.*" %>
        <%! String book_id;%>
        <% book_id=request.getParameter("book_id");%>
        <% Connection con=null;
        try
                               {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:jayam","scott","tiger");
            String sql="delete from books where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, book_id);
            pst.executeUpdate();
            pst.close();
        }
        catch(ClassNotFoundException e){
            out.println("could n't load DBdriver"+e.getMessage());
            
        }
        catch(SQLException e1){
            out.println("Exception caught"+e1.getMessage());
        }
        catch(Exception e2){
            out.println(e2);
        }
        finally{
            try{
                if(con!=null)
            con.close();
            }
            catch(SQLException ignore){
                out.println("ignored");
            }
            
        }
        RequestDispatcher req = request.getRequestDispatcher("listbooks.jsp");
			req.include(request, response);
                        %>
                              
    </body>
</html>