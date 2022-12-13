package ra.model.service;

import java.util.List;

public interface IShopService<T,V> {
    List<T> getAllCatalog();
    T getById(V id);
    boolean insertCat(T t);
    boolean updateCat(T t);
    boolean deleteCat(V id);
}
