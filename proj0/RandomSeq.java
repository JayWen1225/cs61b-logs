public class RandomSeq{
    public static void main(String[] args) {
        int n=1;
        n = Integer.parseInt(args[0]);
        for ( int i = 0; i < n; i++){
            System.out.println(Math.random());
        }
    }
}