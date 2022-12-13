package ra.model.service;

import java.util.List;

public interface ICatalogService <T,V> extends IShopService<T,V>{
    List<T> listSearchCatalog(String searchName);
}
