public abstract class Pet {
    protected String name;
    protected String color;
    protected String lifeStatus;
    protected int satiety;
    public Pet (String name, String color, String lifeStatus,int satiety){
        this.name=name;
        this.color=color;
        this.lifeStatus=lifeStatus;
        this.satiety=satiety;
    }

    public abstract void run(int z);
    public abstract void swim(int z);
    public abstract void jump(float z);
    public abstract void stop();

    public abstract int getSatiety();
    public abstract void setSatiety(String lifeStatus);

    public abstract String satietyMass();
}