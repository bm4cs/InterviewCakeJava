package net.bencode.interviewcake.treesandgraphs;

import java.util.*;

public class MeshMessage {



    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

        if (startNode.equals(endNode)) {
            return new String[] { startNode };
        }

        if (!graph.containsKey(endNode)) {
            throw new RuntimeException("End node will never be found");
        }

        // find the shortest route in the network between the two users

//        return new HashMap<String, String[]>() { {
//            put("a", new String[] {"b", "c", "d"});
//            put("b", new String[] {"a", "d"});
//            put("c", new String[] {"a", "e"});
//            put("d", new String[] {"a", "b"});
//            put("e", new String[] {"c"});
//            put("f", new String[] {"g"});
//            put("g", new String[] {"f"});
//        }};

        List<String> shortestPath = new LinkedList<>();

        Queue<String> nodesToVisitQueue = new LinkedList<>();
        nodesToVisitQueue.add(startNode);

        Map<String, String> nodesTravelled = new HashMap<>();
        nodesTravelled.put(startNode, null);

        while (!nodesToVisitQueue.isEmpty()) {

            String currentNode = nodesToVisitQueue.remove();

            for (String neighbor : graph.get(currentNode)) {

                if (neighbor.equals(endNode)) {
                    nodesTravelled.put(neighbor, currentNode);
                    break;
                }

                if (!nodesTravelled.containsKey(neighbor)) {
                    nodesTravelled.put(neighbor, currentNode);
                    nodesToVisitQueue.add(neighbor);
                }
            }
        }

        String currentNode = endNode;

        while (currentNode != null) {
            shortestPath.add(currentNode);

            if (!nodesTravelled.containsKey(currentNode)) {
                return null;
            }

            currentNode = nodesTravelled.get(currentNode);
        }

        Collections.reverse(shortestPath);
        return shortestPath.toArray(new String[shortestPath.size()]);
    }



}
