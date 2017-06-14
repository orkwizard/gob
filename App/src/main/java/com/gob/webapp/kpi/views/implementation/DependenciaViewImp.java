package com.gob.webapp.kpi.views.implementation;

import com.gob.webapp.kpi.backend.DependenciaDataProvider;
import com.gob.webapp.kpi.backend.DependenciaService;
import com.gob.webapp.kpi.model.Dependencia;
import com.gob.webapp.kpi.views.DependenciaView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class DependenciaViewImp extends DependenciaView implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dependencia dep;
	private DependenciaService ds = new DependenciaService();
	private DependenciaDataProvider ddp = new DependenciaDataProvider(ds);
	private boolean new_dep;

	
	
	@SuppressWarnings("unchecked")
	public DependenciaViewImp() {
		super();
		
		//list.setWidth("00px");
		list.addColumn(dep->{return "#" + ((Dependencia)dep).getId();}).setCaption("Id").setWidth(80).setSortProperty(DependenciaService.SORT_ON_ID);
		list.addColumn(dep->{return  ((Dependencia)dep).getDependencia();}).setCaption("Dependencia").setWidth(320).setSortProperty(DependenciaService.SORT_ON_NAME);
		list.addColumn(dep->{return  ((Dependencia)dep).getDescripcion();}).setCaption("Descripción").setWidth(320);
		list.setDataProvider(ddp);
		
		add.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				setFormVisible(true);
				new_dep = true;
				clearForm();

				
				
			}

			private void clearForm() {
				// TODO Auto-generated method stub
				dependencia.setValue("");
				descripcion.setValue("");
			}
		});
		
		//grid.asSingleSelect().addValueChangeListener(e -> {
		//	editor.editCustomer(e.getValue());
		//});
		
		list.asSingleSelect().addValueChangeListener(e->{
			 dep = (Dependencia) e.getValue();
			 if(dep!=null){
				System.out.println(dep.toString());
				dependencia.setValue(dep.getDependencia());
				descripcion.setValue(dep.getDescripcion());
				setFormVisible(true);
			}
		});
		
		update.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if(new_dep)
					save_dep();
				else
					update_dep();
				
			}

			private void update_dep() {
				// TODO Auto-generated method stub
				
			}

			private void save_dep() {
				// TODO Auto-generated method stub
				if(dep==null)
					dep = new Dependencia(0, dependencia.getValue(), descripcion.getValue());
				else{
					dep.setDependencia(dependencia.getValue());
					dep.setDescripcion(descripcion.getValue());
				}
				ds.addDependencia(dep);
				new_dep=false;
			}
		});
		
		cancel.addClickListener(new ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				setFormVisible(false);
			}
		});
		
		
		
		setFormVisible(false);
		// TODO Auto-generated constructor stub
	}


	private void updateGrid() {
		// TODO Auto-generated method stub
		ddp.refreshAll();
		
	}



	private void setFormVisible(boolean b) {
		// TODO Auto-generated method stub
		this.dependencia.setVisible(b);
		this.descripcion.setVisible(b);
		this.update.setVisible(b);
		this.cancel.setVisible(b);
		this.delete.setVisible(b);
	}



	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
