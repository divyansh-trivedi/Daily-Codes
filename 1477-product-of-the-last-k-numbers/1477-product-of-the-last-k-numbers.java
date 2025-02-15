class ProductOfNumbers {
    private static int product;
    ArrayList<Integer> list;
    private static int cnt;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        product = 1;
        cnt = 0;
    }
    
    public void add(int num) {
        list.add(num);
        cnt++;
    }
    
    public int getProduct(int k) {
        product =1;
        for(int i = cnt -k ;i<list.size();i++)
        product *= list.get(i);
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */