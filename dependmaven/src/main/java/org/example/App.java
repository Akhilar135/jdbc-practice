package org.example;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//step 1--> Register the driver
        try {
            Class.forName("com.mysql.jdbc.Driver");


        // 2- Connection object
        Connection connection;
            connection = getConnection("jdbc:mysql://localhost:3306/sql_store", "root", "pass@word1");

        // 3- Statement object

            Statement statement = connection.createStatement();

       //statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//// resultset
//        ResultSet resultSet = statement.executeQuery("select * from customers");
//        resultSet.absolute(2);
//        System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2) + " "+ resultSet.getString(8));

            // UPDATE

//            int result = statement.executeUpdate("UPDATE Customers set first_name='Akhila' where customer_id=5");
//            System.out.println(result + " "+ "records updated");

//            // CREATE
//            int result = statement.executeUpdate("INSERT into Customers(first_name, last_name, birth_date, address, city, state)\n" +
//                    "Values ('Akhila', 'R', '2000-05-16', 'Trivandrum','city', 'IN')");
//            System.out.println(result + " "+ "records updated");

            // DELETE
//            int result = statement.executeUpdate("DELETE from Customers where customer_id=11");
//            System.out.println(result + " "+ "records updated");

            //ALTER
//            int result = statement.executeUpdate(" alter table customers add Status int;");
//            System.out.println(result + " "+ "records updated");

            //Prepared statement

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into Customers(first_name, last_name, birth_date, address, city, state)\n" +
                    "Values (?, ?, ?, ?,?, ?)");
            preparedStatement.setString(1,"Akhil");
            preparedStatement.setString(2,"R");
            preparedStatement.setString(3,"2000-06-05");
            preparedStatement.setString(4,"Kochi");
            preparedStatement.setString(5,"koc");
            preparedStatement.setString(6,"KL");
            int res = preparedStatement.executeUpdate();
            System.out.println(res + " "+ "records updated");


            // 5- close connection
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
