class Disjoint {
    List<Integer> size = new ArrayList<>(), parent = new ArrayList<>();
    public Disjoint(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(0);
            parent.add(i);
        }
    }
    public int findParent(int node) {
        if (node == parent.get(node)) return node;
        parent.set(node, findParent(parent.get(node)));
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int pu = findParent(u), pv = findParent(v);
        if (pu != pv) {
            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n= accounts.size();
        Disjoint ds = new Disjoint(n);
        HashMap<String ,Integer> map1 = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(map1.containsKey(mail))
                ds.unionBySize(i,map1.get(mail));
                else
                map1.put(mail,i);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        HashMap<Integer, List<String>> map2 = new HashMap<>();

        for(Map.Entry<String,Integer> entry : map1.entrySet()){
            String mail= entry.getKey();
            int root = ds.findParent(entry.getValue());
            map2.putIfAbsent(root, new ArrayList<>());
            map2.get(root).add(mail);
        }

        for(int key : map2.keySet()){
            List<String> emails = map2.get(key);
            
            Collections.sort(emails);
            emails.add(0,accounts.get(key).get(0));
            ans.add(emails);
        }
        return ans;
    }
}