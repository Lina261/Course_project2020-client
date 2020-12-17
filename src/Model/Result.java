package Model;

public class Result {
    private int idResult;
    private int idFeature;
    private Double result;
    private int idFactory;
    private String factoryName;

    public Result(int idResult, int idFeature, Double result, int idFactory, String factoryName) {
        this.idResult = idResult;
        this.idFeature = idFeature;
        this.result = result;
        this.idFactory = idFactory;
        this.factoryName = factoryName;
    }

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public int getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(int idFeature) {
        this.idFeature = idFeature;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
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
