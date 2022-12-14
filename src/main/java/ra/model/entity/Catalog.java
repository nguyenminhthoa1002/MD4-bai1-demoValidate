package ra.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Catalog {
    int catalogID;
    @Size(min = 6, message = "* Vui lòng nhập hơn 5 ký tự")
    String catalogName;

    String catalogDescription;
    @NotNull(message = "* required")
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
