package com.woodmac.smartgwt.demo.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.corba.se.impl.util.Version;

public class DataFiller {

	Logger lgr = Logger.getLogger(this.getClass().getName());
	Connection con = null;
    PreparedStatement pst = null;
	
	public static void main(String[] args) throws Exception {
		
		DataFiller filler = new DataFiller();
		filler.loadData();
        
	}
	
	public void loadData() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/smart_db";
        String user = "root";
        String password = "root";
        try{
        	con = DriverManager.getConnection(url, user, password);
        	dataInsert();
        	
        }finally{
        	if (con != null) {
              con.close();
          }
        }

	}
	
	public void dataInsert(){
		int totalRecords =  80*1000;
		
		
		for(int i=0; i< totalRecords; i++){
			System.out.println("Record ID["+i+"]");
			try {
		          
		          pst = con.prepareStatement("INSERT INTO `smart_db`.`data_table` ( `type`, `data`) VALUES ( ?, ?)	");
		          pst.setString(1, "Data Item "+i);
		          //pst.setString(2, "{'name':'My Name "+i+"','address':'My Address "+i+"', 'country':'My Country "+i+"', 'telephone':'My Telephone "+i+"'}");
		          pst.setString(2,"{ID:"+i+",WI_DIS_RES:208514.5989432,CENTROID_Y:26.56666667,CENTROID_X:51.76666667,DIM_WELL_ID:80740,OIL_GAS_DRY:'Gas',WELL_TYPE:'Exploration',WELL_NAME:'North West Dome-1',LOCATION_NAME:'Qatar',WELL_OPERATOR_SHORT_NAME:'Shell'}");
		          pst.executeUpdate();
		      } catch (SQLException ex) {
		          lgr.log(Level.SEVERE, ex.getMessage(), ex);

		      } finally {
		          try {
		              
		              if (pst != null) {
		                  pst.close();
		              }
		             

		          } catch (SQLException ex) {
		              lgr.log(Level.WARNING, ex.getMessage(), ex);
		          }
		      }
				
		}
	}
	

}
