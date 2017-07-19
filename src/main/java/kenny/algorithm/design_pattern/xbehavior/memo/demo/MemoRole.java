package kenny.algorithm.design_pattern.xbehavior.memo.demo;

public class MemoRole {

    private int useTime;// 使用时间
    private String deviceName;// 设备名称
    private int stateLevel;// 状态

    public MemoRole(String deviceName, int useTime, int stateLevel) {
        super();
        this.useTime = useTime;
        this.deviceName = deviceName;
        this.stateLevel = stateLevel;
    }

    public MemoRole() {
    }

    public int getUseTime() {
        return useTime;
    }

    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getStateLevel() {
        return stateLevel;
    }

    public void setStateLevel(int stateLevel) {
        this.stateLevel = stateLevel;
    }

    public MemoBean createMemoObject() {
        MemoBean memento = new MemoBean();
        memento.setDeviceName(deviceName);
        memento.setStateLevel(stateLevel);
        memento.setUseTime(useTime);
        return memento;
    }

    public void setMemento(MemoBean memento) {
        this.deviceName = memento.getDeviceName();
        this.stateLevel = memento.getStateLevel();
        this.useTime = memento.getUseTime();
    }

    public void getCurrentState() {
        System.out.println("当前设备名称：" + this.deviceName
                         + "当前使用时间：" + this.useTime
                         + "当前工作状态：" + this.stateLevel);
    }
}
