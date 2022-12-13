package ra.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Catalog {
    int catalogID;
    @NotEmpty(message = "required")
    String catalogName;
    @NotEmpty(message = "Không được để trống")
    String catalogDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createDate;
    Boolean catalogStatus;

    public Catalog(int catalogID, String catalogName, String catalogDescription, Date createDate, Boolean catalogStatus) {
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.catalogDescription = catalogDescription;
        this.createDate = createDate;
        this.catalogStatus = catalogStatus;
    }

    public Catalog() {
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
