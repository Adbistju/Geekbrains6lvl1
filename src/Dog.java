public class Dog extends Pet {

    protected int run;
    protected float jump;
    protected int swim;

    public Dog(String name, String color, String lifeStatus,int run,float jump,int swim,int satiety){
        super(name,color,lifeStatus,satiety);
        this.run=run;
        this.jump=jump;
        this.swim=swim;

    }

    @Override
    public void run(int i){
        if(i<run){
            System.out.println("true");
            System.out.println("run!");
        }else{
            System.out.println("false");
            stop();
        }
    }
    @Override
    public void swim(int i){
        if(i<swim){
            System.out.println("true");
            System.out.println("swim!");
        }else{
            System.out.println("false");
            stop();
        }
    }
    @Override
    public void jump(float i){
        if(i<jump){
            System.out.println("true");
            System.out.println("jump!");
        }else{
            System.out.println("false");
            stop();
        }
    }
    @Override
    public void stop(){
        System.out.println("STOP!");
    }

    @Override
    public String toString(){
        String jump1 = String.format("%.3f",jump);
        return "Dog{"+ "Имя "+name+" цвет "+color+"  "+lifeStatus+" бег "+run+"м прыжок "+jump1+"м плавание "+swim+"м потребление пищи "+satiety+" ед."+'\''+'}';
    }
    public void setSatiety(String status){
        lifeStatus=status;
    }
    @Override
    public String satietyMass(){
        return " "+name+" "+satiety+'\n';
    }
    @Override
    public int getSatiety(){
        return satiety;
    }
}