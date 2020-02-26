import java.util.List;
import java.util.ArrayList;

public class HelloWorld {
    public enum NormalFruits {banana, apple, orange, pear, grapes}
    public enum ExoticFruits {mango, durian, jackfruit, lychee};

    public class FruitStore<Fruits extends Enum<Fruits>> {
        private Class<Fruits> FruitClass = null;
        public FruitStore() {}

        public FruitStore(Class<Fruits> FruitClass) {
            this.FruitClass = FruitClass;
        }

        public Fruits getFruit(String fruitName) {
            Fruits fruit = Enum.valueOf(FruitClass, fruitName);
            return fruit;
        }
    }

    public class FruitBowl<Fruits extends Enum<Fruits>> {
        private List<Fruits> bowl = new ArrayList<Fruits>();

        private Class<Fruits> FruitClass = null;
        public FruitBowl() {}

        public FruitBowl(Class<Fruits> FruitClass) {
            this.FruitClass = FruitClass;
        }
        public void addFruit(Fruits fruit) {
            bowl.add(Enum.valueOf(FruitClass, "pear"));
            bowl.add(fruit);
        }

        public Fruits getFirstFruit() {
            return bowl.get(0);
        }

        public String marshalForServiceCall() {
            return bowl.toString();
        }

        public void unmarshalFromServiceCall(String response, Class<Fruits> FruitsClass) {
            bowl.clear();

            String [] fruits = response.split(",");
            for (String fruitName : fruits) {
//                Fruits fruit = Fruits.valueOf(fruitName);
                Fruits fruit = Enum.valueOf(FruitsClass, fruitName);
                bowl.add(fruit);
            }
        }
    }

    public void example1() {
        FruitBowl<NormalFruits> bowl = new FruitBowl<NormalFruits>();
        bowl.addFruit(NormalFruits.apple);
        bowl.addFruit(NormalFruits.pear);
        bowl.addFruit(NormalFruits.orange);

        NormalFruits fruit = bowl.getFirstFruit();
       // System.out.println(fruit.toString());
        //System.out.println(bowl.marshalForServiceCall());
    }

    public void example2() {
        FruitBowl<NormalFruits> bowl = new FruitBowl<NormalFruits>();
        bowl.unmarshalFromServiceCall("orange,apple,pear", NormalFruits.class);

       // System.out.println(bowl.getFirstFruit());
    }

    public void example3() {
        FruitStore store = new FruitStore<>(NormalFruits.class);
        System.out.println(store.getFruit("ekgBE"));

        Enum<NormalFruits> fruit = store.getFruit("");
        System.out.println(fruit);

        FruitStore<NormalFruits> store1 = new FruitStore<>();
        System.out.println(store1.getFruit("JWG"));

        NormalFruits fruit1 = store1.getFruit("pear");
        System.out.println(fruit1);
    }

    public void exmaple4() {
        FruitBowl<NormalFruits> bowl = new FruitBowl(NormalFruits.class);
        bowl.addFruit(NormalFruits.apple);
        bowl.addFruit(NormalFruits.pear);
        bowl.addFruit(NormalFruits.orange);

        NormalFruits fruit = bowl.getFirstFruit();
    }

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        //hello.example1();
        //hello.example2();
        //hello.example3();
        hello.exmaple4();
    }

}