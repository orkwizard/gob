package com.gob.webapp.kpi.backend;

import java.util.stream.Stream;

import com.gob.webapp.kpi.model.Dependencia;
import com.vaadin.data.provider.AbstractBackEndDataProvider;
import com.vaadin.data.provider.Query;

public class DependenciaDataProvider extends AbstractBackEndDataProvider<Dependencia,String>  {

	private static final long serialVersionUID= 1L;
	private final DependenciaService dependencia_service;
	
	public DependenciaDataProvider(DependenciaService ds) {
		// TODO Auto-generated constructor stub
		this.dependencia_service = ds;
	}
	
	
	@Override
	protected Stream<Dependencia> fetchFromBackEnd(Query<Dependencia, String> query) {
		// TODO Auto-generated method stub
		return dependencia_service.fetchDependencias(query.getFilter().orElse(null), query.getLimit(), query.getOffset(),
		        query.getSortOrders()).stream();
	}

	@Override
	protected int sizeInBackEnd(Query<Dependencia, String> query) {
		// TODO Auto-generated method stub
		return dependencia_service.countDependencias(query.getFilter().orElse(null));
	}
	
	@Override
	  public Object getId(Dependencia item) {
	    // TODO Auto-generated method stub
	    return item.getId();
	  }

}
