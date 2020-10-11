import java.util.Random;
import java.util.Scanner;

public class Main{
    public static Random random = new Random();
    public static Scanner scanner=new Scanner(System.in);

    protected static Pet[] petListnew;

    Plate pl1=new Plate(0);
    protected static String[] petName={"Вася","Коля","Лена","Аня","Даша","Маша","Игорь","Витя","Митяй"};
    protected static String[] petColor={"Крассный","Синий","Зеленый","Желтый"};
    protected static String[] lifeStatus ={"сытый", "голодный"};

    public static void main (String [] args){
        Plate pl1=new Plate(0);
        int h=0;
        System.out.println("Какое колличество животных позвать?");
        h=scanner.nextInt();
        petListnew=new Pet[h];//создайть экземпляр класса и вызовите нестатический метод
        Main spavnPet = new Main();
        spavnPet.spavnPet();
    }
    public void spavnPet(){
        int x,y;
        int b=0;
        for (int i = 0; i < petListnew.length; i++) {
            x= random.nextInt(petName.length);
            y= random.nextInt(petColor.length);
            if(b==0){
                petListnew[i]=new Dog(petName[x],petColor[y],lifeStatus[1],limitationRun(b),limitationJump(b),limitationSwim(b),satiety(b));
                b=random.nextInt(2);
            }else if(b==1){
                petListnew[i]=new Cat(petName[x],petColor[y],lifeStatus[1],limitationRun(b),limitationJump(b),limitationSwim(b),satiety(b));
                b=random.nextInt(2);
            }

        }

        sayActPet(scanner);
    }
    public static int limitationRun(int b){
        int run;
        if(b==0){
            return run=random.nextInt(500);
        }else if(b==1){
            return run=random.nextInt(200);
        }
        return 0;
    }
    protected static float limitationJump (int b){
        float jump=0;
        if(b==0){
            return jump=random.nextFloat()/20*5;
        }else if(b==1){
            return jump=random.nextFloat()+1;
        }
        return 0;
    }
    protected static int limitationSwim (int b){
        int swim;
        if(b==0){
            return swim=random.nextInt(10);
        }else if(b==1){
            return 0;
        }
        return 0;
    }
    protected void sayActPet(Scanner scanner){
        int x,y,z;
        float f;
        while (true) {

            if (eatBoolean()){
                printPet();
                System.out.println("Какому питомцу следует выполнить действие?");
                x = scanner.nextInt()-1;
                System.out.println("Питомец №"+(x+1)+" по кличке " + petListnew[x].name );
                System.out.println("Какое действие выполнить питомцу?\n1.run\n2.jump\n3.swim\n4.eat all!");
                y=scanner.nextInt();
                if(eatBoolean(x)){
                    switch (y){
                        case 1:
                            System.out.println("Дистанция бега:");
                            z=scanner.nextInt();
                            petListnew[x].run(z);
                            petListnew[x].setSatiety(lifeStatus[1]);
                            break;
                        case 2:
                                System.out.println("Высота прыжка:");
                                f=scanner.nextFloat();
                                petListnew[x].jump(f);
                                petListnew[x].setSatiety(lifeStatus[1]);
                                break;
                        case 3:
                                System.out.println("Проплыть дистанцию:");
                                z=scanner.nextInt();
                                petListnew[x].swim(z);
                                petListnew[x].setSatiety(lifeStatus[1]);
                                break;
                        case 4:
                            refillingTheBowl(scanner);
                            fillThePlates();
                            break;
                            default:
                                petListnew[x].stop();
                                break;
                    }
                }else{
                    System.out.println("Я не буду ничего делать. Я голоден!");
                }

            }else{
                do{
                    printPet();
                    System.out.println("Все животные голодны! Их нужно покормить. Пополнить запас еды в тарелке?\n1.ДА\n2.Нет");
                    x = scanner.nextInt();
                    if (x==1){
                        refillingTheBowl(scanner);
                        fillThePlates();
                }else if(x==2){
                        if (!eatBoolean()){
                            System.out.println("Животные не ели!");
                        }
                    }
                }while (!eatBoolean());
            }
        }
    }
    protected static int satiety(int b){
        int satiety;
        if(b==0){
            return satiety=random.nextInt(29)+1;
        }else if(b==1){
            return satiety=random.nextInt(24)+1;
        }
        return 0;
    }
    protected static void printPet(){
        for (int i = 0; i < petListnew.length ; i++) {
            System.out.println((i+1) +" "+ petListnew[i].toString());
        }
    }
    protected static boolean eatBoolean(){
        int p=0;
        for (int i = 0; i < petListnew.length ; i++) {
            if((petListnew[i].lifeStatus).equals(lifeStatus[1])){
                p++;
            }
            if(p==petListnew.length){
                return false;
            }
        }
        return true;
    }
    protected static boolean eatBoolean(int i){
        if((petListnew[i].lifeStatus).equals(lifeStatus[1])){
            return false;
        }
        return true;
    }
    protected  void fillThePlates(){
        int s;
        for (int i = 0; i < petListnew.length; i++) {
            if (pl1.getVolume()>0&&(pl1.getVolume()-petListnew[i].getSatiety())>0){
                s=pl1.getVolume()-petListnew[i].getSatiety();
                pl1.setVolume(s);
                System.out.println("Питомец "+petListnew[i].satietyMass()+"съел. Осталось в миске:"+pl1.getVolume());
                petListnew[i].setSatiety(lifeStatus[0]);
            }else{
                System.out.println("В миске мало еды");
                break;
            }
        }
    }
    protected void refillingTheBowl(Scanner scanner){
        int x;
        System.out.println("Сколько положить еды в миску?");
        x = scanner.nextInt();
        pl1.setVolume(x);
    }
}