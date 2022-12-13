package ra.model.DAOImple;

import org.springframework.stereotype.Repository;
import ra.model.DAO.ICatalogDAO;
import ra.model.entity.Catalog;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CatalogDAO implements ICatalogDAO<Catalog,Integer> {
    @Override
    public List<Catalog> listSearchCatalog(String searchName) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listSearchCatalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_search(?)}");
            callSt.setString(1,searchName);
            ResultSet rs = callSt.executeQuery();
            listSearchCatalog = new ArrayList<>();
            while (rs.next()){
                Catalog cat = new Catalog();
                cat.setCatalogID(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setCatalogDescription(rs.getString("catalogDescription"));
                cat.setCreateDate(rs.getDate("createDate"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                listSearchCatalog.add(cat);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listSearchCatalog;
    }

    @Override
    public List<Catalog> getAllCatalog() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAll()}");
            ResultSet rs = callSt.executeQuery();
            listCatalog = new ArrayList<>();
            while (rs.next()){
                Catalog cat = new Catalog();
                cat.setCatalogID(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setCatalogDescription(rs.getString("catalogDescription"));
                cat.setCreateDate(rs.getDate("createDate"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                listCatalog.add(cat);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCatalog;
    }

    @Override
    public Catalog getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Catalog catalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getById(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            catalog = new Catalog();
            if (rs.next()){
                catalog.setCatalogID(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setCatalogDescription(rs.getString("catalogDescription"));
                catalog.setCreateDate(rs.getDate("createDate"));
                catalog.setCatalogStatus(rs.getBoolean("catalogStatus"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return catalog;
    }

    @Override
    public boolean insertCat(Catalog catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insert(?,?,?,?)}");
            callSt.setString(1, catalog.getCatalogName());
            callSt.setString(2, catalog.getCatalogDescription());
            callSt.setDate(3,new Date(catalog.getCreateDate().getTime()));
            callSt.setBoolean(4,catalog.getCatalogStatus());
            callSt.executeUpdate();
        } catch (SQLException ex){
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean updateCat(Catalog catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_update(?,?,?,?,?)}");
            callSt.setInt(1,catalog.getCatalogID());
            callSt.setString(2, catalog.getCatalogName());
            callSt.setString(3, catalog.getCatalogDescription());
            callSt.setDate(4,new Date(catalog.getCreateDate().getTime()));
            callSt.setBoolean(5,catalog.getCatalogStatus());
            callSt.executeUpdate();
        }catch (SQLException ex){
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean deleteCat(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_delete(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        } catch (SQLException ex){
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
}
