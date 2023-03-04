package com.ineuron.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ineuron.utility.JDBCutility;

public class ServiceImpl implements Service {

	@Override
	public float checkBalance(String userName) {
		String query="select amount from bank where name='"+userName+"' ";
		float amount=0.0f;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=JDBCutility.getConnection();

		try {
			ps=conn.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println("Error in checkBalance method");
		}

		try {
			rs=ps.executeQuery(query);

			rs.next();
			amount=rs.getFloat("amount");
		} catch (SQLException e) {
			System.out.println("User Not Found");
		}
		return amount;
	}

	@Override
	public String depositeAmount(String userName, Float amount) {

		String query="select amount from bank where name='"+userName+"' ";
		PreparedStatement ps=null;
		ResultSet rs=null;
		float updatedAmount=0.0f;
		float availableAmount=0.0f;
		Connection conn=JDBCutility.getConnection();
		try {
			ps=conn.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println("Error in widraw method");
		}

		try {
			rs=ps.executeQuery(query);
			rs.next();
			availableAmount=rs.getFloat("amount");
			updatedAmount=availableAmount+amount;
			String query1="update bank set amount='"+updatedAmount+"' where name='"+userName+"' ";
			ps=conn.prepareStatement(query1);
			int i=ps.executeUpdate(query1);



		} catch (SQLException e) {
			System.out.println("User Not Found");
		}
		return "After Deposite Your Avilable Amount Is ::" +updatedAmount;
	}


	@Override
	public String widrawAmount(String username, Float amount) {
		String query="select amount from bank where name='"+username+"' ";
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=JDBCutility.getConnection();
		try {
			ps=conn.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println("Error in widraw method");
		}

		try {
			rs=ps.executeQuery(query);
			rs.next();
			float availableAmount=rs.getFloat("amount");
			if(amount>availableAmount) {
				System.out.println("Balace is low");
			}
			else {
				Float updatedAmount=availableAmount-amount;
				String query1="update bank set amount='"+updatedAmount+"' where name='"+username+"' ";
				ps=conn.prepareStatement(query1);
				int i=ps.executeUpdate(query1);
				if(i>=1) {
					System.out.println("Amount After Widrawal :: "+ updatedAmount);
				}
			}
		} catch (SQLException e) {
			System.out.println("User Not Found");
		}
		return "amoount Widrawal Succesfully";
	}

	@Override
	public boolean verifyUser(String userName) {
		boolean flag=false;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=JDBCutility.getConnection();
		String query="select name from bank where name='"+userName+"' ";

		try {
			ps=conn.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println("Error in verify method");
		}

		try {
			rs=ps.executeQuery(query);

			rs.next();
			if(rs.getString("name").equalsIgnoreCase(userName)){
				//				System.out.println("user available");
				flag=true;
			}
		} catch (SQLException e) {
			System.out.println("User Not Found");
		}


		return flag;
	}

}
