public class AddInt{
    public static void main(String[] args) {
        int n;
        int sum = 0;
        n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++){
            int value;
            value = StdIn.readInt();
            sum = sum + value;
            // System.out.println(value);
        }
        System.out.println(sum);
    }
}

