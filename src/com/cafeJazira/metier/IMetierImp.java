package com.cafeJazira.metier;

import java.util.List;

import com.cafeJazira.dao.DaoImp;
import com.cafeJazira.dao.IDao;
import com.cafeJazira.model.Cafe;

public class IMetierImp implements IMetier<Cafe>{

	IDao<Cafe>cafe = new DaoImp();
	@Override
	public List<Cafe> getAll() {
		return cafe.getAll();
	}

	@Override
	public boolean create(Cafe obj) {
		return cafe.create(obj);
	}

	@Override
	public boolean update(Cafe obj) {
		return cafe.update(obj);
	}

	@Override
	public boolean delete(Cafe obj) {
		return cafe.delete(obj);
	}

}
