package unit05.mcf;

public class ForEach {
    public static void forArray(String[] aray){
        for(String element : aray){
            System.out.println(element);
        }
    }

    public static void forList(List<String> listo){
        for(String element: listo){
            System.out.println(element);
        }
    }

    public static void forQueue(Queue<String> queue){
        for(String element: queue){
            System.out.println(element);
        }
    }


    public static void main(String[] args){
        String[] ray = {"well","im","tired"};
        forArray(ray);
        ArrayList<String> listo = new ArrayList<>();
        listo.append("2");
        listo.append("3");
        forList(listo);
        NodeQueue<String> queue = new NodeQueue<>();
        queue.enqueue("6");
        queue.enqueue("7");
        forQueue(queue);
    }
}
