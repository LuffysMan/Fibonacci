Public class Fibonacci{
	public static void main(String[] args){
		/*打印Fibonacci数列1~200数列, 使用循环
		*/
		int[] f = new int(2);
		int fcur = 0;
		f[0]=f[1]=1;
		for(int i = 0; i < 200; ++i){
			if(i>=2){
				int fcur = f[0] + f[1];
				System.out.printf(fcur);
				f[0] = f[1];
				f[1] = fcur;
			}
			else{
				System.out.printf(f[i]);
			}
		}
	}

	public static int of(int n){
		/*返回Fibonacci数列的第n个数字
		Args: 
			n: 正整数, 表示需要返回数列的第几个数
		Returns:
			result: 正整数, 数列的第n个数; -1表示失败
		*/
		//判断无效输入
		if(n<1){
			return -1
		}
		//使用递归
		if(1 == n || 2 == n){
			return 1
		}
		else{
			return of(n-1) + of(n -2)
		}
	}
}