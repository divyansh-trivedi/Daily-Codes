class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> list1 = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<String> list2 = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");
        for(String category : list2)
        map.put(category, new ArrayList<>());
        for(int i=0; i<code.length;i++){
            if(isActive[i]&& code[i] != null&& code[i].matches("[a-zA-Z0-9_]+")
                && map.containsKey(businessLine[i]))
            map.get(businessLine[i]).add(code[i]);  
        }
        for(String category : list2){
            List<String> codes = map.get(category);
            Collections.sort(codes);
            list1.addAll(codes);
        }
        return list1;
    }
}