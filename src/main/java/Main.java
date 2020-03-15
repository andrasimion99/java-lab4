import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) {
//        Resident[] r = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R" + i)).toArray(Resident[]::new);
//
//        Hospital[] h = IntStream.rangeClosed(0, 2).mapToObj(i -> new Hospital("H" + i)).toArray(Hospital[]::new);
//
//        List<Resident> residentList = new ArrayList<>();
//
//        residentList.addAll(Arrays.asList(r));
//
//        Collections.sort(residentList, Comparator.comparing(Resident::getName));
//
//        Set<Hospital> hospitalSet = new TreeSet<>();
//
//        hospitalSet.addAll(Arrays.asList(h));
//
//        System.out.println(residentList);
//
//        System.out.println(hospitalSet);
//
//        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
//
//        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
//        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
//        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
//        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));
//
//        resPrefMap.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });
//
//        System.out.println();
//
//        Map<Hospital, List<Resident>> hosPrefMap = new TreeMap<>();
//
//        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
//        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
//        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));
//
//        hosPrefMap.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });
//
//        System.out.println();
//
//        List<Hospital> target = Arrays.asList(h[0], h[2]);
//
//        List<Resident> result = residentList.stream().filter(res -> resPrefMap.get(res).containsAll(target)).collect(Collectors.toList());
//
//        System.out.println(result);
//
//        hospitalSet.stream().filter(hos -> hosPrefMap.get(hos).get(0).equals(r[0])).forEach(System.out::print);
//

        Faker faker = new Faker();

        Element[] r = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident(Faker.instance().cat().name())).toArray(Resident[]::new);

        Element h0 = new Hospital(Faker.instance().gameOfThrones().house(), 1);
        Element h1 = new Hospital(Faker.instance().gameOfThrones().house(), 2);
        Element h2 = new Hospital(Faker.instance().gameOfThrones().house(), 2);

        List<Element> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));

        List<Element> hospitalList = new ArrayList<>();
        hospitalList.addAll(Arrays.asList(h0, h1, h2));

        r[0].setPrefList(Arrays.asList(h0, h1, h2));
        r[1].setPrefList(Arrays.asList(h0, h1, h2));
        r[2].setPrefList(Arrays.asList(h0, h1));
        r[3].setPrefList(Arrays.asList(h0, h2));

        h0.setPrefList(Arrays.asList(r[3], r[0], r[1], r[2]));
        h1.setPrefList(Arrays.asList(r[0], r[2], r[1]));
        h2.setPrefList(Arrays.asList(r[0], r[1], r[3]));

        Partition p1 = new Partition(residentList);
        Partition p2 = new Partition(hospitalList);

        Problem pb = new Problem(p1, p2);

        /**
         * afisam solutia finala de matching "key": "value"
         */
        Map<Element, Element> solution = new HashMap<>();
        solution = pb.getSolution();
        solution.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        boolean ok = true;
        /**
         * maching-ul este stabil daca toate perechile din mapa finala sunt astfel:
         * in lista de preferinte a fiecarei "key" se gaseste "value"
         * &&
         * in lista de preferinte a fiecarei "value" se gaseste "key",
         * altfel matching-ul nu este stabil
         */
        for (Element key : solution.keySet()) {
            if (!key.getPrefList().contains(solution.get(key)) || !solution.get(key).getPrefList().contains(key)) {
                System.out.println("The matching is not stable");
                ok = false;
                break;
            }
        }

        if (ok) {
            System.out.println("The matching is stable");
        }

    }
}
