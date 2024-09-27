class MyCalendar {
  public List<int[]> bookings;
    public MyCalendar() {
       bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
       for(int [] i: bookings){
        int startb=i[0];
        int endb=i[1];

        if(start<endb&&startb<end)return false;
       }
       bookings.add(new int[]{start,end});
       return true;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */