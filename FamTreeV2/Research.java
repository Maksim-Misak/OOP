package FamTreeV2;

import java.util.ArrayList;

public class Research {
    ArrayList<String[]> data;
    int id;
    ArrayList<Integer> childrenIds;

    public Research(ArrayList<String[]> data) {
        this.data = data;
    }

    public ArrayList<Integer> children(int id) {
        childrenIds = new ArrayList<>();
        String[] parent = new String[2];
        for (String[] strings : data) {
            if (Integer.parseInt(strings[0]) == id) {
                parent[0] = strings[2];
                parent[1] = strings[4];
            }
        }
        for (String[] strings : data) {
            switch (parent[1]) {
                case "male":
                    if (Integer.parseInt(strings[6]) == id) {
                        childrenIds.add(Integer.parseInt(strings[0]));
                    }
                    break;

                default:
                    if (Integer.parseInt(strings[5]) == id) {
                        childrenIds.add(Integer.parseInt(strings[0]));
                    }
                    break;
            }
        }
        return childrenIds;
    }

    public ArrayList<Integer> grandChildren(ArrayList<Integer> parents) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        ArrayList<Integer> abba = new ArrayList<>();
        for (Integer i : parents) {
            r.add(children(i));
        }
        for (ArrayList<Integer> b : r) {
            for (Integer i : b) {
                abba.add(i);
            }
        }
        return abba;
    }

    public void researchHeritage(int id) {
        String name = "";
        ArrayList<Integer> children = children(id);
        ArrayList<Integer> grandchildren = grandChildren(children);
        for (String[] strings : data) {
            if (Integer.parseInt(strings[0]) == id) {
                name = strings[2];
            }
        }
        if (children.isEmpty()) {
            System.out.printf("No children for %s", name);
        } else {
            System.out.printf("%s's children: \n", name);
            for (String[] strings : data) {
                for (Integer i : children) {
                    if (i == Integer.parseInt(strings[0])) {
                        System.out.printf(" %s %s \n", strings[1], strings[2]);
                    }
                }
            }

            if (grandchildren.isEmpty()) {
                System.out.printf("No grandchildren for %s", name);
            } else {
                System.out.printf("%s's grandchildren: \n", name);
                for (String[] strings : data) {
                    for (Integer i : grandchildren) {
                        if (i == Integer.parseInt(strings[0])) {
                            System.out.printf(" %s %s \n", strings[1], strings[2]);
                        }
                    }
                }
            }
        }

    }
}
