package com.gob.app.kpis.AppKPIS;


import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

@SpringUI
public class AppUI extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private DependenciaService service;
	
	private Dependencia dependencia;
	
	private Binder<Dependencia> binder = new Binder<>(Dependencia.class);
	
	private Grid<Dependencia> grid = new Grid<Dependencia>(Dependencia.class);
	private TextField txtDependencia = new TextField("Dependencia ->");
	private TextField txtDescripcion = new TextField("Descripcion ->");
	private Button save = new Button("Save", e->saveDependencia());
	

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		System.out.println("updateGrid");
		
		updateGrid();
		
		System.out.println("setColumns");
		
		grid.setColumns("Dependencia","Descripcion");
		
        
        System.out.println("Listener");
		
        grid.addSelectionListener(e -> updateForm());

        System.out.println("Binder");
		
        binder.bindInstanceFields(this);
        
        
        
        
        

        VerticalLayout layout = new VerticalLayout(grid, txtDependencia, txtDescripcion, save);
        setContent(layout);
	}




	private void updateForm() {
		// TODO Auto-generated method stub
		if (grid.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
            dependencia = grid.asSingleSelect().getValue();
            binder.setBean(dependencia);
            setFormVisible(true);
        }
	}




	private void updateGrid() {
		// TODO Auto-generated method stub
		 List<Dependencia> dependencias = service.findAll();
		
		 Iterator<Dependencia> iterator = dependencias.iterator();
		 while(iterator.hasNext())
			 System.out.println(iterator.next().toString());
		 
	        grid.setItems(dependencias);
	        setFormVisible(false);
	}




	private void setFormVisible(boolean b) {
		// TODO Auto-generated method stub
		txtDependencia.setVisible(b);
		txtDescripcion.setVisible(b);
		save.setVisible(b);
	}




	private void saveDependencia() {
		// TODO Auto-generated method stub
		service.update(dependencia);
		updateGrid();
	}

}
