package ra.model.DAO;

import java.util.List;

public interface IShopDAO<T,V> {
    List<T> getAllCatalog();
    T getById(V id);
    boolean insertCat(T t);
    boolean updateCat(T t);
    boolean deleteCat(V id);
}
