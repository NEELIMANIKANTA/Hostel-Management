package com.sathya.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	public int save(User user)
	{
		int count=0;
		try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("insert into user_details values(?,?,?,?,?,?,?)");)
		{
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getConfirmpassword());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setLong(6, user.getMobile());
			preparedStatement.setString(7, user.getAddress());
			
			count = preparedStatement.executeUpdate();
			System.out.println(count);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return count;
		
	}
	public User findDetails(String Username)
	{
		User user=null;
		try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select username, password  from user_details where username=?");)
		{
			preparedStatement.setString(1, Username);
			

			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				user = new User();
				user.setUserName(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public User findDetailsForgetPass(String Username)
	{
		User user=null;
		try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select username, password, email   from user_details where username=?");)
		{
			preparedStatement.setString(1, Username);
			

			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				user = new User();
				user.setUserName(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User findDetailsOfRoom(String value1) {
		
	    User user = null;
	    try (Connection connection = Dbconnection.createConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from Hostel_details where Category = ?");) {
	        preparedStatement.setString(1, value1);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	       
	        
	        // Check if there is a result
	        
	        if (resultSet.next()) {
	            user = new User();
	            // Set its properties
	            user.setCategory(resultSet.getString("Category"));
	            user.setRooms_Available(resultSet.getInt("Rooms_Available"));
	            user.setPricing(resultSet.getInt(3));   
	        }
	            
	        System.out.println(user);
	    } catch (Exception e) {
	        // Handle exceptions
	        e.printStackTrace();
	    }
	    return user;
	}
	
	public int saveUserBookingDetails(User user)
	{
		int count=0;
	String sql="insert into User_booking_details(username,BookedRoom,pricePerDay,checkIn,checkOut,durationOfStay,rent,sgst,cgst,discount,totalPrice,aadharImage) values(?,?,?,?,?,?,?,?,?,?,?,?)";     
	    try (Connection connection = Dbconnection.createConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);) 
	    {
	    	preparedStatement.setString(1, user.getUserName());
	    	preparedStatement.setString(2, user.getCategory());
	    	preparedStatement.setDouble(3, user.getPricing());
	    	preparedStatement.setDate(4, user.getCheck_in_date());
	    	preparedStatement.setDate(5, user.getCheck_out_date());
	    	preparedStatement.setInt(6, user.getDuration());
	    	preparedStatement.setDouble(7, user.getTotalrent());
	    	preparedStatement.setDouble(8, user.getSgst());
	    	preparedStatement.setDouble(9, user.getCgst());
	    	preparedStatement.setDouble(10, user.getDiscount());
	    	preparedStatement.setDouble(11, user.getTotalPrice());
	    	preparedStatement.setBytes(12, user.getAdhaar());
	    	
	    	count = preparedStatement.executeUpdate();
	    }
	    catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}
	    return count;
	}
	public String getEmail(String username)
	{
		String email = null;
		try (Connection connection = Dbconnection.createConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("select email from user_details where username = ?");) 
	    {
			preparedStatement.setString(1, username);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			
			if(resultSet.next())
			{
				email = resultSet.getString(1);
				
			}
			
	    }
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return email;
	}
	public List<User> findUSerBookingDetailsByUsername(String username)
	{
		List<User> l = new ArrayList<User>();
		try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from User_booking_details where username =?");)
		{
			preparedStatement.setString(1, username);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				User user = new User();
				user.setBookingId(resultSet.getString(1));
				user.setUserName(resultSet.getString(2));
				user.setCategory(resultSet.getString(3));
				user.setPricing(resultSet.getDouble(4));
				user.setCheck_in_date(resultSet.getDate(5));
				user.setCheck_out_date(resultSet.getDate(6));
				user.setDuration(resultSet.getInt(7));
				user.setTotalrent(resultSet.getDouble(8));
				user.setSgst(resultSet.getDouble(9));
				user.setCgst(resultSet.getDouble(10));
				user.setDiscount(resultSet.getDouble(11));
				user.setTotalPrice(resultSet.getDouble(12));
				user.setAdhaar(resultSet.getBytes(13));
				
				l.add(user);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}
	public int updateRooms(String roomType)
	{
		int count=0;
		try(Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("update hostel_details set rooms_available = rooms_available-1 where category=?");)
		{
			preparedStatement.setString(1, roomType);
			
			count = preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
	public int getAvailableRooms(String type) {
		int count = 0;
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select rooms_available from hostel_details where Category = ?");) {

			preparedStatement.setString(1, type);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			count = resultSet.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection failed");
		}

		return count;
	}
	
	public int contactUsDetails(User user)
	{
		int count = 0;
		try (Connection connection = Dbconnection.createConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into contactus_details values(?,?,?)");) 
		{
			preparedStatement.setString(1, user.getName());
			preparedStatement.setLong(2, user.getMobile());
			preparedStatement.setString(3, user.getComments());
			
			count = preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;

	}

	
}
