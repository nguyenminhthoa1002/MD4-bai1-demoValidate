package ra.model.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.DAO.ICatalogDAO;
import ra.model.entity.Catalog;
import ra.model.service.ICatalogService;

import java.util.List;

@Service
public class CatalogService implements ICatalogService<Catalog,Integer> {
    @Autowired
    public ICatalogDAO catalogDAO;

    @Override
    public List<Catalog> listSearchCatalog(String searchName) {
        return catalogDAO.listSearchCatalog(searchName);
    }

    @Override
    public List<Catalog> getAllCatalog() {
        return catalogDAO.getAllCatalog();
    }

    @Override
    public Catalog getById(Integer id) {
        return (Catalog) catalogDAO.getById(id);
    }

    @Override
    public boolean insertCat(Catalog catalog) {
        return catalogDAO.insertCat(catalog);
    }

    @Override
    public boolean updateCat(Catalog catalog) {
        return catalogDAO.updateCat(catalog);
    }

    @Override
    public boolean deleteCat(Integer id) {
        return catalogDAO.deleteCat(id);
    }
}
