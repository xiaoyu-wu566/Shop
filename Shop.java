//Name: Xiaoyu Wu         UIN: 727001036
//        acknowledgements of any help received: Book: The Java Programming language
//        https://www.geeksforgeeks.org/iterators-in-java/
//        https://en.wikipedia.org/wiki/Generics_in_Java
//        https://www.javatpoint.com/collections-in-java
//        https://www.geeksforgeeks.org/remove-element-arraylist-java/
//        https://stackoverflow.com/questions/2778592/how-do-i-pass-an-arraylist-to-method-that-takes-a-collection-as-an-input
//        https://docs.oracle.com/javase/tutorial/java/data/numberclasses.html
//        https://stackoverflow.com/questions/1268817/create-new-class-from-a-variable-in-java
//        https://www.geeksforgeeks.org/new-operator-vs-newinstance-method-java/


import java.util.*;


class Shop<T> {
    Collection<T> stock;

    public Shop() {
        stock = new java.util.LinkedList<T>();
    }

//    public Shop(Collection<? extends T> stock) throws Exception {
//        Class c = stock.getClass();
//        Class[] cArg = new Class[1];
//        cArg[0] = Collection.class;
//        Constructor ct = c.getDeclaredConstructor(cArg);
//        this.stock = (Collection<T>) ct.newInstance(stock);
//    }

    void sell(T item) {
        stock.add(item);
    }

    public T buy()
    {
        T item;
        Iterator<T> it = stock.iterator();
        // assume the stock is not empty
        item = it.next();
        it.remove();
        return item;

    }

    void sell(Collection<? extends T> items) {
        for (T e : items) {
            stock.add(e);
        }
    }

    void buy(int n, Collection<? extends T> items)  {
        Collection<T> new_items;
        // have to cast here otherwise java complains
        new_items= (Collection<T>) items;

        int count = 1;
        for (T e : stock) {
            new_items.add(e);

            ++count;
            if (count > n) {
                break;
            }
        }
        count = 1;
        Iterator<T> it = stock.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
            ++count;
            if (count > n) {
                break;
            }
        }

    }

    public String toString() {
        return stock.toString();
    }

}



class ShopTest
{
    public static void main(String[] args){
        ArrayList<Integer> a =new ArrayList<Integer>();
        LinkedList<Long> b =new LinkedList<Long>();
        HashSet<Double> c= new HashSet<Double>();

        a.add(1);
        a.add(2);

        b.add(3L);
        b.add(4L);

        c.add(5.0);
        c.add(6.0);

        Shop<Number> shop1 = new Shop<Number>();
        shop1.sell(a);
        shop1.sell(b);
        shop1.sell(c);
        System.out.println(shop1);

        shop1.buy();
        System.out.println(shop1);

        shop1.buy(2, b);
        shop1.buy(1,c);

        System.out.println(shop1);

    }

}

