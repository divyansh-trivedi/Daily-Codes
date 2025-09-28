class Disjoint{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    int findParent(int n){
        if(n == parent.get(n))return n;

        int up = findParent(parent.get(n));
        parent.set(n,up);
        return up;
    } 
    void unionBySize(int u, int v){
        int upu = findParent(u);
        int upv = findParent(v);

        if(upu == upv)return ;

        if(size.get(upu) > size.get(upv)){
            parent.set(upv, upu);
            size.set(upu ,size.get(upu)+size.get(upv));
        }else{
            parent.set(upu, upv);
            size.set(upv ,size.get(upu)+size.get(upv));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint ds = new Disjoint(n);
        HashMap<String, Integer> map1 = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);// mail
                if(map1.containsKey(mail))
                ds.unionBySize(i,map1.get(mail));// 1->0 ,2,3
                else map1.put(mail,i);//johsmith -> 0 | johnny -> 0; | john00 -> 1| mary->2|johnbrv->3

            }
        }
        List<List<String>> ans = new ArrayList<>();
        HashMap<Integer, List<String>> map2 = new HashMap<>();

        for(String mail : map1.keySet()){
            int root = ds.findParent(map1.get(mail));//root = 0; 
            map2.putIfAbsent(root, new ArrayList<>());
            map2.get(root).add(mail);// map2 = 0 -> js ,jny ,j00 | 2-mary | 3- jb
        }
        for(int it : map2.keySet()){
            List<String> temp =  map2.get(it);//js ,jny ,j00
            Collections.sort(temp);
            temp.add(0, accounts.get(it).get(0)); //
            ans.add(temp);//[john,js ,jny ,j00]
        }
        return ans;
    }
}