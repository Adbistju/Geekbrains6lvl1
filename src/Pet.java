public abstract class Pet {
    protected String name;
    protected String color;
    protected String lifeStatus;

    public Pet (String name, String color, String lifeStatus){
        this.name=name;
        this.color=color;
        this.lifeStatus=lifeStatus;
    }

    public abstract void run(int z);
    public abstract void swim(int z);
    public abstract void jump(float z);
    public abstract void stop();

    @Override
    public String toString(){
        return "Pet{"+ "name='"+name+'\''+'}';
    }
}
