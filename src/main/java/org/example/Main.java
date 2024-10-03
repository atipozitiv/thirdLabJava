package org.example;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CollectsFirstTask(30);
        PrimesGenSecondTask();
        ArraysThirdTask();
        WordsCountFourthTask("Hello bubabi duda didi duda bom bom Bom");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("dsf", 1);
        map.put("aaa", 2);
        map.put("ccc", 3);
        map.put("bbb", 4);
        System.out.println("5 задание:\n" + map);
        System.out.println(SwitchMapFifthTask(map));
    }

    public static void CollectsFirstTask(int elementsCount) {
        int[] myArray = new int[elementsCount];                     //a
        for (int turn = 0; turn < elementsCount; ++turn) {
            Random random = new Random();
            myArray[turn] = random.nextInt(0, 100);
            System.out.print(myArray[turn] + " ");
        }
        System.out.println("\nмассив из N чисел\n");

        ArrayList<Integer> myList = new ArrayList<>();              //b
        for (int turn = 0; turn < elementsCount; ++turn) {
            myList.add(myArray[turn]);
        }
        System.out.println(myList + "\nЛист на основе массива\n");

        Collections.sort(myList);                                    //c
        System.out.println(myList + "\nОтсортированный список\n");

        Collections.reverse(myList);                                 //d
        System.out.println(myList + "\nОтсортированныый в обратном порядке список\n");

        Collections.shuffle(myList);                                 //e
        System.out.println(myList + "\nПеремешенный список\n");

        Collections.rotate(myList, 1);                       //f
        System.out.println(myList + "\nСдвинутый на 1 элемент список\n");

        ArrayList<Integer> listWithoutRepeats = new ArrayList<>();   //g
        for (int turn = 0; turn < myList.size(); ++turn) {
            if (!listWithoutRepeats.contains(myList.get(turn))) {
                listWithoutRepeats.add(myList.get(turn));
            }
        }
        System.out.println(listWithoutRepeats + "\nСписок только с уникальными элементами\n");

        ArrayList<Integer> listWithRepOnly = new ArrayList<>();      //h
        for (int turn = 0; turn < myList.size(); ++turn) {
            if ((Collections.frequency(myList, myList.get(turn)) > 1) && (!listWithRepOnly.contains(myList.get(turn)))) {
                listWithRepOnly.add(myList.get(turn));
            }
        }
        System.out.println(listWithRepOnly + "\nСписок только с дублирующимеся элементами\n");

        int[] mySecondArray = new int[myList.size()];                 //i
        for (int turn = 0; turn < mySecondArray.length; ++turn) {
            mySecondArray[turn] = myList.get(turn);
            System.out.print(mySecondArray[turn] + " ");
        }
        System.out.println("\nМассив из списка\n");

        int[][] arrayWithFrequency = new int[listWithoutRepeats.size()][2];     //j
        int step = 0;
        for (int turn = 0; turn < mySecondArray.length; ++turn) {
            if (turn == myList.indexOf(mySecondArray[turn])) {
                arrayWithFrequency[turn - step][0] = mySecondArray[turn];
                arrayWithFrequency[turn - step][1] = Collections.frequency(myList, myList.get(turn));
                System.out.println(arrayWithFrequency[turn - step][0] + "   Количество: " + arrayWithFrequency[turn - step][1]);
            } else {
                step += 1;
            }
        }
        System.out.println("Элементы с количеством вхождений\n\n\n");
    }


    public static void PrimesGenSecondTask() {
        System.out.println("Второе задание:\n");
        PrimesGenerator primesGenerator = new PrimesGenerator(10);
        PrimesGeneratorTest primesGeneratorTest = new PrimesGeneratorTest(primesGenerator);
        primesGeneratorTest.showArray();
        primesGeneratorTest.showReverseArray();
        System.out.println("\n\n\n");
    }


    public static void ArraysThirdTask() {
        System.out.println("3 задание:");
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Мария", "Захарова", 26));
        humans.add(new Human("Дарья", "Пшеничная", 21));
        humans.add(new Human("Максим", "Черевичко", 25));
        humans.add(new Human("Илья", "Копучин", 29));
        HashSet<Human> hashSet = new HashSet<>(humans);
        System.out.println(hashSet);
        LinkedHashSet<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println(linkedHashSet);
        TreeSet<Human> treeSet = new TreeSet<>(humans);
        System.out.println(treeSet);
        TreeSet<Human> emptyTreeSet = new TreeSet<>(new HumanComporatorByLastName());
        emptyTreeSet.addAll(humans);
        System.out.println(emptyTreeSet);
        TreeSet<Human> emptyAnonTreeSet = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                if (o1.age > o2.age) {
                    return 1;
                }
                if (o1.age < o2.age) {
                    return -1;
                }
                return 0;
            }
        });
        emptyAnonTreeSet.addAll(humans);
        System.out.println(emptyAnonTreeSet);
        //Сет с компоратором по возрасту вывелся подругому, но тоже отсортировал неправильно, сравнение по фамилии не работает, java не скажет какая строка больше или меньше, только найдет одинаковые.
    }


    public static void WordsCountFourthTask(String input) {
        System.out.println("\n\n\n4 задание:");
        input = input.toLowerCase();
        HashMap<String, Integer> myHashMap = new HashMap<>();
        String[] inputToWords = input.split(" ");
        for (int turn = 0; turn < inputToWords.length; ++turn) {
            myHashMap.put(inputToWords[turn], myHashMap.getOrDefault(inputToWords[turn], 0) + 1);
        }
        System.out.println(myHashMap + "\n\n\n");
    }


    public static <K, V> HashMap<V, K> SwitchMapFifthTask(HashMap<K, V> inputMap) {
        HashMap<V, K> switchedMap = new HashMap<>();
        for (Map.Entry<K, V> entryMap : inputMap.entrySet()) {
            K k = entryMap.getKey();
            V v = entryMap.getValue();
            switchedMap.put(v, k);
        }
        return switchedMap;
    }
}