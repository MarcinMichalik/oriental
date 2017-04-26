package me.michalik.oriental;

public class OrientalProperties {

    private String url;
    private String user;
    private String password;
    private Integer minPool = 1;
    private Integer maxPool = 50;
    private Boolean autoStartTx = false;
    private Boolean requireTransaction = false;
    private Boolean keepInMemoryReference = false;
    private Boolean useLightweightEdges = true;
    private Integer maxRetries = 50;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMinPool() {
        return minPool;
    }

    public void setMinPool(Integer minPool) {
        this.minPool = minPool;
    }

    public Integer getMaxPool() {
        return maxPool;
    }

    public void setMaxPool(Integer maxPool) {
        this.maxPool = maxPool;
    }

    public Boolean getAutoStartTx() {
        return autoStartTx;
    }

    public void setAutoStartTx(Boolean autoStartTx) {
        this.autoStartTx = autoStartTx;
    }

    public Boolean getRequireTransaction() {
        return requireTransaction;
    }

    public void setRequireTransaction(Boolean requireTransaction) {
        this.requireTransaction = requireTransaction;
    }

    public Boolean getKeepInMemoryReference() {
        return keepInMemoryReference;
    }

    public void setKeepInMemoryReference(Boolean keepInMemoryReference) {
        this.keepInMemoryReference = keepInMemoryReference;
    }

    public Boolean getUseLightweightEdges() {
        return useLightweightEdges;
    }

    public void setUseLightweightEdges(Boolean useLightweightEdges) {
        this.useLightweightEdges = useLightweightEdges;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }
}