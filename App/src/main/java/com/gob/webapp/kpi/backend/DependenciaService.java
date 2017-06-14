package com.gob.webapp.kpi.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gob.webapp.kpi.model.Dependencia;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;

public class DependenciaService {
	public static final String SORT_ON_ID = "id";
	  public static final String SORT_ON_NAME = "dependencia";

	 ArrayList<Dependencia> fetchDependencias(String filter, int limit, int offset, List<QuerySortOrder> sortOrders) 
	 {
		// TODO Auto-generated method stub
		 if (filter == null) {
		      filter = "";
		    }
		    filter = "%" + filter.toLowerCase().trim() + "%";
		    if (sortOrders == null || sortOrders.isEmpty()) {
		      sortOrders = new ArrayList<>();
		      sortOrders.add(new QuerySortOrder(SORT_ON_NAME, SortDirection.ASCENDING));
		    }
	     
		  ArrayList<Dependencia> dependencias = new ArrayList<>();
		  
		  try {
			Connection conn = DatabaseService.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from dependencias ");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Dependencia dep = new Dependencia(rs.getLong("id"), rs.getString("dependencia"), rs.getString("descripcion"));
				dependencias.add(dep);
			}
			conn.close();
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return dependencias;
	}

	 int countDependencias(String filter) {
		// TODO Auto-generated method stub
		 if (filter == null) {
		      filter = "";
		    }
		    filter = "%" + filter.toLowerCase().trim() + "%";
		    int count = 0;
		    Connection conn;
		   
		    try {
		        conn = DatabaseService.getInstance().getConnection();
		        PreparedStatement stmt = conn
		            .prepareStatement("select count(*) from dependencias" + " where lower(dependencia) like ? ");
		        stmt.setString(1, filter);
		        ResultSet rs = stmt.executeQuery();
		        while (rs.next()) {
		          count = rs.getInt(1);
		        }
		        conn.close();
		      } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        System.out.println(e.getMessage());
		      } catch (IOException e) {
		        // TODO Auto-generated catch block
		        System.out.println(e.getMessage());
		      }
		      return count;
	}

	 public void addDependencia(Dependencia d){
		 
		 try {
			Connection conn = DatabaseService.getInstance().getConnection();
			PreparedStatement stmt =  conn.prepareStatement("INSERT INTO dependencias(dependencia,descripcion) values(?,?)");
			stmt.setString(1,d.getDependencia());
			stmt.setString(2, d.getDescripcion());
			
			int affectedRows = stmt.executeUpdate();
			
			System.out.println("Affected Rows :" + affectedRows);
			
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
