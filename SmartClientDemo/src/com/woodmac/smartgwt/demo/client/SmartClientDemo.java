package com.woodmac.smartgwt.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.FetchMode;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.KeyCallback;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartClientDemo implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		
        registerKeyForDeveloperConsole();

		
		final ListGrid listGrid = new ListGrid();  
        listGrid.setWidth(900);  
        listGrid.setHeight(224);  
        listGrid.setAlternateRecordStyles(true);  
        listGrid.setDataSource(DataSource.get("worldDS")); 
        listGrid.setDataFetchMode(FetchMode.LOCAL);
        listGrid.setAutoFetchData(true);  
        listGrid.setShowFilterEditor(true);  
        listGrid.setCanEdit(true);  
        listGrid.setEditEvent(ListGridEditEvent.CLICK);  
        listGrid.setCanRemoveRecords(true);
        listGrid.setOverflow(Overflow.VISIBLE);
        listGrid.setAutoFitMaxRecords(180*1000);
       
  
        VLayout layout = new VLayout(15);  
        layout.addMember(listGrid);  
  
        layout.draw(); 
        
	}
	
	 private void registerKeyForDeveloperConsole() {
	        KeyIdentifier debugKey = new KeyIdentifier();
	        debugKey.setCtrlKey(true);
	        debugKey.setAltKey(true);
	        debugKey.setKeyName("D");
	        Page.registerKey(debugKey, new KeyCallback() {
	            public void execute(String keyName) {
	                SC.showConsole();
	            }
	        });
	    }
	
}
