package ApiCalls;

public class Transcript {
    private String Id;
    private String LogOnName;

    public void setLogOnName(String logOnName) {
        LogOnName = logOnName;
    }
    public String getLogOnName() {
        return LogOnName;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id ){
        this.Id = id;
    }
}
