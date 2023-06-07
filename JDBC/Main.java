package JDBC;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        insertRecords();
//        readRecords();
//        insertVariableRecords();
//        insertUsingPST();
//        delete();
//        update();
//        sp();
//        SPInputPara();
//        SPInputOutputPara();
//        CommitDemo();
          batchDemo();
    }

//    Read Records from DB
    public static void readRecords() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            Connection connection = DriverManager.getConnection(url, userName, passWord);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from employee");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    insert Records into DB
    public static void insertRecords() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";
            String query = "insert into employee values (4,'nirmal',45000)";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            Statement statement = connection.createStatement();

            int rows = statement.executeUpdate(query);
            System.out.println("Number of Rows Affected " + rows);
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Insert Data using Variables
    public static void insertVariableRecords() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            int id = 5;
            String name = "Barani";
            int salary = 60000;
            String query = "insert into employee values (" + id + ",'" + name + "'," + salary + ")";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(query);

            System.out.println("Number of Rows Affected " + rows);
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Insert using PreparedStatement
    public static void insertUsingPST() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            int id = 6;
            String name = "Raju";
            int salary = 20000;
            String query = "insert into employee values(?,?,?)";

            Connection connection = DriverManager.getConnection(url, userName, passWord);

            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, salary);
            int rows = pst.executeUpdate();

            System.out.println("Number of Rows Affected " + rows);
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //    Delete
    public static void delete() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            int id = 6;
            String query = "delete from employee where emp_id = " + id;

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(query);

            System.out.println("Number of Rows Affected " + rows);
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Update

    public static void update() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            String query = "update employee set salary = 1500000 where emp_id = 1";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            Statement statement = connection.createStatement();

            int rows = statement.executeUpdate(query);

            System.out.println("Number of Rows Affected " + rows);
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//        Types of Statements
//        Normal Statements
//        Prepared Statements
//        Callable Statements

//    Calling simple stored procedure

    public static void sp() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            CallableStatement cst = connection.prepareCall("{call GetEmp()}");
            ResultSet resultSet = cst.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Calling stored procedure with input parameters

    public static void SPInputPara() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            int id = 4;

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            CallableStatement cst = connection.prepareCall("{call GetEmpId(?)}");
            cst.setInt(1, id);

            ResultSet resultSet = cst.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Calling stored procedure with input and out parameters

    public static void SPInputOutputPara() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            int id = 4;

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            CallableStatement cst = connection.prepareCall("{call GetNameById(?,?)}");

            cst.setInt(1, id);
            cst.registerOutParameter(2, Types.VARCHAR);

            cst.executeUpdate();

            System.out.println(cst.getString(2));

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Commit vs AutoCommit

    public static void CommitDemo() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            String query1 = "update employee set salary = 500000 where emp_id = 1";
            String query2 = "update employee set salary = 500000 where emp_id = 2";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            int rows1 = statement.executeUpdate(query1);
            System.out.println("Number of Rows Affected " + rows1);

            int rows2 = statement.executeUpdate(query2);
            System.out.println("Number of Rows Affected " + rows2);

            if (rows1 > 0 && rows2 > 0) {
                connection.commit();
            }
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Batch Processing

    public static void batchDemo() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String userName = "root";
            String passWord = "Balaji@21042003";

            String query1 = "update employee set salary = 500000 where emp_id = 1";
            String query2 = "update employee set salary = 600000 where emp_id = 2";
            String query3 = "update employee set salary = 200000 where emp_id = 3";
            String query4 = "update employee set salary = 700000 where emp_id = 4";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.addBatch(query3);
            statement.addBatch(query4);

            int[] array = statement.executeBatch();
            for(int i:array){
                if(i>0){
                    continue;
                }else{
                    connection.rollback();
                }
            }
            connection.commit();

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
