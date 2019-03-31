package kz.aa.shop.onlineShop.util;

import java.util.List;

public class ValidationResponse {

    private String status;
    private List<ErrorMessage> errorMessageList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ErrorMessage> getErrorMessageList() {
        return errorMessageList;
    }

    public void setErrorMessageList(List<ErrorMessage> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }
}