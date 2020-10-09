import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random random = new Random();
    public static Scanner scanner=new Scanner(System.in);

    protected static Pet[] petListnew;

    protected static String[] petName={"Вася","Коля","Лена","Аня","Даша","Маша","Игорь","Витя","Митя"};
    protected static String[] petColor={"Крассный","Синий","Зеленый","Желтый"};

    protected static String[] lifeStatus ={"a live", "dead"};
//    protected static String[] let={"river","mountain","plain"};

    public static void main (String [] args){
        int h=0;
        System.out.println("Какое колличество животных позвать?");
        h=scanner.nextInt();
        petListnew=new Pet[h];
        spavnPet();
    }
    public static void spavnPet(){
        int x,y;
        int b=0;
        for (int i = 0; i < petListnew.length; i++) {
            x= random.nextInt(petName.length);
            y= random.nextInt(petColor.length);
            if(b==0){
                petListnew[i]=new Dog(petName[x],petColor[y],lifeStatus[0],limitationRun(b),limitationJump(b),limitationSwim(b));
                b=random.nextInt(2);
            }else if(b==1){
                petListnew[i]=new Cat(petName[x],petColor[y],lifeStatus[0],limitationRun(b),limitationJump(b),limitationSwim(b));
                b=random.nextInt(2);
            }
            System.out.println((i+1) +" "+ petListnew[i].toString());
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
    protected static void sayActPet(Scanner scanner){
        int x,y,z;
        float f;
        while (true) {
            System.out.println("Какому питомцу следует выполнить действие?");
            x = scanner.nextInt()-1;
            System.out.println("Питомец №"+(x+1)+" по кличке " + petListnew[x].name );
            System.out.println("Какое действие выполнить питомцу?\n1.run\n2.jump\n3.swim");
            y=scanner.nextInt();

            switch (y){
                case 1:
                    System.out.println("Дистанция бега:");
                    z=scanner.nextInt();
                    petListnew[x].run(z);
                    break;
                case 2:
                    System.out.println("Высота прыжка:");
                    f=scanner.nextFloat();
                    petListnew[x].jump(f);
                    break;
                case 3:
                    System.out.println("Проплыть дистанцию:");
                    z=scanner.nextInt();
                    petListnew[x].swim(z);
                    break;
                default:
                    petListnew[x].stop();
                    break;
            }
        }
    }
}