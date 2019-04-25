public class Fibonacci {
//    static int[] fib_seq;
    static StringBuilder[] fib_seq;
    public static void main(String[] args){
        Fibonacci fib = new Fibonacci();
        fib.of(200);                            //计算数列, 填充到fib_seq
        for(int i = 1; i <= 200; ++i){
            System.out.println(i + ":" +fib_seq[i]);
        }
    }
    public static StringBuilder of(int n){
        /*
        Args:
            n: 数列的第n个数
        Returns:
            result: char[]类型, 数列的第n个数
        */
        if(n<=0){
            return new StringBuilder("0");            //非法输入, 返回0值字符串
        }
        fib_seq = new StringBuilder[n+1];     //为方便理解, 数组从下标为1开始, 数组初始化为0字符
        for(int i = 0; i < n+1; ++i){
            fib_seq[i] = new StringBuilder("0");
            }
        recursive(n);
//        loop(n);
        for(int i = 0; i < n+1; ++i){
            fib_seq[i].reverse();
        }
        return  fib_seq[n];
    }
    //递归
    public static void  recursive(int n) {
        if(1 == n || 2 == n){
            if (fib_seq[n].toString().equals("0")){
                fib_seq[n].setCharAt(0, '1');
            }
        }
        else{
            if (fib_seq[n].toString().equals("0")){
                recursive(n - 1);
                recursive(n - 2);
                fib_seq[n] = add(fib_seq[n-1], fib_seq[n-2]);
            }
        }
    }

    //循环
    public static void loop(int n){
//        if(n>=47){
//            System.out.println("the input number can not bigger than 46");
//        }
        fib_seq[1] = new StringBuilder("1");
        fib_seq[2] = new StringBuilder("1");
        for(int i = 3; i<=200; ++i){
            fib_seq[i] = add(fib_seq[i-1], fib_seq[i-2]);
        }
    }

    private static StringBuilder add(StringBuilder fpre1, StringBuilder fpre2) {
        int nTakeover = 0;
        int len_pre1 = fpre1.length();
        int len_pre2 = fpre2.length();

        int i = 0;
        int x = 0;
        int y = 0;
        int sum = 0;

        StringBuilder fmin = new StringBuilder(fpre1);
        StringBuilder fmax = new StringBuilder(fpre2);
        if (len_pre1 > len_pre2){
            fmin = new StringBuilder(fpre2);
            fmax = new StringBuilder(fpre1);
        }
        for (; i < fmax.length(); ++i){
            x = 0;
            if (i < fmin.length()){
                x = fmin.charAt(i) - '0';
            }
            y = fmax.charAt(i) - '0';
            sum = x + y + nTakeover;
            nTakeover = 0;
            if (sum >= 10){
                nTakeover = 1;
                sum %= 10;
            }
            fmax.setCharAt(i, (char) ('0'+sum));
        }
        if(nTakeover > 0){
            fmax.append('1');
        }
        return fmax;
    }

}
