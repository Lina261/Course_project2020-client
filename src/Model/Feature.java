package Model;

public class Feature {
    private int idFeature;
    private Double proceeds;
    private Double assets;
    private Double equity;
    private Double bacon;
    private int idFactory;
    private String factoryName;

    public Feature(int idFeature,String factoryName, Double proceeds, Double assets, Double equity, Double bacon) {
        this.idFeature = idFeature;
        this.factoryName=factoryName;
        this.proceeds = proceeds;
        this.assets = assets;
        this.equity = equity;
        this.bacon = bacon;

    }

    public int getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(int idFeature) {
        this.idFeature = idFeature;
    }

    public Double getProceeds() {
        return proceeds;
    }

    public void setProceeds(Double proceeds) {
        this.proceeds = proceeds;
    }

    public Double getAssets() {
        return assets;
    }

    public void setAssets(Double assets) {
        this.assets = assets;
    }

    public Double getEquity() {
        return equity;
    }

    public void setEquity(Double equity) {
        this.equity = equity;
    }

    public Double getBacon() {
        return bacon;
    }

    public void setBacon(Double bacon) {
        this.bacon = bacon;
    }

    public int getIdFactory() {
        return idFactory;
    }

    public void setIdFactory(int idFactory) {
        this.idFactory = idFactory;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}
